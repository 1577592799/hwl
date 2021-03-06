package com.hwl.beta.emotion.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hwl.beta.emotion.R;
import com.hwl.beta.emotion.interfaces.IEmotionToolbarListener;

import java.util.ArrayList;

public class EmotionToolBarView extends RelativeLayout {

    protected LayoutInflater mInflater;
    protected Context mContext;
    protected ArrayList<View> mToolBtnList = new ArrayList<>();
    protected int buttonWidth;

    protected HorizontalScrollView hsv_toolbar;
    protected LinearLayout ll_toolbar;
    private IEmotionToolbarListener toolbarListener;

    public EmotionToolBarView(Context context) {
        this(context, null);
    }

    public EmotionToolBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.view_emotion_toolbar, this);
        buttonWidth = (int) context.getResources().getDimension(R.dimen.emotion_toolbar_btn_width);
        hsv_toolbar = findViewById(R.id.hsv_toolbar);
        ll_toolbar = findViewById(R.id.ll_toolbar);

        initEmotionAddButton();
        initEmotionSetButton();
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (getChildCount() > 3) {
            throw new IllegalArgumentException("can host only two direct child");
        }
    }

    public void setEmotionToolbarListener(IEmotionToolbarListener toolbarListener) {
        this.toolbarListener = toolbarListener;
    }

    protected View getCommonButtonView() {
        return mInflater.inflate(R.layout.item_toolbar_button, null);
    }

    private void initEmotionAddButton() {
        View emotionAddButton = getCommonButtonView();
        emotionAddButton.setId(R.id.id_toolbar_left);
        emotionAddButton.findViewById(R.id.view_line_left).setVisibility(GONE);
        emotionAddButton.findViewById(R.id.view_line_right).setVisibility(VISIBLE);
        emotionAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbarListener.onAddClick();
            }
        });
        ImageView ivAdd = emotionAddButton.findViewById(R.id.iv_icon);
        ivAdd.setImageResource(R.drawable.chat_emotion_add);

        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.addRule(ALIGN_PARENT_LEFT);
        addView(emotionAddButton, params);

        LayoutParams hsvParams = (LayoutParams) hsv_toolbar.getLayoutParams();
        hsvParams.addRule(RIGHT_OF, emotionAddButton.getId());
        hsv_toolbar.setLayoutParams(hsvParams);
    }

    private void initEmotionSetButton() {
        View emotionSetButton = getCommonButtonView();
        emotionSetButton.setId(R.id.id_toolbar_right);
        emotionSetButton.findViewById(R.id.view_line_left).setVisibility(VISIBLE);
        emotionSetButton.findViewById(R.id.view_line_right).setVisibility(GONE);
        emotionSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbarListener.onSettingClick();
            }
        });
        ImageView ivSet = emotionSetButton.findViewById(R.id.iv_icon);
        ivSet.setImageResource(R.drawable.chat_emotion_setting);

        LayoutParams setParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        setParams.addRule(ALIGN_PARENT_RIGHT);
        addView(emotionSetButton, setParams);

        LayoutParams hsvParams2 = (LayoutParams) hsv_toolbar.getLayoutParams();
        hsvParams2.addRule(LEFT_OF, emotionSetButton.getId());
        hsv_toolbar.setLayoutParams(hsvParams2);
    }

    public void addItemButton(int res, String tag, View.OnClickListener itemListener) {
        View buttonView = getCommonButtonView();
        ImageView iv_icon = buttonView.findViewById(R.id.iv_icon);
        iv_icon.setImageResource(res);
        iv_icon.setTag(R.id.id_tag_pageset, tag);
        iv_icon.setLayoutParams(new LinearLayout.LayoutParams(buttonWidth,
                LayoutParams.MATCH_PARENT));

        ll_toolbar.addView(buttonView);
        mToolBtnList.add(iv_icon);
        buttonView.setOnClickListener(itemListener);
    }

    public void setSelected(String tag) {
        if (TextUtils.isEmpty(tag)) {
            return;
        }

        int select = 0;
        for (int i = 0; i < mToolBtnList.size(); i++) {
            String currentTag = mToolBtnList.get(i).getTag(R.id.id_tag_pageset).toString();
            if (currentTag.equals(tag)) {
                mToolBtnList.get(i).setBackgroundColor(getResources().getColor(R.color.toolbar_btn_select));
                select = i;
            } else {
                mToolBtnList.get(i).setBackgroundResource(R.drawable.emotion_toolbar_bg);
            }
        }

        scrollToBtnPosition(select);
    }

//    public void addFixedToolItemView(View view, boolean isRight) {
//        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
//                LayoutParams.MATCH_PARENT);
//        LayoutParams hsvParams = (LayoutParams) hsv_toolbar.getLayoutParams();
//        if ((int) view.getId() <= 0) {
//            view.setId(isRight ? R.id.id_toolbar_right : R.id.id_toolbar_left);
//        }
//        if (isRight) {
//            params.addRule(ALIGN_PARENT_RIGHT);
//            hsvParams.addRule(LEFT_OF, view.getId());
//        } else {
//            params.addRule(ALIGN_PARENT_LEFT);
//            hsvParams.addRule(RIGHT_OF, view.getId());
//        }
//        addView(view, params);
//        hsv_toolbar.setLayoutParams(hsvParams);
//    }

//    protected void initItemToolBtn(View toolBtnView, int rec, final PageSetEntity pageSetEntity,
//                                   OnClickListener onClickListener) {
//        ImageView iv_icon = toolBtnView.findViewById(R.id.iv_icon);
//        if (rec > 0) {
//            iv_icon.setImageResource(rec);
//        }
//        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(buttonWidth,
//                LayoutParams.MATCH_PARENT);
//        iv_icon.setLayoutParams(imgParams);
//        if (pageSetEntity != null) {
//            iv_icon.setTag(R.id.id_tag_pageset, pageSetEntity);
//            try {
//                ImageLoader.getInstance(mContext).displayImage(pageSetEntity.getIconUri(),
//                iv_icon);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        toolBtnView.setOnClickListener(onClickListener != null ? onClickListener :
//                new OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (mItemClickListeners != null && pageSetEntity != null) {
//                            mItemClickListeners.onToolBarItemClick(pageSetEntity);
//                        }
//                    }
//                });
//    }
//
//    protected View getToolBgBtn(View parentView) {
//        return parentView.findViewById(R.id.iv_icon);
//    }
//
//    public void addFixedToolItemView(boolean isRight, int rec, final PageSetEntity pageSetEntity,
//                                     OnClickListener onClickListener) {
//        View toolBtnView = getCommonButtonView();
//        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
//                LayoutParams.MATCH_PARENT);
//        LayoutParams hsvParams = (LayoutParams) hsv_toolbar.getLayoutParams();
//        if ((int) toolBtnView.getId() <= 0) {
//            toolBtnView.setId(isRight ? R.id.id_toolbar_right : R.id.id_toolbar_left);
//        }
//        if (isRight) {
//            params.addRule(ALIGN_PARENT_RIGHT);
//            hsvParams.addRule(LEFT_OF, toolBtnView.getId());
//        } else {
//            params.addRule(ALIGN_PARENT_LEFT);
//            hsvParams.addRule(RIGHT_OF, toolBtnView.getId());
//        }
//        addView(toolBtnView, params);
//        hsv_toolbar.setLayoutParams(hsvParams);
//        initItemToolBtn(toolBtnView, rec, pageSetEntity, onClickListener);
//    }
//
//    public void addToolItemView(PageSetEntity pageSetEntity) {
//        addToolItemView(0, pageSetEntity, null);
//    }
//
//    public void addToolItemView(int rec, OnClickListener onClickListener) {
//        addToolItemView(rec, null, onClickListener);
//    }

//    public void addToolItemView(int rec, final PageSetEntity pageSetEntity,
//                                OnClickListener onClickListener) {
//        View toolBtnView = getCommonButtonView();
//        initItemToolBtn(toolBtnView, rec, pageSetEntity, onClickListener);
//        ll_toolbar.addView(toolBtnView);
//        mToolBtnList.add(getToolBgBtn(toolBtnView));
//    }

//    public void setToolBtnSelect(String uuid) {
//        if (TextUtils.isEmpty(uuid)) {
//            return;
//        }
//        int select = 0;
//        for (int i = 0; i < mToolBtnList.size(); i++) {
//            Object object = mToolBtnList.get(i).getTag(R.id.id_tag_pageset);
//            if (object != null && object instanceof PageSetEntity && uuid.equals((
//            (PageSetEntity) object).getUuid())) {
//                mToolBtnList.get(i).setBackgroundColor(getResources().getColor(R.color
//                .toolbar_btn_select));
//                select = i;
//            } else {
//                mToolBtnList.get(i).setBackgroundResource(R.drawable.emotion_toolbar_bg);
//            }
//        }
//        scrollToBtnPosition(select);
//    }

    private void scrollToBtnPosition(final int position) {
        int childCount = ll_toolbar.getChildCount();
        if (position < childCount) {
            hsv_toolbar.post(new Runnable() {
                @Override
                public void run() {
                    int mScrollX = hsv_toolbar.getScrollX();

                    int childX = ll_toolbar.getChildAt(position).getLeft();

                    if (childX < mScrollX) {
                        hsv_toolbar.scrollTo(childX, 0);
                        return;
                    }

                    int childWidth = ll_toolbar.getChildAt(position).getWidth();
                    int hsvWidth = hsv_toolbar.getWidth();
                    int childRight = childX + childWidth;
                    int scrollRight = mScrollX + hsvWidth;

                    if (childRight > scrollRight) {
                        hsv_toolbar.scrollTo(childRight - scrollRight, 0);
                        return;
                    }
                }
            });
        }
    }

//    public void setBtnWidth(int width) {
//        buttonWidth = width;
//    }
//
//    protected OnToolBarItemClickListener mItemClickListeners;
//
//    public interface OnToolBarItemClickListener {
//        void onToolBarItemClick(PageSetEntity pageSetEntity);
//    }
//
//    public void setOnToolBarItemClickListener(OnToolBarItemClickListener listener) {
//        this.mItemClickListeners = listener;
//    }
}

