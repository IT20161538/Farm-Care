package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddEmployeeDetails extends AppCompatActivity {

    private Button add_employee, view_employee;
    private EditText employeeid, name, nic, gender, contactno;
    DBHelper9 DB;
    ImageView imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_details);


        imageView3= (ImageView) findViewById(R.id.imageView3);
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


      /* add_employee.setOnClickListener(v -> {
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
                insertEmployees();
            }
        });*/

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });


        add_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeid11 = employeeid.getText().toString();
                String name1 = name.getText().toString();
                String nic1 = nic.getText().toString();
                String gender1 = gender.getText().toString();
                String contact1 = contactno.getText().toString();

                boolean check = validateinfo(employeeid11,name1,nic1,gender1,contact1);

                if(check==true){
                    insertEmployees();
                    //Toast.makeText(getApplicationContext(),"Data is Valid", Toast.LENGTH_SHORT).show();
                }
                else {
                 Toast.makeText(getApplicationContext(),"Check Information again", Toast.LENGTH_SHORT).show();
                }
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

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }


    private Boolean validateinfo(String emplyeeid11, String name1, String nic1, String gender1, String contact1){
        if(emplyeeid11.length()==0){
            employeeid.requestFocus();
            employeeid.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(name1.length()==0){
            name.requestFocus();
            name.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(!name1.matches("[a-z,' ',A-Z]*")){
            name.requestFocus();
            name.setError("Enter Only Character");
            return false;
        }
        else if(nic1.length()==0){
            nic.requestFocus();
            nic.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(!nic1.matches("^([0-9]{9}[x|X|v|V]|[0-9]{12})$")){
            nic.requestFocus();
            nic.setError("Enter the Valid NIC");
            return false;
        }
        else if(gender1.length()==0){
            gender.requestFocus();
            gender.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(contact1.length()==0){
            contactno.requestFocus();
            contactno.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(!contact1.matches("[0-9]{10}")){
            contactno.requestFocus();
            contactno.setError("Enter Only 10 Digit Mobile Number");
            return false;
        }
        else{
            return true;
        }
    }

}