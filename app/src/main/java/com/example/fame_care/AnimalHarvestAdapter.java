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
import java.util.zip.Inflater;

public class AnimalHarvestAdapter extends ArrayAdapter<AnimalHarvestMethods> {

    private Context context;
    private int resource;
    List<AnimalHarvestMethods> aHarvestlist;

    AnimalHarvestAdapter(Context context, int resource, List<AnimalHarvestMethods> aHarvestlist){
        super(context, resource, aHarvestlist);
        this.context = context;
        this.resource = resource;
        this.aHarvestlist = aHarvestlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);

        TextView aniType = row.findViewById(R.id.tv_animaltypedata);
        TextView proType = row.findViewById(R.id.tv_producttypedata);
        TextView aSection = row.findViewById(R.id.tv_sectiondata);
        TextView aDate = row.findViewById(R.id.tv_datedata);
        TextView aAmount = row.findViewById(R.id.tv_amountdata);

        AnimalHarvestMethods aharvestlist = aHarvestlist.get(position);
        aniType.setText(aharvestlist.getaType());
        proType.setText(aharvestlist.getpType());
        aSection.setText(aharvestlist.getaSection());
        aDate.setText(aharvestlist.getaDate());
        aAmount.setText(aharvestlist.getaAmount());

        return row;
    }
}
