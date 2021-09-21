package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Farm_Care_App";

    public static final String TABLE_NAME = "user";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "email";
    public static final String COL_4 = "phone";
    public static final String COL_5 = "location";
    public static final String COL_6 = "username";
    public static final String COL_7 = "password";

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, phone TEXT, location TEXT, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean registerUser(String name, String email, String phone, String location, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        values1.put(COL_2, name);
        values1.put(COL_3, email);
        values1.put(COL_4, phone);
        values1.put(COL_5, location);
        values1.put(COL_6, username);
        values1.put(COL_7, password);

        long result = db.insert("user", null, values1);

        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] columns = {COL_1};
        String selection = COL_6 + "=?" + " and " + COL_7 + "=?";
        String [] selectionargs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionargs, null, null, null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if(count > 0)
            return true;

        else
            return false;

    }
}
