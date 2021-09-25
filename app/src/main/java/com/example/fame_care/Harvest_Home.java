package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Harvest_Home extends AppCompatActivity {

    private Button getanimalharvest, getcropharvest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest_home);

        getanimalharvest = findViewById(R.id.btn_animalproducts);
        getcropharvest = (Button) findViewById(R.id.btn_crop);

        getcropharvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCropHarvest();
            }
        });

        getanimalharvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAnimalHarvest();
            }
        });
    }

    public void loadAnimalHarvest(){
        Intent intent = new Intent(this, AnimalHarvest.class);
        startActivity(intent);
    }

    public void loadCropHarvest(){
        Intent intent = new Intent(this, CropHarvest.class);
        startActivity(intent);
    }
}