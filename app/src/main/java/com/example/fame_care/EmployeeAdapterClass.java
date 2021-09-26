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

public class EmployeeAdapterClass extends ArrayAdapter<EmployeeModelClass> {

    private Context context;
    private int resource;
    List<EmployeeModelClass> employeeModelClasses;


    EmployeeAdapterClass(Context context, int resource, List<EmployeeModelClass> employeeModelClasses){
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

        TextView employeeid = row.findViewById((R.id.tv_emplyeeiddata));
        TextView name = row.findViewById(R.id.tv_employeenamedata);
        TextView nic = row.findViewById(R.id.tv_employeenicdata);
        TextView gender = row.findViewById(R.id.tv_employeegenderdata);
        TextView contactno = row.findViewById(R.id.tv_employeecontactdata);


        EmployeeModelClass employeeModelClass = employeeModelClasses.get(position);
        employeeid.setText(employeeModelClass.getEmployeeid());
        name.setText(employeeModelClass.getName());
        nic.setText(employeeModelClass.getNic());
        gender.setText(employeeModelClass.getGender());
        contactno.setText(employeeModelClass.getContactno());

        return row;

    }
}
