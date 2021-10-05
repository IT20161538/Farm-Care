package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FarmCareHome extends AppCompatActivity {

    private Button btnharvest;
    private Button Selling, logout;
    private Button management;

    private Button employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_care_home);

        btnharvest = findViewById(R.id.btn_harvest);
        logout = findViewById(R.id.btn_logout);

        btnharvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadHarvestHome();
            }
        });
        Selling= (Button)findViewById(R.id.btn_selling);
        Selling.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){openactivity_selling();}

        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FarmCareHome.this, UserLogin.class);
                startActivity(intent);

            }
        });

        management = findViewById(R.id.btn_management);

        management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openAnimalCropHomePage();}
        });
    }
    public void loadHarvestHome(){
        Intent intent = new Intent(this, Harvest_Home.class);
        startActivity(intent);

        employee = (Button) findViewById(R.id.btn_employee);

        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmployeeManagementHomePage();
            }
        });
    }

    public void openEmployeeManagementHomePage(){
        Intent intent = new Intent(this, EmployeeManagement.class);
        startActivity(intent);
    }

    public void openactivity_selling(){
        Intent intent = new Intent(this,activity_selling1.class);
        startActivity(intent);
    }




    public void openAnimalCropHomePage(){
        Intent intent = new Intent(this,AnimalCrop_Home.class);
        startActivity(intent);

    }

}