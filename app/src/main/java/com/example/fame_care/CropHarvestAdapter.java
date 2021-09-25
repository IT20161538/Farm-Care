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

public class CropHarvestAdapter extends ArrayAdapter<CropHarvestMethods> {

    private Context context;
    private int resource;
    List<CropHarvestMethods> cHarvestlist;

    public CropHarvestAdapter(@NonNull Context context, int resource, @NonNull List<CropHarvestMethods> cHarvestlist) {
        super(context, resource, cHarvestlist);
        this.context = context;
        this.resource = resource;
        this.cHarvestlist = cHarvestlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View crow = inflater.inflate(resource, parent, false);

        TextView cropType = crow.findViewById(R.id.tv_croptypedata);
        TextView cSection = crow.findViewById(R.id.tv_cropsectiondata);
        TextView cDate = crow.findViewById(R.id.tv_cropdatedata);
        TextView cAmount = crow.findViewById(R.id.tv_cropamountdata);
        TextView cConditon = crow.findViewById(R.id.tv_cropconditiondata);

        CropHarvestMethods cropharvestmethods = cHarvestlist.get(position);
        cropType.setText(cropharvestmethods.getcType());
        cSection.setText(cropharvestmethods.getcSection());
        cDate.setText(cropharvestmethods.getcDate());
        cAmount.setText(cropharvestmethods.getcAmount());
        cConditon.setText(cropharvestmethods.getcCondition());

        return crow;
    }
}
