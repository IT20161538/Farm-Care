package com.example.fame_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper11 extends SQLiteOpenHelper {
    public static final String DBNAME11 = "Farm_Care_11";
    public static final String TABLE_NAME11 = "animalmanage";
    public static final String COL_1 = "id";
    public static final String COL_2 = "section";
    public static final String COL_3 = "animalType";
    public static final String COL_4 = "dateOfBirth";
    public static final String COL_5 = "lvDate";
    public static final String COL_6 = "dvDate";
    public static final String COL_7 = "age";


    public DBHelper11(@Nullable Context context) {
        super(context, DBNAME11, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME11 + "(id INTEGER PRIMARY KEY AUTOINCREMENT, section TEXT, animalType TEXT, dateOfBirth TEXT, lvDate TEXT, dvDate TEXT, age TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME11);

    }

    public boolean addAnimalManage(String section, String animalType, String dateOfBirth, String lvDate, String dvDate, String age) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, section);
        contentValues.put(COL_3, animalType);
        contentValues.put(COL_4, dateOfBirth);
        contentValues.put(COL_5, lvDate);
        contentValues.put(COL_6, dvDate);
        contentValues.put(COL_7, age);

        //insert to table
        long result = db.insert("animalmanage", null, contentValues);

        if (result == -1)
            return false;

        else
            return true;

    }

    //get crop details to the list
    public List<AnimalManageModel> getAllAnimalManageDetails() {

        List<AnimalManageModel> animalsModel = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME11;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                AnimalManageModel am = new AnimalManageModel();

                am.setId(cursor.getInt(0));
                am.setSection(cursor.getString(1));
                am.setAnimalType(cursor.getString(2));
                am.setDateOfBirth(cursor.getString(3));
                am.setLvDate(cursor.getString(4));
                am.setDvDate(cursor.getString(5));
                am.setAge(cursor.getString(6));

                animalsModel.add(am);

            } while (cursor.moveToNext());
        }
        return animalsModel;
    }


    //Delete data
    public void deleteAnimalManage(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME11, COL_1 + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public AnimalManageModel getSingleRow(int id) {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME11, new String[]{COL_1, COL_2, COL_3, COL_4, COL_5, COL_5, COL_6, COL_7}, COL_1 + "=?", new String[]{String.valueOf(id)},
                null, null, null);

        AnimalManageModel animalsModel;

        if (cursor != null) {
            cursor.moveToFirst();

            animalsModel = new AnimalManageModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)

            );
            return animalsModel;
        }
        return null;
    }

    public int updateSingleRow(AnimalManageModel animal){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, animal.getSection());
        contentValues.put(COL_3, animal.getAnimalType());
        contentValues.put(COL_4, animal.getDateOfBirth());
        contentValues.put(COL_5, animal.getLvDate());
        contentValues.put(COL_6, animal.getDvDate());
        contentValues.put(COL_7, animal.getAge());

        int status = db.update(TABLE_NAME11,contentValues,COL_1+" =?",new String[]{
                String.valueOf(animal.getId())});

        db.close();
        return status;

    }

}