package com.example.BTL_App_truyen_tranh.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDAO extends SQLiteOpenHelper {
    public SQLiteDAO(@Nullable Context context) {
        super(context, "DATASQLITE", null, 1);
    }

    public void get_data(String sql) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public Cursor doc_data(String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }

    public void getdatatk() {
        get_data("create Table IF NOT EXISTS taikhoan(idtk INTEGER PRIMARY KEY AUTOINCREMENT,tk nvarchar(50), hoten nvarchar(50),mk nvarchar(50))");
    }

    public void getdatadm() {
        get_data("CREATE TABLE IF NOT EXISTS danhmuc(iddm INTEGER PRIMARY KEY AUTOINCREMENT,tendm nvarchar(500),hinhanh nvarchar(500))");
    }

    public void getdatasanpham() {
        get_data("create Table IF NOT EXISTS sanpham(idsp INTEGER PRIMARY KEY AUTOINCREMENT,iddm INTEGER,tensp nvarchar(50) , thuonghieu nvarchar(50), chitiet nvarchar(50) ,giatien INTEGER, hinhanh nvarchar(50))");
    }

    public void getdatagiohang() {
        get_data("create Table IF NOT EXISTS giohang(idgh INTEGER PRIMARY KEY AUTOINCREMENT,idtk INTEGER, idsp INTEGER,sl INTEGER,tongtien INTEGER,trangthai INTEGER)");
    }

    public void getdatadonhang() {
        get_data("create Table IF NOT EXISTS donhang(iddh INTEGER PRIMARY KEY AUTOINCREMENT,idgh INTEGER, idtk INTEGER,loinhan nvarchar(500))");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}