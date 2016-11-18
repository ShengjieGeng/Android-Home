package com.example.geng.yikaodemo.com.melon.geng.DBhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by geng on 2016/8/14.
 */
public class Fzby1SQLiteHelper extends SQLiteOpenHelper {

    public Fzby1SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table fzby1(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),XiangM float,CaiY float)");
        System.out.println("succeed");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
