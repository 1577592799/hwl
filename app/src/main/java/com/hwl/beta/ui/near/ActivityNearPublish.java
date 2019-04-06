package com.hwl.beta.ui.near;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.hwl.beta.R;
import com.hwl.beta.databinding.NearActivityPulishBinding;
import com.hwl.beta.sp.AppInstallStatus;
import com.hwl.beta.ui.common.BaseActivity;
import com.hwl.beta.ui.dialog.LoadingDialog;
import com.hwl.beta.ui.imgselect.bean.ImageBean;
import com.hwl.beta.ui.near.logic.NearPublishLogic;
import com.hwl.beta.ui.near.standard.NearPublishStandard;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/2/16.
 */

public class ActivityNearPublish extends BaseActivity {
    NearActivityPulishBinding binding;
    FragmentActivity activity;
    NearPublishStandard publishStandard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        publishStandard = new NearPublishLogic();

        binding = DataBindingUtil.setContentView(activity, R.layout.near_activity_pulish);
        initView();
    }

    public void initView() {
        binding.tbTitle.setTitle("附近发布信息")
                .setTitleRightText("发布")
                .setTitleRightBackground(R.drawable.bg_top)
                .setImageRightHide()
                .setTitleRightShow()
                .setImageLeftClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                })
                .setTitleRightClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        publishInfo();
                    }
                });

        binding.ecpEmotion.setEditText(binding.etEmotionText)
                .setLocalSoftInputHeight(AppInstallStatus.getSoftInputHeight())
                .setContentContainerView(binding.llNearPublishContainer);

        binding.llNearPublishContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                binding.ecpEmotion.setContentContainerHeight(binding.llNearPublishContainer
                        .getHeight() - binding.tbTitle.getHeight());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            binding.iavImages.setImagePaths(data.getExtras().<ImageBean>getParcelableArrayList(
                    "selectimages"));
        }
    }

    private void publishInfo() {
        LoadingDialog.show(activity, "正在发布,请稍后...");
        publishStandard.publishInfo(binding.etEmotionText.getText() + "",
                binding.iavImages.getImagePaths())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) {
                        Toast.makeText(getApplicationContext(), "发布成功", Toast.LENGTH_SHORT).show();
                        LoadingDialog.hide();
                        finish();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        LoadingDialog.hide();
                    }
                });
    }
}