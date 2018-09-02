package com.hwl.beta.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.hwl.beta.db.entity.Circle;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "CIRCLE".
*/
public class CircleDao extends AbstractDao<Circle, Long> {

    public static final String TABLENAME = "CIRCLE";

    /**
     * Properties of entity Circle.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CircleId = new Property(0, long.class, "circleId", true, "_id");
        public final static Property PublishUserId = new Property(1, long.class, "publishUserId", false, "PUBLISH_USER_ID");
        public final static Property PublishUserName = new Property(2, String.class, "publishUserName", false, "PUBLISH_USER_NAME");
        public final static Property PublishUserImage = new Property(3, String.class, "publishUserImage", false, "PUBLISH_USER_IMAGE");
        public final static Property ContentType = new Property(4, int.class, "contentType", false, "CONTENT_TYPE");
        public final static Property Content = new Property(5, String.class, "content", false, "CONTENT");
        public final static Property LinkTitle = new Property(6, String.class, "linkTitle", false, "LINK_TITLE");
        public final static Property LinkUrl = new Property(7, String.class, "linkUrl", false, "LINK_URL");
        public final static Property LinkImage = new Property(8, String.class, "linkImage", false, "LINK_IMAGE");
        public final static Property PublishTime = new Property(9, java.util.Date.class, "publishTime", false, "PUBLISH_TIME");
        public final static Property UpdateTime = new Property(10, String.class, "updateTime", false, "UPDATE_TIME");
        public final static Property FromPosDesc = new Property(11, String.class, "fromPosDesc", false, "FROM_POS_DESC");
        public final static Property CommentCount = new Property(12, int.class, "commentCount", false, "COMMENT_COUNT");
        public final static Property LikeCount = new Property(13, int.class, "likeCount", false, "LIKE_COUNT");
        public final static Property IsLiked = new Property(14, boolean.class, "isLiked", false, "IS_LIKED");
    }


    public CircleDao(DaoConfig config) {
        super(config);
    }
    
    public CircleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CIRCLE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: circleId
                "\"PUBLISH_USER_ID\" INTEGER NOT NULL ," + // 1: publishUserId
                "\"PUBLISH_USER_NAME\" TEXT," + // 2: publishUserName
                "\"PUBLISH_USER_IMAGE\" TEXT," + // 3: publishUserImage
                "\"CONTENT_TYPE\" INTEGER NOT NULL ," + // 4: contentType
                "\"CONTENT\" TEXT," + // 5: content
                "\"LINK_TITLE\" TEXT," + // 6: linkTitle
                "\"LINK_URL\" TEXT," + // 7: linkUrl
                "\"LINK_IMAGE\" TEXT," + // 8: linkImage
                "\"PUBLISH_TIME\" INTEGER," + // 9: publishTime
                "\"UPDATE_TIME\" TEXT," + // 10: updateTime
                "\"FROM_POS_DESC\" TEXT," + // 11: fromPosDesc
                "\"COMMENT_COUNT\" INTEGER NOT NULL ," + // 12: commentCount
                "\"LIKE_COUNT\" INTEGER NOT NULL ," + // 13: likeCount
                "\"IS_LIKED\" INTEGER NOT NULL );"); // 14: isLiked
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CIRCLE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Circle entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCircleId());
        stmt.bindLong(2, entity.getPublishUserId());
 
        String publishUserName = entity.getPublishUserName();
        if (publishUserName != null) {
            stmt.bindString(3, publishUserName);
        }
 
        String publishUserImage = entity.getPublishUserImage();
        if (publishUserImage != null) {
            stmt.bindString(4, publishUserImage);
        }
        stmt.bindLong(5, entity.getContentType());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(6, content);
        }
 
        String linkTitle = entity.getLinkTitle();
        if (linkTitle != null) {
            stmt.bindString(7, linkTitle);
        }
 
        String linkUrl = entity.getLinkUrl();
        if (linkUrl != null) {
            stmt.bindString(8, linkUrl);
        }
 
        String linkImage = entity.getLinkImage();
        if (linkImage != null) {
            stmt.bindString(9, linkImage);
        }
 
        java.util.Date publishTime = entity.getPublishTime();
        if (publishTime != null) {
            stmt.bindLong(10, publishTime.getTime());
        }
 
        String updateTime = entity.getUpdateTime();
        if (updateTime != null) {
            stmt.bindString(11, updateTime);
        }
 
        String fromPosDesc = entity.getFromPosDesc();
        if (fromPosDesc != null) {
            stmt.bindString(12, fromPosDesc);
        }
        stmt.bindLong(13, entity.getCommentCount());
        stmt.bindLong(14, entity.getLikeCount());
        stmt.bindLong(15, entity.getIsLiked() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Circle entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCircleId());
        stmt.bindLong(2, entity.getPublishUserId());
 
        String publishUserName = entity.getPublishUserName();
        if (publishUserName != null) {
            stmt.bindString(3, publishUserName);
        }
 
        String publishUserImage = entity.getPublishUserImage();
        if (publishUserImage != null) {
            stmt.bindString(4, publishUserImage);
        }
        stmt.bindLong(5, entity.getContentType());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(6, content);
        }
 
        String linkTitle = entity.getLinkTitle();
        if (linkTitle != null) {
            stmt.bindString(7, linkTitle);
        }
 
        String linkUrl = entity.getLinkUrl();
        if (linkUrl != null) {
            stmt.bindString(8, linkUrl);
        }
 
        String linkImage = entity.getLinkImage();
        if (linkImage != null) {
            stmt.bindString(9, linkImage);
        }
 
        java.util.Date publishTime = entity.getPublishTime();
        if (publishTime != null) {
            stmt.bindLong(10, publishTime.getTime());
        }
 
        String updateTime = entity.getUpdateTime();
        if (updateTime != null) {
            stmt.bindString(11, updateTime);
        }
 
        String fromPosDesc = entity.getFromPosDesc();
        if (fromPosDesc != null) {
            stmt.bindString(12, fromPosDesc);
        }
        stmt.bindLong(13, entity.getCommentCount());
        stmt.bindLong(14, entity.getLikeCount());
        stmt.bindLong(15, entity.getIsLiked() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Circle readEntity(Cursor cursor, int offset) {
        Circle entity = new Circle( //
            cursor.getLong(offset + 0), // circleId
            cursor.getLong(offset + 1), // publishUserId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // publishUserName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // publishUserImage
            cursor.getInt(offset + 4), // contentType
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // content
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // linkTitle
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // linkUrl
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // linkImage
            cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)), // publishTime
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // updateTime
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // fromPosDesc
            cursor.getInt(offset + 12), // commentCount
            cursor.getInt(offset + 13), // likeCount
            cursor.getShort(offset + 14) != 0 // isLiked
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Circle entity, int offset) {
        entity.setCircleId(cursor.getLong(offset + 0));
        entity.setPublishUserId(cursor.getLong(offset + 1));
        entity.setPublishUserName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPublishUserImage(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setContentType(cursor.getInt(offset + 4));
        entity.setContent(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setLinkTitle(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLinkUrl(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setLinkImage(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPublishTime(cursor.isNull(offset + 9) ? null : new java.util.Date(cursor.getLong(offset + 9)));
        entity.setUpdateTime(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setFromPosDesc(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setCommentCount(cursor.getInt(offset + 12));
        entity.setLikeCount(cursor.getInt(offset + 13));
        entity.setIsLiked(cursor.getShort(offset + 14) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Circle entity, long rowId) {
        entity.setCircleId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Circle entity) {
        if(entity != null) {
            return entity.getCircleId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Circle entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
