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

public class activity_crop extends AppCompatActivity{

    private Button AddNewCrop;
    private RecyclerView recyclerView;
    DBHelper21 myDb;
    private List<Crops> cropsList;
    private cropAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);
        myDb = new DBHelper21(this);

        cropsList = new ArrayList<>();

        recyclerView = findViewById(R.id.rvPrograms);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Empty");
            builder.setMessage("No crops to display!");
            builder.show();

            return;
        }

        while (res.moveToNext()) {

            String ProductId =res.getString(0);
            String Name =res.getString(1);
            String Harvest =res.getString(2);
            String Order =res.getString(3);
            String Remainder =res.getString(4);
            String CompanyName =res.getString(5);
            String PickupDate=res.getString(6);
            String UnitPrice =res.getString(7);
            Crops contact = new Crops(ProductId,Name,Harvest,Order,Remainder,CompanyName,PickupDate,UnitPrice);
            cropsList.add(contact);
        }

        adapter = new cropAdapter(this, cropsList, recyclerView,myDb);
        recyclerView.setAdapter(adapter);
    }
}