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

public class EditEmployeeDetails extends AppCompatActivity {

    private Button edit_employee;
    private EditText employeeid,name, nic, gender, contactno;
    private DBHelper9 DB;
    private Context context;
    ImageView imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee_details);


        imageView3= (ImageView) findViewById(R.id.imageView3);
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

       /* edit_employee.setOnClickListener(new View.OnClickListener() {
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
        });*/

        edit_employee.setOnClickListener(v -> {

            if(employeeid.length() == 0 || name.length() == 0 || nic.length() == 0 || gender.length() == 0 || contactno.length() == 0){
                Toast.makeText(this, "Please Enter Fields", Toast.LENGTH_LONG).show();
            }
            else if(!name.getText().toString().matches("[a-z,' ',A-Z]*")){
                name.setError("Enter Only Character");
            }
            else if(!nic.getText().toString().matches("^([0-9]{9}[x|X|v|V]|[0-9]{12})$")){
                nic.setError("Enter Only Character");
            }
            else if(!contactno.getText().toString().matches("[0-9]{10}")){
                contactno.setError("Enter Only 10 Digit Mobile Number");
            }
            else {
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
                        Toast.makeText(EditEmployeeDetails.this, "Update Successful!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, EmployeeDetails.class);
                        startActivity(intent);

                    }
                });
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });



    }

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }
}