package com.hwl.beta.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2018/2/5.
 */

@Entity
public class FriendRequest {

    @Id
    private long friendId;
    private String friendName;
    private String friendHeadImage;
    private String remark;
    private int status;
    @Generated(hash = 1166218192)
    public FriendRequest(long friendId, String friendName, String friendHeadImage,
            String remark, int status) {
        this.friendId = friendId;
        this.friendName = friendName;
        this.friendHeadImage = friendHeadImage;
        this.remark = remark;
        this.status = status;
    }
    @Generated(hash = 1677678717)
    public FriendRequest() {
    }
    public long getFriendId() {
        return this.friendId;
    }
    public void setFriendId(long friendId) {
        this.friendId = friendId;
    }
    public String getFriendName() {
        return this.friendName;
    }
    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
    public String getFriendHeadImage() {
        return this.friendHeadImage;
    }
    public void setFriendHeadImage(String friendHeadImage) {
        this.friendHeadImage = friendHeadImage;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
