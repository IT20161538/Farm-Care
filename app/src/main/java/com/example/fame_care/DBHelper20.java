package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper20 extends SQLiteOpenHelper{
public static final String DBNAME = "Farm_Care_20";
public static final String TABLE_NAME = "AddAnimal";
public static final String COL_1 = "ProductId";
public static final String COL_2 = "Name";
public static final String COL_3 = "Harvest";
public static final String COL_4 = "Orderr";
public static final String COL_5 = "Remainder";
public static final String COL_6 = "CompanyName";
public static final String COL_7 = "PickupDate";
public static final String COL_8 = "UnitPrice";

public DBHelper20(Context context) {
    super(context, DBNAME,null, 1);


}


@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ProductId INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Harvest INTEGER, Orderr INTEGER, Remainder INTEGER, CompanyName TEXT, PickupDate TEXT, UnitPrice INTEGER)");
}

@Override
public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
}

public boolean insertData(String Name, String Harvest, String Orderr, String Remainder, String CompanyName, String PickupDate, String UnitPrice){
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues contentValues = new ContentValues();
    contentValues.put(COL_2, Name);
    contentValues.put(COL_3, Harvest);
    contentValues.put(COL_4, Orderr);
    contentValues.put(COL_5, Remainder);
    contentValues.put(COL_6, CompanyName);
    contentValues.put(COL_7, PickupDate);
    contentValues.put(COL_8, UnitPrice);

    long result = db.insert("AddAnimal", null, contentValues);

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
    public Cursor getAllData2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


}


