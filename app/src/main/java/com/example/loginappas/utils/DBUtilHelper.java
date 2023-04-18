package com.example.loginappas.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbUtilHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "tutorial_db";
    public static final String DB_REGISTRATION_TABLE = "registration";


    public DbUtilHelper(Context context) {
        super(context, DB_NAME, null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table DB_REGISTRATION_TABLE( _ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " login text, " +
                " haslo text);"+"");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(db);

    }

    public SQLiteDatabase getWriteConnection() {
        return getWritableDatabase();
    }

    public SQLiteDatabase getReadConnection() {
        return getReadConnection();
    }
}
