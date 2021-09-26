package com.example.fame_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalCrop_Home extends AppCompatActivity {

    private Button animal, crop, task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_crop_home);

        animal = (Button) findViewById(R.id.btn_animalm);
        crop = (Button) findViewById(R.id.btn_crop);
        task = (Button) findViewById(R.id.btn_taskmanage);

        animal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){openAddAnimalPage();}
        });

        crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) { openAddCropPage();}
        });

    }

    public void openAddAnimalPage(){
        Intent intent = new Intent(this, AddAnimalVacc_Detail.class);
        startActivity(intent);

    }

    public void openAddCropPage(){
        Intent intent = new Intent(this, AddCropManage.class);
        startActivity(intent);
    }


}