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

public class SalaryAdapterClass extends ArrayAdapter<SalaryModelClass> {


    private Context context;
    private int resource;
    List<SalaryModelClass> salaryModelClasses;

    public SalaryAdapterClass(@NonNull Context context, int resource, List<SalaryModelClass> salaryModelClasses) {
        super(context, resource, salaryModelClasses);
        this.context = context;
        this.resource = resource;
        this.salaryModelClasses = salaryModelClasses;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView emplyeeid = row.findViewById((R.id.tv_salaryiddata));
        TextView basicsalary = row.findViewById(R.id.tv_salary_basicsalarydata);
        TextView othours = row.findViewById(R.id.tv_salaryothoursdata);
        TextView totalsalary = row.findViewById(R.id.tv_salaryTotalsalarydata);

        SalaryModelClass salaryModelClass = salaryModelClasses.get(position);
        emplyeeid.setText(salaryModelClass.getEmployeeid());
        basicsalary.setText(salaryModelClass.getBasicsalary());
        othours.setText(salaryModelClass.getOthours());
        totalsalary.setText(salaryModelClass.getTotalsalary());

        return row;

    }

}
