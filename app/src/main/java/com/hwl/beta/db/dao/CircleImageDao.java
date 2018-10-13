package com.hwl.beta.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.hwl.beta.db.entity.CircleImage;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CIRCLE_IMAGE".
*/
public class CircleImageDao extends AbstractDao<CircleImage, Void> {

    public static final String TABLENAME = "CIRCLE_IMAGE";

    /**
     * Properties of entity CircleImage.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CircleId = new Property(0, long.class, "circleId", false, "CIRCLE_ID");
        public final static Property PostUserId = new Property(1, long.class, "postUserId", false, "POST_USER_ID");
        public final static Property ImageUrl = new Property(2, String.class, "imageUrl", false, "IMAGE_URL");
        public final static Property ImageHeight = new Property(3, int.class, "imageHeight", false, "IMAGE_HEIGHT");
        public final static Property ImageWidth = new Property(4, int.class, "imageWidth", false, "IMAGE_WIDTH");
    }


    public CircleImageDao(DaoConfig config) {
        super(config);
    }
    
    public CircleImageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CIRCLE_IMAGE\" (" + //
                "\"CIRCLE_ID\" INTEGER NOT NULL ," + // 0: circleId
                "\"POST_USER_ID\" INTEGER NOT NULL ," + // 1: postUserId
                "\"IMAGE_URL\" TEXT," + // 2: imageUrl
                "\"IMAGE_HEIGHT\" INTEGER NOT NULL ," + // 3: imageHeight
                "\"IMAGE_WIDTH\" INTEGER NOT NULL );"); // 4: imageWidth
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CIRCLE_IMAGE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CircleImage entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCircleId());
        stmt.bindLong(2, entity.getPostUserId());
 
        String imageUrl = entity.getImageUrl();
        if (imageUrl != null) {
            stmt.bindString(3, imageUrl);
        }
        stmt.bindLong(4, entity.getImageHeight());
        stmt.bindLong(5, entity.getImageWidth());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CircleImage entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getCircleId());
        stmt.bindLong(2, entity.getPostUserId());
 
        String imageUrl = entity.getImageUrl();
        if (imageUrl != null) {
            stmt.bindString(3, imageUrl);
        }
        stmt.bindLong(4, entity.getImageHeight());
        stmt.bindLong(5, entity.getImageWidth());
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public CircleImage readEntity(Cursor cursor, int offset) {
        CircleImage entity = new CircleImage( //
            cursor.getLong(offset + 0), // circleId
            cursor.getLong(offset + 1), // postUserId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // imageUrl
            cursor.getInt(offset + 3), // imageHeight
            cursor.getInt(offset + 4) // imageWidth
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CircleImage entity, int offset) {
        entity.setCircleId(cursor.getLong(offset + 0));
        entity.setPostUserId(cursor.getLong(offset + 1));
        entity.setImageUrl(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setImageHeight(cursor.getInt(offset + 3));
        entity.setImageWidth(cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(CircleImage entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(CircleImage entity) {
        return null;
    }

    @Override
    public boolean hasKey(CircleImage entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
