package com.hwl.beta.ui.entry;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.hwl.beta.ui.common.KeyBoardAction;
import com.hwl.beta.ui.common.UITransfer;
import com.hwl.im.common.DefaultAction;
import com.hwl.im.common.DefaultConsumer;
import com.hwl.beta.ui.entry.logic.LoginLogic;

import com.hwl.beta.R;
import com.hwl.beta.databinding.EntryActivityLoginBinding;
import com.hwl.beta.ui.entry.action.ILoginListener;
import com.hwl.beta.ui.entry.bean.LoginBean;

/**
 * Created by Administrator on 2018/1/13.
 */

public class ActivityLogin extends FragmentActivity {

    FragmentActivity activity;
    EntryActivityLoginBinding binding;
    LoginLogic loginHandle;
    LoginBean loginBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        loginHandle = new LoginLogic();
        loginBean = loginHandle.getLoginBean();
        binding = DataBindingUtil.setContentView(this, R.layout.entry_activity_login);
        binding.setLoginBean(loginBean);
        binding.setAction(new LoginListener());

        initView();
    }

    private void initView() {
        binding.tbTitle.setTitle(getResources().getString(R.string.login_activity_title))
                .setImageLeftHide().setImageRightHide();
        binding.etAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etAccount.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        KeyBoardAction.getLocalSoftInputHeight(activity);
                    }
                }, 800L);
            }
        });
    }

    private class LoginListener implements ILoginListener {
        boolean isRunning = false;

        private void login() {
            if (isRunning) {
                return;
            }
            isRunning = true;
            binding.btnLogin.setText("登 录 中...");

            if (!loginBean.checkParams()) {
                isRunning = false;
                binding.btnLogin.setText("登   录");
                Toast.makeText(activity, loginBean.getMessageCode(), Toast.LENGTH_SHORT).show();
                return;
            }

            loginHandle.userLogin(loginBean, new DefaultAction() {
                @Override
                public void run() {
                    UITransfer.toWelcomeActivity(activity);
                    finish();
                }
            }, new DefaultConsumer<String>() {
                @Override
                public void accept(String s) {
                    isRunning = false;
                    binding.btnLogin.setText("登   录");
                }
            });
        }

        @Override
        public void onLoginClick() {
            login();
        }

        @Override
        public void onRegisterClick() {
            UITransfer.toRegisterActivity(activity);
        }

        @Override
        public void onGetpwdClick() {
            UITransfer.toGetpwdActivity(activity);
        }

        @Override
        public void onWechatClick() {
            Toast.makeText(activity, "WeChat登录后期开放...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onQQClick() {
            Toast.makeText(activity, "QQ登录后期开放...", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSinaClick() {
            Toast.makeText(activity, "SINA微博登录后期开放...", Toast.LENGTH_SHORT).show();
            // SinaAction.login();
        }
    }
}
