package com.example.BTL_App_truyen_tranh.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.BTL_App_truyen_tranh.DTO.TaiKhoan;

public class TaiKhoanDAO {

    public static Boolean them_taikhoan(TaiKhoan tk,SQLiteDAO sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tk", tk.getTk());
        contentValues.put("hoten", tk.getHoten());
        contentValues.put("mk", tk.getMk());
        long result = MyDB.insert("taikhoan", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public static Boolean kiem_tra_tk(String tk,SQLiteDAO sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from taikhoan where tk = ?", new String[]{tk});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public static Boolean kiem_tra_dn(TaiKhoan tk,SQLiteDAO sqLiteDAO) {
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from taikhoan where tk = ? and mk = ?", new String[]{tk.getTk(), tk.getMk()});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public static TaiKhoan get_thongtin(String tk,SQLiteDAO sqLiteDAO) {
        TaiKhoan studen = new TaiKhoan();
        SQLiteDatabase MyDB = sqLiteDAO.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from taikhoan where tk = ?", new String[]{tk});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            studen.setIdtk(cursor.getInt(0));
            studen.setTk(cursor.getString(1));
            studen.setHoten(cursor.getString(2));
            studen.setMk(cursor.getString(2));
            cursor.close();
            return studen;
        }
        return null;
    }



}
