package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddWorkSchedule extends AppCompatActivity {

    private Button add_workschedule, view_workschedule;
    private EditText employeeid, section, work, date, time;
    DBHelper8 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_schedule);

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

    public void openWorkSchedulePage(){
        Intent intent = new Intent(this, WorkScheduleDetails.class);
        startActivity(intent);
    }

}