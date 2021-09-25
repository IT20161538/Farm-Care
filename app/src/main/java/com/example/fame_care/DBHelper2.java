package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper2 extends SQLiteOpenHelper {

    public static final String DBNAME = "Farm_Care_2";

    public static final String TABLE_NAME400_1 = "animal_harvest";
    public static final String COL_405 = "id";
    public static final String COL_400 = "animal_type";
    public static final String COL_401 = "product_type";
    public static final String COL_402 = "section";
    public static final String COL_403 = "date";
    public static final String COL_404 = "amount";

    public DBHelper2(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME400_1 + "(id INTEGER PRIMARY KEY AUTOINCREMENT, animal_type TEXT, product_type TEXT, section TEXT, date TEXT, amount TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME400_1);
    }

    public boolean addanimalharvest(String animal_type, String product_type, String section, String date, String amount){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(COL_400, animal_type);
        contentValues2.put(COL_401, product_type);
        contentValues2.put(COL_402, section);
        contentValues2.put(COL_403, date);
        contentValues2.put(COL_404, amount);

        long result2 = db.insert("animal_harvest", null, contentValues2);

        if(result2 == -1)
            return false;

        else
            return true;
    }

    public List<AnimalHarvestMethods> getAnimalHarvest(){

        List<AnimalHarvestMethods> harvest = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME400_1;

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                AnimalHarvestMethods animalHarvestMethods = new AnimalHarvestMethods();

                animalHarvestMethods.setId(cursor.getInt(0));
                animalHarvestMethods.setaType(cursor.getString(1));
                animalHarvestMethods.setpType(cursor.getString(2));
                animalHarvestMethods.setaSection(cursor.getString(3));
                animalHarvestMethods.setaDate(cursor.getString(4));
                animalHarvestMethods.setaAmount(cursor.getString(5));

                harvest.add(animalHarvestMethods);
            }while (cursor.moveToNext());
        }
        return harvest;
    }

    public void deleteAnimalHarvest(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME400_1, COL_405 +" =?", new String[]{String.valueOf(id)});
        db.close();
    }

    public AnimalHarvestMethods getSelectData(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME400_1, new String[]{COL_405, COL_400, COL_401, COL_402, COL_403, COL_404}, COL_405 + " =?", new String[]{String.valueOf(id)}, null, null, null);

        AnimalHarvestMethods method2;
        if(cursor != null){
            cursor.moveToFirst();
            method2 = new AnimalHarvestMethods(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            return method2;
        }
        return null;
    }

    public int updateAnimalHarvest(AnimalHarvestMethods meth){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_400, meth.getaType());
        contentValues.put(COL_401, meth.getpType());
        contentValues.put(COL_402, meth.getaSection());
        contentValues.put(COL_403, meth.getaDate());
        contentValues.put(COL_404, meth.getaAmount());

        int status = db.update(TABLE_NAME400_1, contentValues, COL_405 +" =?", new String[]{String.valueOf(meth.getId())});

        db.close();

        return status;
    }
}
