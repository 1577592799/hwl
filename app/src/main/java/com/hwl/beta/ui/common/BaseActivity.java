package com.hwl.beta.ui.common;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.hwl.beta.swipeback.SwipeBackHelper;
import com.hwl.beta.ui.ebus.EventBusUtil;
import com.hwl.beta.ui.ebus.EventMessageModel;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2018/2/4.
 */

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isUseSwipeBackAnimation()) {
            SwipeBackHelper.onCreate(this);
            SwipeBackHelper.getCurrentPage(this)
                    .setSwipeBackEnable(true)
                    .setSwipeSensitivity(0.5f)
                    .setSwipeRelateEnable(true)
                    .setSwipeRelateOffset(300);
        }
        //ViewServer.get(this).addWindow(this);

        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }

    protected boolean isRegisterEventBus() {
        return false;
    }

    protected boolean isUseSwipeBackAnimation() {
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (isUseSwipeBackAnimation()) {
            SwipeBackHelper.onPostCreate(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (isUseSwipeBackAnimation()) {
            SwipeBackHelper.onDestroy(this);
        }
        if (isRegisterEventBus()) {
            EventBusUtil.unRegister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(EventMessageModel messageModel) {
        if (messageModel != null) {
            receiveEventMessage(messageModel);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(EventMessageModel messageModel) {
        if (messageModel != null) {
            receiveStickyEventMessage(messageModel);
        }
    }

    protected void receiveEventMessage(EventMessageModel messageModel) {
    }

    protected void receiveStickyEventMessage(EventMessageModel messageModel) {
    }
}
