package com.hwl.beta.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.hwl.beta.db.entity.ChatRecordMessage;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHAT_RECORD_MESSAGE".
*/
public class ChatRecordMessageDao extends AbstractDao<ChatRecordMessage, Long> {

    public static final String TABLENAME = "CHAT_RECORD_MESSAGE";

    /**
     * Properties of entity ChatRecordMessage.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property RecordId = new Property(0, Long.class, "recordId", true, "_id");
        public final static Property RecordType = new Property(1, int.class, "recordType", false, "RECORD_TYPE");
        public final static Property FromUserId = new Property(2, long.class, "fromUserId", false, "FROM_USER_ID");
        public final static Property FromUserName = new Property(3, String.class, "fromUserName", false, "FROM_USER_NAME");
        public final static Property FromUserHeadImage = new Property(4, String.class, "fromUserHeadImage", false, "FROM_USER_HEAD_IMAGE");
        public final static Property ToUserId = new Property(5, long.class, "toUserId", false, "TO_USER_ID");
        public final static Property ToUserName = new Property(6, String.class, "toUserName", false, "TO_USER_NAME");
        public final static Property ToUserHeadImage = new Property(7, String.class, "toUserHeadImage", false, "TO_USER_HEAD_IMAGE");
        public final static Property GroupGuid = new Property(8, String.class, "groupGuid", false, "GROUP_GUID");
        public final static Property GroupName = new Property(9, String.class, "groupName", false, "GROUP_NAME");
        public final static Property Title = new Property(10, String.class, "title", false, "TITLE");
        public final static Property ContentType = new Property(11, int.class, "contentType", false, "CONTENT_TYPE");
        public final static Property Content = new Property(12, String.class, "content", false, "CONTENT");
        public final static Property UnreadCount = new Property(13, int.class, "unreadCount", false, "UNREAD_COUNT");
        public final static Property SendTime = new Property(14, java.util.Date.class, "sendTime", false, "SEND_TIME");
    }


    public ChatRecordMessageDao(DaoConfig config) {
        super(config);
    }
    
    public ChatRecordMessageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHAT_RECORD_MESSAGE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: recordId
                "\"RECORD_TYPE\" INTEGER NOT NULL ," + // 1: recordType
                "\"FROM_USER_ID\" INTEGER NOT NULL ," + // 2: fromUserId
                "\"FROM_USER_NAME\" TEXT," + // 3: fromUserName
                "\"FROM_USER_HEAD_IMAGE\" TEXT," + // 4: fromUserHeadImage
                "\"TO_USER_ID\" INTEGER NOT NULL ," + // 5: toUserId
                "\"TO_USER_NAME\" TEXT," + // 6: toUserName
                "\"TO_USER_HEAD_IMAGE\" TEXT," + // 7: toUserHeadImage
                "\"GROUP_GUID\" TEXT," + // 8: groupGuid
                "\"GROUP_NAME\" TEXT," + // 9: groupName
                "\"TITLE\" TEXT," + // 10: title
                "\"CONTENT_TYPE\" INTEGER NOT NULL ," + // 11: contentType
                "\"CONTENT\" TEXT," + // 12: content
                "\"UNREAD_COUNT\" INTEGER NOT NULL ," + // 13: unreadCount
                "\"SEND_TIME\" INTEGER);"); // 14: sendTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHAT_RECORD_MESSAGE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ChatRecordMessage entity) {
        stmt.clearBindings();
 
        Long recordId = entity.getRecordId();
        if (recordId != null) {
            stmt.bindLong(1, recordId);
        }
        stmt.bindLong(2, entity.getRecordType());
        stmt.bindLong(3, entity.getFromUserId());
 
        String fromUserName = entity.getFromUserName();
        if (fromUserName != null) {
            stmt.bindString(4, fromUserName);
        }
 
        String fromUserHeadImage = entity.getFromUserHeadImage();
        if (fromUserHeadImage != null) {
            stmt.bindString(5, fromUserHeadImage);
        }
        stmt.bindLong(6, entity.getToUserId());
 
        String toUserName = entity.getToUserName();
        if (toUserName != null) {
            stmt.bindString(7, toUserName);
        }
 
        String toUserHeadImage = entity.getToUserHeadImage();
        if (toUserHeadImage != null) {
            stmt.bindString(8, toUserHeadImage);
        }
 
        String groupGuid = entity.getGroupGuid();
        if (groupGuid != null) {
            stmt.bindString(9, groupGuid);
        }
 
        String groupName = entity.getGroupName();
        if (groupName != null) {
            stmt.bindString(10, groupName);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(11, title);
        }
        stmt.bindLong(12, entity.getContentType());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(13, content);
        }
        stmt.bindLong(14, entity.getUnreadCount());
 
        java.util.Date sendTime = entity.getSendTime();
        if (sendTime != null) {
            stmt.bindLong(15, sendTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ChatRecordMessage entity) {
        stmt.clearBindings();
 
        Long recordId = entity.getRecordId();
        if (recordId != null) {
            stmt.bindLong(1, recordId);
        }
        stmt.bindLong(2, entity.getRecordType());
        stmt.bindLong(3, entity.getFromUserId());
 
        String fromUserName = entity.getFromUserName();
        if (fromUserName != null) {
            stmt.bindString(4, fromUserName);
        }
 
        String fromUserHeadImage = entity.getFromUserHeadImage();
        if (fromUserHeadImage != null) {
            stmt.bindString(5, fromUserHeadImage);
        }
        stmt.bindLong(6, entity.getToUserId());
 
        String toUserName = entity.getToUserName();
        if (toUserName != null) {
            stmt.bindString(7, toUserName);
        }
 
        String toUserHeadImage = entity.getToUserHeadImage();
        if (toUserHeadImage != null) {
            stmt.bindString(8, toUserHeadImage);
        }
 
        String groupGuid = entity.getGroupGuid();
        if (groupGuid != null) {
            stmt.bindString(9, groupGuid);
        }
 
        String groupName = entity.getGroupName();
        if (groupName != null) {
            stmt.bindString(10, groupName);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(11, title);
        }
        stmt.bindLong(12, entity.getContentType());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(13, content);
        }
        stmt.bindLong(14, entity.getUnreadCount());
 
        java.util.Date sendTime = entity.getSendTime();
        if (sendTime != null) {
            stmt.bindLong(15, sendTime.getTime());
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ChatRecordMessage readEntity(Cursor cursor, int offset) {
        ChatRecordMessage entity = new ChatRecordMessage( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // recordId
            cursor.getInt(offset + 1), // recordType
            cursor.getLong(offset + 2), // fromUserId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // fromUserName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // fromUserHeadImage
            cursor.getLong(offset + 5), // toUserId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // toUserName
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // toUserHeadImage
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // groupGuid
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // groupName
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // title
            cursor.getInt(offset + 11), // contentType
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // content
            cursor.getInt(offset + 13), // unreadCount
            cursor.isNull(offset + 14) ? null : new java.util.Date(cursor.getLong(offset + 14)) // sendTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ChatRecordMessage entity, int offset) {
        entity.setRecordId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setRecordType(cursor.getInt(offset + 1));
        entity.setFromUserId(cursor.getLong(offset + 2));
        entity.setFromUserName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setFromUserHeadImage(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setToUserId(cursor.getLong(offset + 5));
        entity.setToUserName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setToUserHeadImage(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setGroupGuid(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setGroupName(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setTitle(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setContentType(cursor.getInt(offset + 11));
        entity.setContent(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setUnreadCount(cursor.getInt(offset + 13));
        entity.setSendTime(cursor.isNull(offset + 14) ? null : new java.util.Date(cursor.getLong(offset + 14)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ChatRecordMessage entity, long rowId) {
        entity.setRecordId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ChatRecordMessage entity) {
        if(entity != null) {
            return entity.getRecordId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ChatRecordMessage entity) {
        return entity.getRecordId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
