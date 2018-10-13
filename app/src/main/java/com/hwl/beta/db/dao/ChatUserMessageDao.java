package com.hwl.beta.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.hwl.beta.db.entity.ChatUserMessage;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHAT_USER_MESSAGE".
*/
public class ChatUserMessageDao extends AbstractDao<ChatUserMessage, Long> {

    public static final String TABLENAME = "CHAT_USER_MESSAGE";

    /**
     * Properties of entity ChatUserMessage.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property MsgId = new Property(0, Long.class, "msgId", true, "_id");
        public final static Property FromUserId = new Property(1, long.class, "fromUserId", false, "FROM_USER_ID");
        public final static Property FromUserName = new Property(2, String.class, "fromUserName", false, "FROM_USER_NAME");
        public final static Property FromUserHeadImage = new Property(3, String.class, "fromUserHeadImage", false, "FROM_USER_HEAD_IMAGE");
        public final static Property ToUserId = new Property(4, long.class, "toUserId", false, "TO_USER_ID");
        public final static Property ContentType = new Property(5, int.class, "contentType", false, "CONTENT_TYPE");
        public final static Property Content = new Property(6, String.class, "content", false, "CONTENT");
        public final static Property LocalUrl = new Property(7, String.class, "localUrl", false, "LOCAL_URL");
        public final static Property PreviewUrl = new Property(8, String.class, "previewUrl", false, "PREVIEW_URL");
        public final static Property OriginalUrl = new Property(9, String.class, "originalUrl", false, "ORIGINAL_URL");
        public final static Property ImageHeight = new Property(10, int.class, "imageHeight", false, "IMAGE_HEIGHT");
        public final static Property ImageWidth = new Property(11, int.class, "imageWidth", false, "IMAGE_WIDTH");
        public final static Property Size = new Property(12, long.class, "size", false, "SIZE");
        public final static Property PlayTime = new Property(13, long.class, "playTime", false, "PLAY_TIME");
        public final static Property SendStatus = new Property(14, int.class, "sendStatus", false, "SEND_STATUS");
        public final static Property SendTime = new Property(15, java.util.Date.class, "sendTime", false, "SEND_TIME");
    }


    public ChatUserMessageDao(DaoConfig config) {
        super(config);
    }
    
    public ChatUserMessageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHAT_USER_MESSAGE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: msgId
                "\"FROM_USER_ID\" INTEGER NOT NULL ," + // 1: fromUserId
                "\"FROM_USER_NAME\" TEXT," + // 2: fromUserName
                "\"FROM_USER_HEAD_IMAGE\" TEXT," + // 3: fromUserHeadImage
                "\"TO_USER_ID\" INTEGER NOT NULL ," + // 4: toUserId
                "\"CONTENT_TYPE\" INTEGER NOT NULL ," + // 5: contentType
                "\"CONTENT\" TEXT," + // 6: content
                "\"LOCAL_URL\" TEXT," + // 7: localUrl
                "\"PREVIEW_URL\" TEXT," + // 8: previewUrl
                "\"ORIGINAL_URL\" TEXT," + // 9: originalUrl
                "\"IMAGE_HEIGHT\" INTEGER NOT NULL ," + // 10: imageHeight
                "\"IMAGE_WIDTH\" INTEGER NOT NULL ," + // 11: imageWidth
                "\"SIZE\" INTEGER NOT NULL ," + // 12: size
                "\"PLAY_TIME\" INTEGER NOT NULL ," + // 13: playTime
                "\"SEND_STATUS\" INTEGER NOT NULL ," + // 14: sendStatus
                "\"SEND_TIME\" INTEGER);"); // 15: sendTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHAT_USER_MESSAGE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ChatUserMessage entity) {
        stmt.clearBindings();
 
        Long msgId = entity.getMsgId();
        if (msgId != null) {
            stmt.bindLong(1, msgId);
        }
        stmt.bindLong(2, entity.getFromUserId());
 
        String fromUserName = entity.getFromUserName();
        if (fromUserName != null) {
            stmt.bindString(3, fromUserName);
        }
 
        String fromUserHeadImage = entity.getFromUserHeadImage();
        if (fromUserHeadImage != null) {
            stmt.bindString(4, fromUserHeadImage);
        }
        stmt.bindLong(5, entity.getToUserId());
        stmt.bindLong(6, entity.getContentType());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(7, content);
        }
 
        String localUrl = entity.getLocalUrl();
        if (localUrl != null) {
            stmt.bindString(8, localUrl);
        }
 
        String previewUrl = entity.getPreviewUrl();
        if (previewUrl != null) {
            stmt.bindString(9, previewUrl);
        }
 
        String originalUrl = entity.getOriginalUrl();
        if (originalUrl != null) {
            stmt.bindString(10, originalUrl);
        }
        stmt.bindLong(11, entity.getImageHeight());
        stmt.bindLong(12, entity.getImageWidth());
        stmt.bindLong(13, entity.getSize());
        stmt.bindLong(14, entity.getPlayTime());
        stmt.bindLong(15, entity.getSendStatus());
 
        java.util.Date sendTime = entity.getSendTime();
        if (sendTime != null) {
            stmt.bindLong(16, sendTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ChatUserMessage entity) {
        stmt.clearBindings();
 
        Long msgId = entity.getMsgId();
        if (msgId != null) {
            stmt.bindLong(1, msgId);
        }
        stmt.bindLong(2, entity.getFromUserId());
 
        String fromUserName = entity.getFromUserName();
        if (fromUserName != null) {
            stmt.bindString(3, fromUserName);
        }
 
        String fromUserHeadImage = entity.getFromUserHeadImage();
        if (fromUserHeadImage != null) {
            stmt.bindString(4, fromUserHeadImage);
        }
        stmt.bindLong(5, entity.getToUserId());
        stmt.bindLong(6, entity.getContentType());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(7, content);
        }
 
        String localUrl = entity.getLocalUrl();
        if (localUrl != null) {
            stmt.bindString(8, localUrl);
        }
 
        String previewUrl = entity.getPreviewUrl();
        if (previewUrl != null) {
            stmt.bindString(9, previewUrl);
        }
 
        String originalUrl = entity.getOriginalUrl();
        if (originalUrl != null) {
            stmt.bindString(10, originalUrl);
        }
        stmt.bindLong(11, entity.getImageHeight());
        stmt.bindLong(12, entity.getImageWidth());
        stmt.bindLong(13, entity.getSize());
        stmt.bindLong(14, entity.getPlayTime());
        stmt.bindLong(15, entity.getSendStatus());
 
        java.util.Date sendTime = entity.getSendTime();
        if (sendTime != null) {
            stmt.bindLong(16, sendTime.getTime());
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ChatUserMessage readEntity(Cursor cursor, int offset) {
        ChatUserMessage entity = new ChatUserMessage( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // msgId
            cursor.getLong(offset + 1), // fromUserId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // fromUserName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // fromUserHeadImage
            cursor.getLong(offset + 4), // toUserId
            cursor.getInt(offset + 5), // contentType
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // content
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // localUrl
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // previewUrl
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // originalUrl
            cursor.getInt(offset + 10), // imageHeight
            cursor.getInt(offset + 11), // imageWidth
            cursor.getLong(offset + 12), // size
            cursor.getLong(offset + 13), // playTime
            cursor.getInt(offset + 14), // sendStatus
            cursor.isNull(offset + 15) ? null : new java.util.Date(cursor.getLong(offset + 15)) // sendTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ChatUserMessage entity, int offset) {
        entity.setMsgId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setFromUserId(cursor.getLong(offset + 1));
        entity.setFromUserName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFromUserHeadImage(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setToUserId(cursor.getLong(offset + 4));
        entity.setContentType(cursor.getInt(offset + 5));
        entity.setContent(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLocalUrl(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPreviewUrl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setOriginalUrl(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setImageHeight(cursor.getInt(offset + 10));
        entity.setImageWidth(cursor.getInt(offset + 11));
        entity.setSize(cursor.getLong(offset + 12));
        entity.setPlayTime(cursor.getLong(offset + 13));
        entity.setSendStatus(cursor.getInt(offset + 14));
        entity.setSendTime(cursor.isNull(offset + 15) ? null : new java.util.Date(cursor.getLong(offset + 15)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ChatUserMessage entity, long rowId) {
        entity.setMsgId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ChatUserMessage entity) {
        if(entity != null) {
            return entity.getMsgId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ChatUserMessage entity) {
        return entity.getMsgId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
