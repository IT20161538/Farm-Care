package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmployeeManagement extends AppCompatActivity {

    private Button employee,workschedule,salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_management);

        employee = (Button) findViewById(R.id.btn_employees);
        workschedule = (Button) findViewById(R.id.btn_checkSchedule);
        salary = (Button) findViewById(R.id.btn_salary);

        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddEmployeeDetailsPage();
            }
        });

        workschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddWorkSchedulePage();
            }
        });

        salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddEmployeeSalaryPage();
            }
        });

    }

    public void openAddEmployeeDetailsPage(){
        Intent intent = new Intent(this, AddEmployeeDetails.class);
        startActivity(intent);
    }

    public void openAddWorkSchedulePage(){
        Intent intent = new Intent(this, AddWorkSchedule.class);
        startActivity(intent);
    }

    public void openAddEmployeeSalaryPage(){
        Intent intent = new Intent(this, AddEmployeeSalary.class);
        startActivity(intent);
    }
}