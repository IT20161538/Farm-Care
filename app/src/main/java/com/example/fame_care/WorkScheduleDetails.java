package com.example.fame_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WorkScheduleDetails extends AppCompatActivity {

    private ListView workscheduleList;
    Context context;
    DBHelper8 DB;
    private List<WorkSceduleModelClass> workSceduleModelClasses;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_schedule_details);

        imageView3= (ImageView) findViewById(R.id.imageView3);
        workscheduleList  = findViewById(R.id.workscheduleList);
        context = this;
        DB = new DBHelper8(context);
        workSceduleModelClasses = new ArrayList<>();

        workSceduleModelClasses = DB.getWorkScheduleList();

        WorkScheduleAdapterClass adapter = new WorkScheduleAdapterClass(context,R.layout.work_schedule_view,workSceduleModelClasses);

        workscheduleList.setAdapter(adapter);

        workscheduleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                final WorkSceduleModelClass workSceduleModelClass = workSceduleModelClasses.get(position);
                

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(workSceduleModelClass.getEid());
                builder.setMessage(workSceduleModelClass.getWork());

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DB.deleteWorkScheduleModelClass(workSceduleModelClass.getId());
                        startActivity(new Intent(context,AddWorkSchedule.class));

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