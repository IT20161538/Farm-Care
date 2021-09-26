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

public class AnimalManageAdapter extends ArrayAdapter<AnimalManageModel> {

    private Context context;
    private int resource;
    List<AnimalManageModel> animalsModel;

    public AnimalManageAdapter(@NonNull Context context, int resource,  List<AnimalManageModel> animalsModel) {
        super(context, resource,animalsModel);
        this.context = context;
        this.resource = resource;
        this.animalsModel = animalsModel;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView viewAnimalSection = row.findViewById(R.id.tv_singleAnimal_section);
        TextView viewAnimalType = row.findViewById(R.id.tv_singleAnimal_type);
        TextView viewAnimalDOB = row.findViewById(R.id.tv_singleAnimal_dob);
        TextView viewAnimalLVD= row.findViewById(R.id.tv_singleAnimal_lvd);
        TextView viewAnimalDVD = row.findViewById(R.id.tv_singleAnimal_dvd);
        TextView viewAnimalAge = row.findViewById(R.id.tv_singleAnimal_age);

        AnimalManageModel am = animalsModel.get(position);
        viewAnimalSection.setText(am.getSection());
        viewAnimalType.setText(am.getAnimalType());
        viewAnimalDOB.setText(am.getDateOfBirth());
        viewAnimalLVD.setText(am.getLvDate());
        viewAnimalDVD.setText(am.getDvDate());
        viewAnimalAge.setText(am.getAge());


        return row;
    }
}
