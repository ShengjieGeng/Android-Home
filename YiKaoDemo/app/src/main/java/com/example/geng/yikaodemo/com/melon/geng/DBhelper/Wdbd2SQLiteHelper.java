package com.example.geng.yikaodemo.com.melon.geng.DBhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by geng on 2016/8/14.
 */
public class Wdbd2SQLiteHelper extends SQLiteOpenHelper {

    public Wdbd2SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table wdbd2(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "WaoDZP float,MingTBY float)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
