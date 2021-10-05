package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddWorkSchedule extends AppCompatActivity {

    private Button add_workschedule, view_workschedule;
    private EditText employeeid, section, work, date, time;
    DBHelper8 DB;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_schedule);

        imageView3= (ImageView) findViewById(R.id.imageView3);
        add_workschedule = (Button) findViewById(R.id.btn_addworkschedule);
        view_workschedule = (Button) findViewById(R.id.btn_viewworkschedule);
        employeeid = findViewById(R.id.et_workscheduleid);
        section = findViewById(R.id.et_workschedulesection);
        work = findViewById(R.id.et_workschedulework);
        date = findViewById(R.id.et_workscheduledate);
        time = findViewById(R.id.et_workscheduletime);
        DB = new DBHelper8(this);

        insertworkschedule();

        view_workschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkSchedulePage();
            }
        });

        add_workschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String employeeid1 = employeeid.getText().toString();
                String section1 = section.getText().toString();
                String work1 = work.getText().toString();
                String date1 = date.getText().toString();
                String time1 = time.getText().toString();

                boolean check = validateinfo(employeeid1,section1,work1,date1,time1);

                if(check==true){
                     insertworkschedule();
                     //Toast.makeText(getApplicationContext(),"Data is Valid", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Check Information again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });


    }

    private void insertworkschedule(){
        add_workschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var2 = DB.insertWorkSchedule(employeeid.getText().toString(), section.getText().toString(), work.getText().toString(), date.getText().toString(), time.getText().toString());

                employeeid.setText("");
                section.setText("");
                work.setText("");
                date.setText("");
                time.setText("");

                if(var2){
                    Toast.makeText(AddWorkSchedule.this, "Insert Success!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(AddWorkSchedule.this, "Insert Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private Boolean validateinfo(String emplyeeid1, String section1, String work1, String date1, String time1){
        if(emplyeeid1.length()==0){
            employeeid.requestFocus();
            employeeid.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(section1.length()==0){
            section.requestFocus();
            section.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(work1.length()==0){
            work.requestFocus();
            work.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(!work1.matches("[a-z,' ',A-Z]*")){
            work.requestFocus();
            work.setError("Enter Only Character");
            return false;
        }
        else if(date1.length()==0){
            date.requestFocus();
            date.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else if(time1.length()==0){
            time.requestFocus();
            time.setError("FIELD CANNOT BE EMPTY");
            return false;
        }
        else{
            return true;
        }
    }

    public void openWorkSchedulePage(){
        Intent intent = new Intent(this, WorkScheduleDetails.class);
        startActivity(intent);
    }

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }

}