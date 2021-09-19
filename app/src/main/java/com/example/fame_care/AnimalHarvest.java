package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class AnimalHarvest extends AppCompatActivity {

    private Button addnew;
    private ListView aniharvestlist;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_harvest);

        addnew = findViewById(R.id.btn_animaladdnew);
        aniharvestlist = findViewById(R.id.animalharvest_list);
        context = this;

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, AddAnimalHarvest.class));
            }
        });
    }
}