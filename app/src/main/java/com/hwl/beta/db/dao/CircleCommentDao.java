package com.hwl.beta.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.hwl.beta.db.entity.CircleComment;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "CIRCLE_COMMENT".
*/
public class CircleCommentDao extends AbstractDao<CircleComment, Void> {

    public static final String TABLENAME = "CIRCLE_COMMENT";

    /**
     * Properties of entity CircleComment.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CommentId = new Property(0, int.class, "commentId", false, "COMMENT_ID");
        public final static Property CircleId = new Property(1, long.class, "circleId", false, "CIRCLE_ID");
        public final static Property CommentUserId = new Property(2, long.class, "commentUserId", false, "COMMENT_USER_ID");
        public final static Property CommentUserName = new Property(3, String.class, "commentUserName", false, "COMMENT_USER_NAME");
        public final static Property CommentUserImage = new Property(4, String.class, "commentUserImage", false, "COMMENT_USER_IMAGE");
        public final static Property ReplyUserId = new Property(5, long.class, "replyUserId", false, "REPLY_USER_ID");
        public final static Property ReplyUserName = new Property(6, String.class, "replyUserName", false, "REPLY_USER_NAME");
        public final static Property ReplyUserImage = new Property(7, String.class, "replyUserImage", false, "REPLY_USER_IMAGE");
        public final static Property Content = new Property(8, String.class, "content", false, "CONTENT");
        public final static Property CommentTime = new Property(9, java.util.Date.class, "commentTime", false, "COMMENT_TIME");
    }


    public CircleCommentDao(DaoConfig config) {
        super(config);
    }
    
    public CircleCommentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CIRCLE_COMMENT\" (" + //
                "\"COMMENT_ID\" INTEGER NOT NULL ," + // 0: commentId
                "\"CIRCLE_ID\" INTEGER NOT NULL ," + // 1: circleId
                "\"COMMENT_USER_ID\" INTEGER NOT NULL ," + // 2: commentUserId
                "\"COMMENT_USER_NAME\" TEXT," + // 3: commentUserName
                "\"COMMENT_USER_IMAGE\" TEXT," + // 4: commentUserImage
                "\"REPLY_USER_ID\" INTEGER NOT NULL ," + // 5: replyUserId
                "\"REPLY_USER_NAME\" TEXT," + // 6: replyUserName
                "\"REPLY_USER_IMAGE\" TEXT," + // 7: replyUserImage
                "\"CONTENT\" TEXT," + // 8: content
                "\"COMMENT_TIME\" INTEGER);"); // 9: commentTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CIRCLE_COMMENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CircleComment entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCommentId());
        stmt.bindLong(2, entity.getCircleId());
        stmt.bindLong(3, entity.getCommentUserId());
 
        String commentUserName = entity.getCommentUserName();
        if (commentUserName != null) {
            stmt.bindString(4, commentUserName);
        }
 
        String commentUserImage = entity.getCommentUserImage();
        if (commentUserImage != null) {
            stmt.bindString(5, commentUserImage);
        }
        stmt.bindLong(6, entity.getReplyUserId());
 
        String replyUserName = entity.getReplyUserName();
        if (replyUserName != null) {
            stmt.bindString(7, replyUserName);
        }
 
        String replyUserImage = entity.getReplyUserImage();
        if (replyUserImage != null) {
            stmt.bindString(8, replyUserImage);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(9, content);
        }
 
        java.util.Date commentTime = entity.getCommentTime();
        if (commentTime != null) {
            stmt.bindLong(10, commentTime.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CircleComment entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCommentId());
        stmt.bindLong(2, entity.getCircleId());
        stmt.bindLong(3, entity.getCommentUserId());
 
        String commentUserName = entity.getCommentUserName();
        if (commentUserName != null) {
            stmt.bindString(4, commentUserName);
        }
 
        String commentUserImage = entity.getCommentUserImage();
        if (commentUserImage != null) {
            stmt.bindString(5, commentUserImage);
        }
        stmt.bindLong(6, entity.getReplyUserId());
 
        String replyUserName = entity.getReplyUserName();
        if (replyUserName != null) {
            stmt.bindString(7, replyUserName);
        }
 
        String replyUserImage = entity.getReplyUserImage();
        if (replyUserImage != null) {
            stmt.bindString(8, replyUserImage);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(9, content);
        }
 
        java.util.Date commentTime = entity.getCommentTime();
        if (commentTime != null) {
            stmt.bindLong(10, commentTime.getTime());
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public CircleComment readEntity(Cursor cursor, int offset) {
        CircleComment entity = new CircleComment( //
            cursor.getInt(offset + 0), // commentId
            cursor.getLong(offset + 1), // circleId
            cursor.getLong(offset + 2), // commentUserId
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // commentUserName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // commentUserImage
            cursor.getLong(offset + 5), // replyUserId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // replyUserName
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // replyUserImage
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // content
            cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)) // commentTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CircleComment entity, int offset) {
        entity.setCommentId(cursor.getInt(offset + 0));
        entity.setCircleId(cursor.getLong(offset + 1));
        entity.setCommentUserId(cursor.getLong(offset + 2));
        entity.setCommentUserName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCommentUserImage(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setReplyUserId(cursor.getLong(offset + 5));
        entity.setReplyUserName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setReplyUserImage(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setContent(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setCommentTime(cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(CircleComment entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(CircleComment entity) {
        return null;
    }

    @Override
    public boolean hasKey(CircleComment entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
