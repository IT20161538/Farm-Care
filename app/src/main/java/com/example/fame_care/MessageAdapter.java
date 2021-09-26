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

public class MessageAdapter extends ArrayAdapter<EmployeeModelClass> {


    private Context context;
    private int resource;
    List<EmployeeModelClass> employeeModelClasses;

    MessageAdapter(Context context, int resource, List<EmployeeModelClass> employeeModelClasses){
        super(context,resource,employeeModelClasses);
        this.context = context;
        this.resource = resource;
        this.employeeModelClasses = employeeModelClasses;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);


        TextView contactno = row.findViewById(R.id.et_sendcontactnodata);


        EmployeeModelClass employeeModelClass = employeeModelClasses.get(position);
        contactno.setText(employeeModelClass.getContactno());

        return row;

    }
}
