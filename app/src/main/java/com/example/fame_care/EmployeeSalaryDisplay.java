package com.example.fame_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryDisplay extends AppCompatActivity {

    private ListView salarydetailsList;
    Context context;
    DBHelper7 DB;
    private List<SalaryModelClass> salaryModelClasses;
    ImageView imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_salary_display);

        imageView3= (ImageView) findViewById(R.id.imageView3);
        salarydetailsList  = findViewById(R.id.salarydetailsList);
        context = this;
        DB = new DBHelper7(context);
        salaryModelClasses = new ArrayList<>();

        salaryModelClasses = DB.getSalaryDetailsList();

        SalaryAdapterClass adapter = new SalaryAdapterClass(context,R.layout.salary_details_view,salaryModelClasses);

        salarydetailsList.setAdapter(adapter);

        salarydetailsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                final SalaryModelClass salaryModelClass = salaryModelClasses.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(salaryModelClass.getEmployeeid());
                builder.setMessage(salaryModelClass.getTotalsalary());

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DB.deleteSalaryModelClass(salaryModelClass.getId());
                        startActivity(new Intent(context, AddEmployeeSalary.class));

                    }
                });
                builder.show();
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