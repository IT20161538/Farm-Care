package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FarmCareHome extends AppCompatActivity {

    private Button btnharvest;

    private Button employee;

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
}