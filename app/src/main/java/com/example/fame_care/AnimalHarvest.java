package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AnimalHarvest extends AppCompatActivity {

    private Button addnew;
    private ListView aniharvestlist;
    Context context;
    private List<AnimalHarvestMethods> aharvestlist;
    DBHelper2 dbHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_harvest);

        addnew = findViewById(R.id.btn_animaladdnew);
        aniharvestlist = findViewById(R.id.animalharvest_list);
        context = this;
        aharvestlist = new ArrayList<>();
        dbHelper2 = new DBHelper2(this);

        aharvestlist = dbHelper2.getAnimalHarvest();

        AnimalHarvestAdapter aniadapter = new AnimalHarvestAdapter(context, R.layout.animal_harvest_view, aharvestlist);
        aniharvestlist.setAdapter(aniadapter);

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAnimalHarvest();
            }
        });
    }
    public void addAnimalHarvest(){
        Intent intent = new Intent(this, AddAnimalHarvest.class);
        startActivity(intent);
    }
}