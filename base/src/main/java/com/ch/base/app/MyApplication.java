package com.ch.base.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CH
 * on 2018/11/27 0027 11:34
 */
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    private String DATA_BASE_NAME = "";
    private SQLiteDatabase db;
    // 静态单例
    public static MyApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;

    }

    public static MyApplication getInstances() {
        return instances;
    }


    public SQLiteDatabase getDb() {
        return db;
    }


}
