package com.example.book.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.book.DAO.HoadonDAO;
import com.example.book.DAO.HoadonchitietDAO;
import com.example.book.DAO.NguoidungDAO;
import com.example.book.DAO.SachDAO;
import com.example.book.DAO.TheloaiDAO;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoidungDAO.SQL_NGUOI_DUNG);
        db.execSQL(TheloaiDAO.SQL_THE_LOAI);
        db.execSQL(SachDAO.SQL_SACH);
        db.execSQL(HoadonDAO.SQL_HOA_DON);
        db.execSQL(HoadonchitietDAO.SQL_HOA_DON_CHI_TIET);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+NguoidungDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+TheloaiDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+SachDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoadonDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoadonchitietDAO.TABLE_NAME);
        onCreate(db);
    }
}