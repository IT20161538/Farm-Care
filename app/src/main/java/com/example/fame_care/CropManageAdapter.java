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

public class CropManageAdapter extends ArrayAdapter<CropManageModel> {

    private Context context;
    private int resource;
    List<CropManageModel> cropManages;

     CropManageAdapter(Context context, int resource, List<CropManageModel> cropManages){
        super(context,resource,cropManages);
        this.context = context;
        this.resource = resource;
        this.cropManages = cropManages;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView viewcropSection = row.findViewById(R.id.tv_singleCrop_section);
        TextView viewcropType = row.findViewById(R.id.tv_singleCrop_type);
        TextView viewcroplpdate = row.findViewById(R.id.tv_singleCrop_lpd);
        TextView viewcropdpdate = row.findViewById(R.id.tv_singleCrop_dpd);

        CropManageModel cm =cropManages.get(position);
        viewcropSection.setText(cm.getSection());
        viewcropType.setText(cm.getCroptype());
        viewcroplpdate.setText(cm.getLpdate());
        viewcropdpdate.setText(cm.getDpdate());

        return row;
    }
}
