package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Farm_Care";
    public static final String TABLE_NAME = "user";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "email";
    public static final String COL_4 = "phone";
    public static final String COL_5 = "location";
    public static final String COL_6 = "username";
    public static final String COL_7 = "password";




    public DBHelper(@Nullable Context context) { super(context, DBNAME, null, 1);  }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, phone TEXT, location TEXT, username TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean register(String name, String email, String phone, String location, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, phone);
        contentValues.put(COL_5, location);
        contentValues.put(COL_6, username);
        contentValues.put(COL_7, password);

        long result = db.insert("user", null, contentValues);

        if(result == -1)
            return false;

        else
            return true;
    }

    public boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
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
