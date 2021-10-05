package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddEmployeeSalary extends AppCompatActivity {

    private Button add_salary, view_salary,btncalculate;
    private EditText employeeid, basicsalary, othours, totalsalary;
    private DBHelper7 DB;
    private Context context;
    ImageView imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_salary);

        imageView3= (ImageView) findViewById(R.id.imageView3);
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

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });

        add_salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeid111 = employeeid.getText().toString();
                String basicsalary1 = basicsalary.getText().toString();
                String othours1 = othours.getText().toString();
                String totalsalary1 = totalsalary.getText().toString();

                boolean check = validateinfo(employeeid111,basicsalary1,othours1,totalsalary1);

                if(check==true){
                    insertEmployeeSalary();
                    //Toast.makeText(getApplicationContext(),"Data is Valid", Toast.LENGTH_SHORT).show();
                }
                else{
                 Toast.makeText(getApplicationContext(),"Check Information again", Toast.LENGTH_SHORT).show();
                }
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

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }

    private Boolean validateinfo(String emplyeeid111, String basicsalary1, String othours1, String totalsalary1){
        if(emplyeeid111.length()==0){
            employeeid.requestFocus();
            employeeid.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(basicsalary1.length()==0){
            basicsalary.requestFocus();
            basicsalary.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(!basicsalary1.matches("[0-9][0-9][0-9][0-9][0-9]")){
            basicsalary.requestFocus();
            basicsalary.setError("Enter Only Integer");
            return false;
        }
        else if(othours1.length()==0){
            othours.requestFocus();
            othours.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(!othours1.matches("[0-9]*")){
            othours.requestFocus();
            othours.setError("Enter Only Integer");
            return false;
        }
        else if(totalsalary1.length()==0){
            totalsalary.requestFocus();
            totalsalary.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(!totalsalary1.matches("[0-9][0-9][0-9][0-9][0-9]")){
            totalsalary.requestFocus();
            totalsalary.setError("Enter Only Integer");
            return false;
        }
        else{
            return true;
        }
    }
}