package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

;

public class DBHelper10 extends SQLiteOpenHelper {
    public static final String DBNAME10 = "Farm_Care_10";
    public static final String TABLE_NAME10 = "cropmanage";
    public static final String COL_10 = "id";
    public static final String COL_11 = "section";
    public static final String COL_12 = "croptype";
    public static final String COL_13 = "lpdate";
    public static final String COL_14 = "dpdate";



    public DBHelper10(@Nullable Context context) {
        super(context, DBNAME10, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME10 +"(id INTEGER PRIMARY KEY AUTOINCREMENT, section TEXT, croptype TEXT, lpdate TEXT, dpdate TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME10);

    }

    public boolean addcrop(String section, String croptype, String lpdate, String dpdate){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_11, section);
        contentValues.put(COL_12, croptype);
        contentValues.put(COL_13, lpdate);
        contentValues.put(COL_14, dpdate);

        //insert to table
        long result = db.insert("cropmanage", null, contentValues);

        if(result == -1)
            return false;

        else
            return true;

    }

    //get crop details to the list
    public List<CropManageModel> getAllCropManageDetails(){

        List<CropManageModel> cropManages = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME10;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                CropManageModel cm = new CropManageModel();

                cm.setId(cursor.getInt(0));
                cm.setSection(cursor.getString(1));
                cm.setCroptype(cursor.getString(2));
                cm.setLpdate(cursor.getString(3));
                cm.setDpdate(cursor.getString(4));


                cropManages.add(cm);

            }while(cursor.moveToNext());
        }
        return cropManages;
    }

    //Delete data
    public void deleteCropManage(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME10, COL_10+"=?",new String[]{String.valueOf(id)});
        db.close();
    }

    //get single row
   public CropManageModel getSingleRow(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME10,new String[]{COL_10,COL_11,COL_12,COL_13,COL_14},COL_10 +"=?",new String[]{String.valueOf(id)},null,null,null);

       // CropManageModel cropmanage ;
        CropManageModel cropManages;
        if(cursor != null){
            cursor.moveToFirst();

            cropManages = new CropManageModel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4)
            );
            return cropManages;
        }
        return null;
    }

    public int updateSingleRow(CropManageModel crop){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_11, crop.getSection());
        contentValues.put(COL_12, crop.getCroptype());
        contentValues.put(COL_13, crop.getLpdate());
        contentValues.put(COL_14, crop.getDpdate());

        int status = db.update(TABLE_NAME10,contentValues,COL_10+" =?",new String[]{
            String.valueOf(crop.getId())});

        db.close();
        return status;

    }

}
