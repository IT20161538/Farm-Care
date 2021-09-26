package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployeeDetails extends AppCompatActivity {

    private Button add_employee, view_employee;
    private EditText employeeid, name, nic, gender, contactno;
    DBHelper9 DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_details);

        add_employee = (Button) findViewById(R.id.btn_addemployee);
        view_employee = (Button) findViewById(R.id.btn_viewemployee);
        employeeid = findViewById(R.id.et_addemployeeid);
        name = findViewById(R.id.et_addemployeename);
        nic = findViewById(R.id.et_addemployeenic);
        gender = findViewById(R.id.et_addemployeegender);
        contactno = findViewById(R.id.et_addemployeecontact);
        DB = new DBHelper9(this);


        insertEmployees();

        view_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openEmployeeDetailsPage();
            }
        });

    }

    private void insertEmployees(){
        add_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var3 = DB.insertEmployee(employeeid.getText().toString(), name.getText().toString(), nic.getText().toString(), gender.getText().toString(), contactno.getText().toString());
                employeeid.setText("");
                name.setText("");
                nic.setText("");
                gender.setText("");
                contactno.setText("");

                if(var3){
                    Toast.makeText(AddEmployeeDetails.this, "Insert Success!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AddEmployeeDetails.this, "Insert Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void openEmployeeDetailsPage(){
        Intent intent = new Intent(this, EmployeeDetails.class);
        startActivity(intent);
    }

}