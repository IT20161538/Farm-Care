package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployeeSalary extends AppCompatActivity {

    private Button add_salary, view_salary,btncalculate;
    private EditText employeeid, basicsalary, othours, totalsalary;
    private DBHelper7 DB;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_salary);


        add_salary = (Button) findViewById(R.id.btn_addsalary);
        view_salary = (Button) findViewById(R.id.btn_viewsalarydetails);
        btncalculate = (Button) findViewById(R.id.btn_calculate);
        employeeid = findViewById(R.id.et_addsalaryid);
        basicsalary = findViewById(R.id.et_addsalary_basicsalary);
        othours = findViewById(R.id.et_addsalaryothours);
        totalsalary = findViewById(R.id.et_addsalaryTotalsalary);
        context = this;
        DB = new DBHelper7(this);


        insertEmployeeSalary();


        view_salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmployeeSalaryDetailsPage();
            }
        });

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employeesalary();
            }
        });

    }

    public void employeesalary(){
        
        int ot_hours,basic_salary,tsalary;

        ot_hours = Integer.parseInt(othours.getText().toString());
        basic_salary = Integer.parseInt(basicsalary.getText().toString());

        if(ot_hours == 0){
            ot_hours = 0;
        }else{
            ot_hours = ot_hours * 400;
        }

        tsalary = basic_salary + ot_hours;

        totalsalary.setText(String.valueOf(tsalary));
    }

    private void insertEmployeeSalary(){
        add_salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean var3 = DB.insertSalaryDetails(employeeid.getText().toString(), basicsalary.getText().toString(), othours.getText().toString(), totalsalary.getText().toString());

                employeeid.setText("");
                basicsalary.setText("");
                othours.setText("");
                totalsalary.setText("");

                if(var3){
                    Toast.makeText(AddEmployeeSalary.this, "Insert Success!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AddEmployeeSalary.this, "Insert Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void openEmployeeSalaryDetailsPage(){
        Intent intent = new Intent(this, EmployeeSalaryDisplay.class);
        startActivity(intent);
    }


}