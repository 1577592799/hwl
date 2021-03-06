package com.hwl.beta.ui.near.action;

import android.view.View;

import com.hwl.beta.db.entity.NearCircleComment;

/**
 * Created by Administrator on 2018/4/15.
 */

public interface INearCircleCommentItemListener {
    void onCommentUserClick(NearCircleComment comment);

    void onReplyUserClick(NearCircleComment comment);

    void onCommentContentClick(NearCircleComment comment);

    boolean onCommentLongClick(View view, NearCircleComment comment);
}
