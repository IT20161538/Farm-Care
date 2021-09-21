package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FarmCareHome extends AppCompatActivity {

    private Button btnharvest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_care_home);

        btnharvest = findViewById(R.id.btn_harvest);

        btnharvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadHarvestHome();
            }
        });
    }
    public void loadHarvestHome(){
        Intent intent = new Intent(this, Harvest_Home.class);
        startActivity(intent);
    }
}