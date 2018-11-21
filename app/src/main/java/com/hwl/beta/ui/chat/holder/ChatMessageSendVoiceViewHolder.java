package com.hwl.beta.ui.chat.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hwl.beta.databinding.ChatSendVoiceItemBinding;
import com.hwl.beta.ui.chat.action.IChatMessageItemListener;
import com.hwl.beta.ui.chat.bean.ChatImageViewBean;
import com.hwl.beta.utils.StringUtils;

/**
 * Created by Administrator on 2018/1/6.
 */

public class ChatMessageSendVoiceViewHolder extends RecyclerView.ViewHolder {

    private ChatSendVoiceItemBinding itemBinding;

    public ChatMessageSendVoiceViewHolder(ChatSendVoiceItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.itemBinding = itemBinding;
    }

    public void setItemBinding(IChatMessageItemListener itemListener,
                               ChatImageViewBean image,
                               int position,
                               String userName,
                               long playTime,
                               String statusDesc) {
        this.itemBinding.setAction(itemListener);
        this.itemBinding.setImage(image);
        this.itemBinding.setPosition(position);
        this.itemBinding.setPlayTime(playTime);
        if (StringUtils.isBlank(userName)) {
            this.itemBinding.tvUsername.setVisibility(View.GONE);
        } else {
            this.itemBinding.tvUsername.setVisibility(View.VISIBLE);
            this.itemBinding.setUserName(userName);
        }
        this.itemBinding.setStatusDesc(statusDesc);
    }

    public ChatSendVoiceItemBinding getItemBinding() {
        return itemBinding;
    }
}
