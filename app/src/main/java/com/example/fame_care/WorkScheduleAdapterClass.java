package com.example.fame_care;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class WorkScheduleAdapterClass extends ArrayAdapter<WorkSceduleModelClass>{


    private Context context;
    private int resource;
    List<WorkSceduleModelClass> workSceduleModelClasses;


    public WorkScheduleAdapterClass(@NonNull Context context, int resource, List<WorkSceduleModelClass> workSceduleModelClasses) {
        super(context, resource, workSceduleModelClasses);
        this.context = context;
        this.resource = resource;
        this.workSceduleModelClasses = workSceduleModelClasses;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView eid = row.findViewById((R.id.tv_workschedule_iddata));
        TextView section = row.findViewById(R.id.tv_workschedule_sectiondata);
        TextView work = row.findViewById(R.id.tv_workschedule_workdata);
        TextView date = row.findViewById(R.id.tv_workschedule_datedata);
        TextView time = row.findViewById(R.id.tv_workschedule_timedata);


        WorkSceduleModelClass workSceduleModelClass = workSceduleModelClasses.get(position);
        eid.setText(workSceduleModelClass.getEid());
        section.setText(workSceduleModelClass.getSection());
        work.setText(workSceduleModelClass.getWork());
        date.setText(workSceduleModelClass.getDate());
        time.setText(workSceduleModelClass.getTime());

        return row;

    }
}

