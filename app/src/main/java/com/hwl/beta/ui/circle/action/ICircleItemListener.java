package com.hwl.beta.ui.circle.action;

import android.view.View;

import com.hwl.beta.db.entity.Circle;
import com.hwl.beta.db.entity.CircleComment;
import com.hwl.beta.db.entity.CircleImage;
import com.hwl.beta.db.entity.CircleLike;

import java.util.List;

/**
 * Created by Administrator on 2018/4/14.
 */

public interface ICircleItemListener extends ICircleLikeItemListener,ICircleCommentItemListener {

    //void onItemViewClick(View view);

    void onCircleBackImageClick();

    void onMyUserHeadClick();

    void onUserHeadClick(Circle info);

    void onContentClick(Circle info);

    void onMoreActionClick(View view, int position, Circle info);

    void onMoreCommentClick();

    void onDeleteClick(int position, Circle info);

    void onPublishClick();

    void onMsgcountClick();

    void onImageClick(int position, List<CircleImage> images);
}
