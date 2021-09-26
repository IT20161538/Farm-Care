package com.example.fame_care;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class activity_animal1 extends AppCompatActivity{

    private Button AddNewCrop;
    private RecyclerView recyclerView;
    DBHelper20 myDb;
    private List<Animals> AnimalsList;
    private animalAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal1);
        myDb = new DBHelper20(this);

        AnimalsList = new ArrayList<>();

        recyclerView = findViewById(R.id.rvPrograms1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        Cursor res = myDb.getAllData2();
        if (res.getCount() == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Empty");
            builder.setMessage("Nooooooooooooooooooooo");
            builder.show();

            return;
        }

        while (res.moveToNext()) {

            String ProductId1 = res.getString(0);
            String Name1 = res.getString(1);
            String Harvest1 = res.getString(2);
            String Order1 = res.getString(3);
            String Remainder1 = res.getString(4);
            String CompanyName1 = res.getString(5);
            String PickupDate1 = res.getString(6);
            String UnitPrice1 = res.getString(7);
            Animals contact = new Animals(ProductId1, Name1, Harvest1, Order1, Remainder1, CompanyName1, PickupDate1, UnitPrice1);
            AnimalsList.add(contact);
        }

        adapter = new animalAdapter(this, AnimalsList, recyclerView);
        recyclerView.setAdapter(adapter);
    }
}