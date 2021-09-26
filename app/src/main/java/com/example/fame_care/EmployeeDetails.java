package com.example.fame_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetails extends AppCompatActivity {

    private ListView employeedetailsList;
    Context context;
    DBHelper9 DB;
    private List<EmployeeModelClass> employeeModelclasses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        employeedetailsList  = findViewById(R.id.employeedetailsList);
        context = this;
        DB = new DBHelper9(context);
        employeeModelclasses = new ArrayList<>();

        employeeModelclasses = DB.getAllEmployees();

        EmployeeAdapterClass adapter = new EmployeeAdapterClass(context,R.layout.employee_details_view,employeeModelclasses);

        employeedetailsList.setAdapter(adapter);


        employeedetailsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                final EmployeeModelClass employeeModelClass = employeeModelclasses.get(position);


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(employeeModelClass.getEmployeeid());
                builder.setMessage(employeeModelClass.getName());

                builder.setPositiveButton("Send Message", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context,SendMessage.class);
                        intent.putExtra("id",String.valueOf(employeeModelClass.getId()));
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        DB.deleteEmployeeModelClass(employeeModelClass.getId());
                        startActivity(new Intent(context,AddEmployeeDetails.class));

                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context,EditEmployeeDetails.class);
                        intent.putExtra("id",String.valueOf(employeeModelClass.getId()));
                        startActivity(intent);

                    }
                });
                builder.show();
            }
        });




    }



}