package com.example.bigthingsthatidk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBName = "mydb.db";
    private static final int VERSION = 1;

    private static final String TABLE_NAME = "Cauhoi";
    private static final String id = "_id";
    private static final String Question = "question";

    private SQLiteDatabase MyDB;

    public DBHelper (Context context) {super(context, DBName, null, VERSION);}

    public static String GetID() {return id;}
    public static String GetQuestion() {return Question;}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTable = "CREATE TABLE " + TABLE_NAME + "( " + id + " INTEGER PRIMARY KEY, " + Question + " TEXT NOT NULL, " + ")";
        db.execSQL(queryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void closeDB() {
        if (MyDB!=null &&MyDB.isOpen()) {
            MyDB.close();
        }
    }
}
