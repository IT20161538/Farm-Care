package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditEmployeeDetails extends AppCompatActivity {

    private Button edit_employee;
    private EditText employeeid,name, nic, gender, contactno;
    private DBHelper9 DB;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee_details);



        context = this;
        DB = new DBHelper9(context);
        employeeid = findViewById(R.id.et_editemployeeid);
        name = findViewById(R.id.et_editemployeename);
        nic = findViewById(R.id.et_editemployeenic);
        gender = findViewById(R.id.et_editemployeegender);
        contactno = findViewById(R.id.et_editemployeecontact);
        edit_employee = (Button) findViewById(R.id.btn_edited_edit);

        final String id = getIntent().getStringExtra("id");
        EmployeeModelClass employeeModelClass = DB.getSingleEmloyeeModelClass(Integer.parseInt(id));

        employeeid.setText(employeeModelClass.getEmployeeid());
        name.setText(employeeModelClass.getName());
        nic.setText(employeeModelClass.getNic());
        gender.setText(employeeModelClass.getGender());
        contactno.setText(employeeModelClass.getContactno());

        edit_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employeeidText = employeeid.getText().toString();
                String nameText = name.getText().toString();
                String nicText = nic.getText().toString();
                String genderText = gender.getText().toString();
                String contactText = contactno.getText().toString();

                EmployeeModelClass employeeModelClass = new EmployeeModelClass(Integer.parseInt(id),employeeidText,nameText,nicText,genderText,contactText);
                int state = DB.updateSingleEmployeeModelClass(employeeModelClass);
                startActivity(new Intent(context,EmployeeDetails.class));

            }
        });

    }
}