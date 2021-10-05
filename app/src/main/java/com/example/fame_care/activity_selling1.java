package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class activity_selling1 extends AppCompatActivity{

    private Button Animal;
    private Button Crops;
    //ImageView imageView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling1);
        //imageView12= (ImageView) findViewById(R.id.imageView12 );


        Crops= (Button)findViewById(R.id.btn_crop1);
        Crops.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){openactivity_crop();}

        });

        Animal= (Button)findViewById(R.id.btn_animal2);
        Animal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){openactivity_animal();}

        });

    }

    public void openactivity_crop(){
        Intent intent = new Intent(this,activity_add_crop.class);
        startActivity(intent);
    }
    public void openactivity_animal(){
        Intent intent = new Intent(this,activity_add_animal1.class);
        startActivity(intent);
    }
}