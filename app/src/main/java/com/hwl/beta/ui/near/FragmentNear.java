package com.hwl.beta.ui.near;

import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.hwl.beta.R;
import com.hwl.beta.databinding.NearFragmentMainBinding;
import com.hwl.beta.db.entity.NearCircle;
import com.hwl.beta.db.entity.NearCircleComment;
import com.hwl.beta.db.entity.NearCircleImage;
import com.hwl.beta.db.entity.NearCircleLike;
import com.hwl.beta.emotion.EmotionDefaultPanelV2;
import com.hwl.beta.sp.AppInstallStatus;
import com.hwl.beta.sp.MessageCountSP;
import com.hwl.beta.ui.common.BaseFragment;
import com.hwl.beta.ui.common.KeyBoardAction;
import com.hwl.beta.ui.common.UITransfer;
import com.hwl.beta.ui.dialog.LoadingDialog;
import com.hwl.beta.ui.ebus.EventBusConstant;
import com.hwl.beta.ui.ebus.EventMessageModel;
import com.hwl.beta.ui.entry.ActivityMain;
import com.hwl.beta.ui.imgselect.ActivityImageBrowse;
import com.hwl.beta.ui.near.action.INearCircleItemListener;
import com.hwl.beta.ui.near.adp.NearCircleAdapter;
import com.hwl.beta.ui.near.logic.NearLogic;
import com.hwl.beta.ui.near.standard.NearStandard;
import com.hwl.beta.ui.widget.CircleActionMorePop;
import com.hwl.beta.utils.NetworkUtils;
import com.hwl.beta.utils.StringUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/12/27.
 */

public class FragmentNear extends BaseFragment {

    NearFragmentMainBinding binding;
    FragmentActivity activity;
    NearCircleAdapter nearCircleAdapter;
    NearStandard nearStandard;
    EmotionPanelListener emotionPanelListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        nearStandard = new NearLogic();
        binding = DataBindingUtil.inflate(inflater, R.layout.near_fragment_main, container, false);

        initView();

        return binding.getRoot();
    }

    @Override
    protected void onFragmentFirstVisible() {
        binding.pbLoading.setVisibility(View.VISIBLE);
        loadLocalInfos();
    }

    private void loadLocalInfos() {
        nearStandard.loadLocalInfos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<NearCircle>>() {
                    @Override
                    public void accept(List<NearCircle> infos) {
                        binding.pbLoading.setVisibility(View.GONE);
                        nearCircleAdapter.updateInfos(infos);

                        loadServerInfos(0);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        binding.pbLoading.setVisibility(View.GONE);
                        Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        nearCircleAdapter = new NearCircleAdapter(activity, null, new NearCircleItemListener());
        binding.rvNearContainer.setAdapter(nearCircleAdapter);
        binding.rvNearContainer.setLayoutManager(new LinearLayoutManager(activity));

        binding.refreshLayout.setEnableLoadMore(false);
        binding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loadServerInfos(0);
            }
        });
        binding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                loadServerInfos(nearCircleAdapter.getMinId());
            }
        });

        binding.llMessageTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UITransfer.toNearMessagesActivity(activity);
            }
        });

        emotionPanelListener = new EmotionPanelListener();
        binding.ecpEmotion.setLocalSoftInputHeight(AppInstallStatus.getSoftInputHeight())
                .setContentContainerView(binding.refreshLayout)
                .setEmotionPanelListener(emotionPanelListener);

        binding.refreshLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                binding.ecpEmotion.setContentContainerHeight(binding.refreshLayout.getHeight());
            }
        });
    }

    public void setEmotionStatus(boolean isShow) {
        setEmotionStatus(isShow, null);
    }

    public void setEmotionStatus(boolean isShow, String hintText) {
        ActivityMain parentActivity = (ActivityMain) getActivity();
        if (isShow) {
            parentActivity.setBottomNavVisibility(false);
            binding.ecpEmotion.showKeyboard();
            binding.ecpEmotion.setVisibility(View.VISIBLE);
        } else {
            parentActivity.setBottomNavVisibility(true);
            binding.ecpEmotion.hideEmotionPanel();
            binding.ecpEmotion.setVisibility(View.GONE);
        }
        binding.ecpEmotion.setHintMessage(hintText);
    }

    private void loadServerInfos(long infoId) {
        if (!NetworkUtils.isConnected()) {
            showResult();
            return;
        }

        final boolean isRefresh = infoId == 0;
        nearStandard.loadServerInfos(infoId, nearCircleAdapter.getInfos())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<NearCircle>>() {
                    @Override
                    public void accept(List<NearCircle> infos) {
                        nearCircleAdapter.updateInfos(isRefresh, infos);
                        showResult();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        showResult();
                        Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showResult() {
        if (nearCircleAdapter.getItemCount() <= 0) {
            nearCircleAdapter.setEmptyInfo();
            binding.refreshLayout.setEnableLoadMore(false);
        }
        binding.refreshLayout.finishRefresh();
        binding.refreshLayout.finishLoadMore();
        binding.pbLoading.setVisibility(View.GONE);
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void receiveEventMessage(EventMessageModel messageModel) {
        if (messageModel.getMessageType() == EventBusConstant.EB_TYPE_NEAR_CIRCLE_MESSAGE_UPDATE) {
            int count = MessageCountSP.getNearCircleMessageCount();
            if (count > 0) {
                binding.llMessageTip.setVisibility(View.VISIBLE);
                binding.tvMessageCount.setText(count + "");
            } else {
                binding.llMessageTip.setVisibility(View.GONE);
            }
        }
    }

    private class EmotionPanelListener implements EmotionDefaultPanelV2.IEmotionPanelListener {
        private int position;
        private NearCircle info;

        public void setNearCircleInfo(int position, NearCircle info) {
            this.position = position;
            this.info = info;
        }

        @Override
        public void cancelClick() {
            setEmotionStatus(false);
        }

        @Override
        public boolean sentClick(String content) {
            if (StringUtils.isBlank(content)) {
                Toast.makeText(activity, "发送的内容不能为空", Toast.LENGTH_SHORT).show();
                return false;
            }

            LoadingDialog.show(activity, "正在发送,请稍后...");
            nearStandard.addComment(info, content, 0)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<NearCircleComment>() {
                        @Override
                        public void accept(NearCircleComment info) throws Exception {
                            setEmotionStatus(false);
                            LoadingDialog.hide();
                            nearCircleAdapter.addComment(info);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) {
                            LoadingDialog.hide();
                            Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

            return true;
        }
    }

    private class NearCircleItemListener implements INearCircleItemListener {

        private CircleActionMorePop mMorePopupWindow;
        private boolean isRunning = false;

        @Override
        public void onItemViewClick(View view) {
            KeyBoardAction.hideSoftInput(view);
        }

        @Override
        public void onUserHeadClick(NearCircle info) {
            UITransfer.toUserIndexActivity(activity, info.getPublishUserId(),
                    info.getPublishUserName(), info.getPublishUserImage());
        }

        @Override
        public void onLikeUserHeadClick(NearCircleLike likeInfo) {
            UITransfer.toUserIndexActivity(activity, likeInfo.getLikeUserId(),
                    likeInfo.getLikeUserName(), likeInfo.getLikeUserImage());
        }

        @Override
        public void onCommentUserClick(NearCircleComment comment) {
            UITransfer.toUserIndexActivity(activity, comment.getCommentUserId(),
                    comment.getCommentUserName(), comment.getCommentUserImage());
        }

        @Override
        public void onReplyUserClick(NearCircleComment comment) {
            UITransfer.toUserIndexActivity(activity, comment.getReplyUserId(),
                    comment.getReplyUserName(), comment.getReplyUserImage());
        }

        @Override
        public void onCommentContentClick(NearCircleComment comment) {
            // if (StringUtils.isNotBlank(replyUserName)) {
            // edpEmotion.setHintText("回复 " + replyUserName + " :");
            // } else {
            // edpEmotion.setHintText("输入评论内容");
            // }
//            NearCircleExt currnetInfo = this.getNearCircleInfo(comment.getNearCircleId());
//            if (currnetInfo == null) return;
//            if (comment.getCommentUserId() == myUserId) {
//                UITransfer.toNearCommentPublishActivity(activity, comment.getNearCircleId(),
// currnetInfo.getInfo().getPublishUserId(), currnetInfo.getNearCircleMessageContent());
//            } else {
//                UITransfer.toNearCommentPublishActivity(activity, comment.getNearCircleId(),
// currnetInfo.getInfo().getPublishUserId(), comment.getCommentUserId(), comment
// .getCommentUserName(), currnetInfo.getNearCircleMessageContent());
//            }
        }

        @Override
        public void onContentClick(NearCircle info) {
            UITransfer.toNearDetailActivity(activity, info.getNearCircleId());
        }

        @Override
        public void onMoreActionClick(final View view, int position, final NearCircle info) {
            if (mMorePopupWindow == null) {
                mMorePopupWindow = new CircleActionMorePop(activity);
            }
            mMorePopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    view.setVisibility(View.VISIBLE);
                }
            });
            mMorePopupWindow.setActionMoreListener(new CircleActionMorePop.IActionMoreListener() {
                @Override
                public void onCommentClick(int position) {
                    setEmotionStatus(true, "输入评论内容");
                    emotionPanelListener.setNearCircleInfo(position, info);
                }

                @Override
                public void onLikeClick(int position) {
                    setLike(position, info);
                }
            });
            mMorePopupWindow.show(position, view, info.getIsLiked());
        }

        private void setLike(final int position, NearCircle info) {
            if (isRunning) return;
            isRunning = true;

            final boolean isLike = !info.getIsLiked();
            nearStandard.setLike(info, isLike)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<NearCircleLike>() {
                        @Override
                        public void accept(NearCircleLike info) {
                            isRunning = false;
                            nearCircleAdapter.setLike(position, info,isLike);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) {
                            isRunning = false;
                            Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        @Override
        public void onMoreCommentClick(NearCircle info) {

        }

        @Override
        public void onDeleteClick(final int position, final NearCircle info) {
            new AlertDialog.Builder(activity)
                    .setMessage("信息删除后,不能恢复,确认删除 ?")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deleteCircle(position, info.getNearCircleId());
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
        }

        private void deleteCircle(final int position, long nearCircleId) {
            LoadingDialog.show(activity);
            nearStandard.deleteInfo(nearCircleId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) {
                            nearCircleAdapter.remove(position);
                            LoadingDialog.hide();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) {
                            LoadingDialog.hide();
                            Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        @Override
        public void onPublishClick() {
            UITransfer.toNearPublishActivity(activity);
        }

        @Override
        public void onImageClick(int position, List<NearCircleImage> images) {
            if (images != null && images.size() > 0) {
                List<String> imageUrls = new ArrayList<>(images.size());
                for (int i = 0; i < images.size(); i++) {
                    imageUrls.add(images.get(i).getImageUrl());
                }
                UITransfer.toImageBrowseActivity(activity, ActivityImageBrowse.MODE_VIEW,
                        position, imageUrls);
            }
        }
    }
}
