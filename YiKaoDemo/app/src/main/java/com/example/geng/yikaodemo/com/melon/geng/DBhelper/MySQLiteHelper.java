package com.example.geng.yikaodemo.com.melon.geng.DBhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by geng on 2016/8/14.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table fzby1(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),XiangM float,CaiY float)");
        db.execSQL("create table fzby2(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),YuY float,YongZ float)");
        db.execSQL("create table jmc1(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),XingT float,GaoTT float,QuTFTT float,NanDZH float)");
        db.execSQL("create table jmc2(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),ChengT float)");
        db.execSQL("create table llc1(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),XingT float,SuZ float)");
        db.execSQL("create table llc2(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),ChengT float)");
        db.execSQL("create table lxw1(_id integer primary key autoincrement,XPH char(10),JID char(10),XingX float,HengC float," +
                "ZongC float,HouY float,BanTPH float,JiQ float)");
        db.execSQL("create table lxw2(_id integer primary key autoincrement,XPH char(10),JID char(10),MoF float,WaoDZP float)");
        db.execSQL("create table tywd1(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "XingTQZ float,PingZ float,Cha float,ShuangFT float)");
        db.execSQL("create table tywd2(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "LaDW float,MoD float)");
        db.execSQL("create table wdbd1(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "XingXXT float,HengC float,ShuC float,HouY float,BanTPH float,DongZMF float)");
        db.execSQL("create table wdbd2(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "WaoDZP float,MingTBY float)");
        db.execSQL("create table zgw1(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "XingX float,HengC float,ZongC float,HouY float,BanTPH float,JiQ float)");
        db.execSQL("create table zgw2(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "MoF float,WuDZP float)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
