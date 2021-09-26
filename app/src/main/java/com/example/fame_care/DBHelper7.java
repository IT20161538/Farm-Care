package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper7 extends SQLiteOpenHelper {

    public static final String DBNAME_7 = "Farm_Care_7";
    public static final String TABLE_NAME103 = "salarydetails";
    public static final String COL_120 = "id";
    public static final String COL_121 = "employeeid";
    public static final String COL_122 = "basicsalary";
    public static final String COL_123 = "othours";
    public static final String COL_124 = "totalsalary";

    public DBHelper7(@Nullable Context context) { super(context, DBNAME_7, null,1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME103 + "(id INTEGER PRIMARY KEY AUTOINCREMENT, employeeid TEXT, basicsalary TEXT, othours TEXT, totalsalary TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME103);

    }

    public boolean insertSalaryDetails(String employeeid, String basicsalary, String othours, String totalsalary){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_121, employeeid);
        contentValues.put(COL_122, basicsalary);
        contentValues.put(COL_123, othours);
        contentValues.put(COL_124, totalsalary);

        long result = db.insert("salarydetails", null,contentValues);

        if(result==-1) {
            return false;
        }
        else {
            return true;
        }

    }



    public List<SalaryModelClass> getSalaryDetailsList(){

        List<SalaryModelClass> salaryModelClasses = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME103;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                SalaryModelClass salaryModelClass = new SalaryModelClass();
                salaryModelClass.setId(cursor.getInt(0));
                salaryModelClass.setEmployeeid(cursor.getString(1));
                salaryModelClass.setBasicsalary(cursor.getString(2));
                salaryModelClass.setOthours(cursor.getString(3));
                salaryModelClass.setTotalsalary(cursor.getString(4));

                salaryModelClasses.add(salaryModelClass);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return salaryModelClasses;
    }



    public void deleteSalaryModelClass(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME103, COL_120 +" =?", new String[]{String.valueOf(id)});
        db.close();

    }
}
