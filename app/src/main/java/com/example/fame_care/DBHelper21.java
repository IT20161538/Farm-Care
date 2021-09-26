package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper21 extends SQLiteOpenHelper{
    public static final String DBNAME = "Farm_Care_21";
    public static final String TABLE_NAME = "AddCrop";
    public static final String COL_1 = "ProductId";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Harvest";
    public static final String COL_4 = "Orderr";
    public static final String COL_5 = "Remainder";
    public static final String COL_6 = "CompanyName";
    public static final String COL_7 = "PickupDate";
    public static final String COL_8 = "UnitPrice";

    public DBHelper21(Context context) {
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

        long result = db.insert("AddCrop", null, contentValues);

        if(result == -1)
            return false;

        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ProductId = ?",new String[] {id});
    }

    public boolean updateData(String ProductId ,String UpdateName,String UpdateHarvest,String UpdateOrder,String UpdateRemainder,String UpdatePdate,String UpdateUnitprice ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,ProductId);
        contentValues.put(COL_2,UpdateName);
        contentValues.put(COL_3,UpdateHarvest);
        contentValues.put(COL_4,UpdateOrder);
        contentValues.put(COL_5,UpdateRemainder);
        contentValues.put(COL_7,UpdatePdate);
        contentValues.put(COL_8,UpdateUnitprice);
        db.update(TABLE_NAME, contentValues, "ProductId = ?",new String[] { ProductId });
        return true;
    }
}