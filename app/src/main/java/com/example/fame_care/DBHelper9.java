package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper9 extends SQLiteOpenHelper {


    public static final String DBNAME9 = "Farm_Care9";
    public static final String TABLE_NAME109 = "employeedetails";
    public static final String COL_112 = "id";
    public static final String COL_113 = "employeeid";
    public static final String COL_114 = "name";
    public static final String COL_115 = "nic";
    public static final String COL_116 = "gender";
    public static final String COL_117 = "contactno";


    public DBHelper9(@Nullable Context context) { super(context, DBNAME9, null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME109 + "(id INTEGER PRIMARY KEY AUTOINCREMENT, employeeid TEXT, name TEXT, nic TEXT, gender TEXT, contactno Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME109);

    }

    public boolean insertEmployee(String employeeid, String name, String nic, String gender, String contactno){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_113, employeeid);
        contentValues.put(COL_114, name);
        contentValues.put(COL_115, nic);
        contentValues.put(COL_116, gender);
        contentValues.put(COL_117, contactno);

        long result = db.insert("employeedetails", null, contentValues);

        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public List<EmployeeModelClass> getAllEmployees(){

        List<EmployeeModelClass> employeeModelClasses = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME109;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                EmployeeModelClass employeeModelClass = new EmployeeModelClass();
                employeeModelClass.setId(cursor.getInt(0));
                employeeModelClass.setEmployeeid(cursor.getString(1));
                employeeModelClass.setName(cursor.getString(2));
                employeeModelClass.setNic(cursor.getString(3));
                employeeModelClass.setGender(cursor.getString(4));
                employeeModelClass.setContactno(cursor.getString(5));
                employeeModelClasses.add(employeeModelClass);
            }while (cursor.moveToNext());

        }
        return employeeModelClasses;
    }


    public void deleteEmployeeModelClass(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME109,COL_112 +" =?", new String[]{String.valueOf(id)});
        db.close();
    }

    public EmployeeModelClass getSingleEmloyeeModelClass(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME109,new String[]{COL_112,COL_113,COL_114,COL_115,COL_116,COL_117}, COL_112 + "= ?",new String[]{String.valueOf(id)},null,null,null);

        EmployeeModelClass employeeModelClass;
        if (cursor != null){
            cursor.moveToFirst();

            employeeModelClass = new EmployeeModelClass(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return employeeModelClass;
        }
        return null;
    }

    public int updateSingleEmployeeModelClass(EmployeeModelClass employeeModelClass){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_113, employeeModelClass.getEmployeeid());
        contentValues.put(COL_114, employeeModelClass.getName());
        contentValues.put(COL_115, employeeModelClass.getNic());
        contentValues.put(COL_116, employeeModelClass.getGender());
        contentValues.put(COL_117, employeeModelClass.getContactno());

        int status = db.update(TABLE_NAME109,contentValues,COL_112+" =?",new String[]{String.valueOf(employeeModelClass.getId())});
        db.close();
        return status;
    }


    public EmployeeModelClass getSingleMessageEmloyeeModelClass(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME109,new String[]{COL_112,COL_113,COL_114,COL_115,COL_116,COL_117}, COL_112 + "= ?",new String[]{String.valueOf(id)},null,null,null);

        EmployeeModelClass employeeModelClass1;
        if (cursor != null){
            cursor.moveToFirst();

            employeeModelClass1 = new EmployeeModelClass(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return employeeModelClass1;
        }
        return null;
    }

}
