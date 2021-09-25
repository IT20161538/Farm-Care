package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.view.View;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper3 extends SQLiteOpenHelper {

    public static final String DBNAME = "Farm_Care_004";

    public static final String TABLE_NAME400_2 = "crop_harvest";
    public static final String COL_410 = "id";
    public static final String COL_411 = "crop_type";
    public static final String COL_412 = "section";
    public static final String COL_413 = "date";
    public static final String COL_414 = "amount";
    public static final String COL_415 = "condition";

    public DBHelper3(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME400_2 + "(id INTEGER PRIMARY KEY AUTOINCREMENT, crop_type TEXT, section TEXT, date TEXT, amount TEXT, condition TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME400_2);
    }

    public boolean addcropharvest(String crop_type, String section, String date, String amount, String condition){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(COL_411, crop_type);
        contentValues3.put(COL_412, section);
        contentValues3.put(COL_413, date);
        contentValues3.put(COL_414, amount);
        contentValues3.put(COL_415, condition);

        long result3 = db.insert("crop_harvest", null, contentValues3);

        if(result3 == -1)
            return false;

        else
            return true;
    }

    public List<CropHarvestMethods> getCropHarvest(){

        List<CropHarvestMethods> crop = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME400_2;

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                CropHarvestMethods cropHarvestMethods = new CropHarvestMethods();

                cropHarvestMethods.setId(cursor.getInt(0));
                cropHarvestMethods.setcType(cursor.getString(1));
                cropHarvestMethods.setcSection(cursor.getString(2));
                cropHarvestMethods.setcDate(cursor.getString(3));
                cropHarvestMethods.setcAmount(cursor.getString(4));
                cropHarvestMethods.setcCondition(cursor.getString(5));

                crop.add(cropHarvestMethods);
            }while (cursor.moveToNext());
        }
        return crop;
    }

    public void deleteCropHarvest(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME400_2, COL_410 +" =?", new String[]{String.valueOf(id)});
        db.close();
    }

    public CropHarvestMethods getSelectData(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME400_2, new String[]{COL_410, COL_411, COL_412, COL_413, COL_414, COL_415}, COL_410 + " =?", new String[]{String.valueOf(id)}, null, null, null);

        CropHarvestMethods method2;
        if(cursor != null){
            cursor.moveToFirst();
            method2 = new CropHarvestMethods(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            return method2;
        }
        return null;
    }

    public int updateCropHarvest(CropHarvestMethods meth){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(COL_411, meth.getcType());
        contentValues3.put(COL_412, meth.getcSection());
        contentValues3.put(COL_413, meth.getcDate());
        contentValues3.put(COL_414, meth.getcAmount());
        contentValues3.put(COL_415, meth.getcCondition());

        int status = db.update(TABLE_NAME400_2, contentValues3, COL_410 +" =?", new String[]{String.valueOf(meth.getId())});

        db.close();

        return status;
    }

}
