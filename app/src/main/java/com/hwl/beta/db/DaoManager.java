package com.hwl.beta.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hwl.beta.badge.BuildConfig;
import com.hwl.beta.db.dao.DaoMaster;
import com.hwl.beta.db.dao.DaoSession;
import com.hwl.beta.sp.UserSP;

import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by adminstrator on 2018/6/16.
 */
public class DaoManager {
    private static DaoManager mDaoManager;

    private DaoMaster.OpenHelper mHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private SQLiteDatabase db;

    private static String getDBName() {
        return "hwl-" + UserSP.getUserId() + ".db";
    }

    public static DaoManager getInstance() {
        if (mDaoManager == null) {
            synchronized (DaoManager.class) {
                //Log.d(TAG, "create dao manager instance ..." + getDBName());
                mDaoManager = new DaoManager();
				mDaoManager.setDBDebug(BuildConfig.DEBUG);
            }
        }
        return mDaoManager;
    }

    public DaoMaster getDaoMaster() {
        if (null == mDaoMaster) {
//           Log.d(TAG, "getDaoMaster=" + getDBName());
//            if (BuildConfig.DEBUG) {
//                mHelper = new DaoMaster.DevOpenHelper(context, getDBName(), null);
//            } else {
//           DaoLog.isLoggable(DaoLog.ERROR);
           mHelper = new DaoMaster.DevOpenHelper(HWLApp.getContext(), getDBName());
//            }
            db = mHelper.getWritableDatabase();
            mDaoMaster = new DaoMaster(db);
        }
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        if (null == mDaoSession) {
            mDaoSession = getDaoMaster().newSession();
        }
        return mDaoSession;
    }

    public void setDBDebug(boolean flag) {
        QueryBuilder.LOG_SQL = flag;
        QueryBuilder.LOG_VALUES = flag;
    }

    public void closeDataBase() {
        if (null != mDaoSession) {
            mDaoSession.clear();
            mDaoSession = null;
        }
        if (mDaoMaster != null) {
            mDaoMaster = null;
        }
        if (db != null) {
            db.close();
            db = null;
        }
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
        mDaoManager = null;
    }

//    public void closeDaoSession() {
//        if (null != mDaoSession) {
//            mDaoSession.clear();
//            mDaoSession = null;
//        }
//    }
//
//    public static void closeHelper() {
//        if (mHelper != null) {
//            mHelper.close();
//            mHelper = null;
//        }
//    }
}