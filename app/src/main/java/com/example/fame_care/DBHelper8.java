package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper8 extends SQLiteOpenHelper {


    public static final String DBNAME8 = "Farm_Care8";
    public static final String TABLE_NAME108 = "WorkSchedule";
    public static final String COL_106 = "id";
    public static final String COL_107 = "eid";
    public static final String COL_108 = "section";
    public static final String COL_109 = "work";
    public static final String COL_110 = "date";
    public static final String COL_111 = "time";


    public DBHelper8(@Nullable Context context) { super(context, DBNAME8, null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME108 + "(id INTEGER PRIMARY KEY AUTOINCREMENT, eid TEXT, section TEXT, work TEXT, date TEXT, time Text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME108);
    }


    public boolean insertWorkSchedule(String eid, String section, String work, String date, String time){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_107, eid);
        contentValues.put(COL_108, section);
        contentValues.put(COL_109, work);
        contentValues.put(COL_110, date);
        contentValues.put(COL_111, time);

        long result = db.insert("WorkSchedule", null, contentValues);

        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public List<WorkSceduleModelClass> getWorkScheduleList(){

        List<WorkSceduleModelClass> workSceduleModelClasses = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME108;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                WorkSceduleModelClass workSceduleModelClass = new WorkSceduleModelClass();
                workSceduleModelClass.setId(cursor.getInt(0));
                workSceduleModelClass.setEid(cursor.getString(1));
                workSceduleModelClass.setSection(cursor.getString(2));
                workSceduleModelClass.setWork(cursor.getString(3));
                workSceduleModelClass.setDate(cursor.getString(4));
                workSceduleModelClass.setTime(cursor.getString(5));
                workSceduleModelClasses.add(workSceduleModelClass);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return workSceduleModelClasses;
    }

    public void deleteWorkScheduleModelClass(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME108, COL_106 +" =?", new String[]{String.valueOf(id)});
        db.close();

    }


}
