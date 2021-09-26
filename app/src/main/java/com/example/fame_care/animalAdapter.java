package com.example.fame_care;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class animalAdapter extends RecyclerView.Adapter<animalAdapter.ViewHolder>{
    Context context;
    List<Animals> AnimalsList;
    RecyclerView rvPrograms1;
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowName1;
        TextView rowHarvest1;
        TextView rowOrder1;
        TextView Remainder1;
        TextView price1;
        TextView pickupDate1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowName1 = itemView.findViewById(R.id.list_name1);
            rowHarvest1 = itemView.findViewById(R.id.list_harvest1);
            rowOrder1= itemView.findViewById(R.id.list_order1);
            Remainder1= itemView.findViewById(R.id.list_remainder1);
            price1= itemView.findViewById(R.id.list_price1);
            pickupDate1= itemView.findViewById(R.id.list_date1);

        }

    }
    public animalAdapter(Context context, List<Animals> contactsList, RecyclerView rvPrograms) {
        this.context = context;
        this.AnimalsList = contactsList;
        this.rvPrograms1 = rvPrograms;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item1, parent, false);
        //view.setOnClickListener(onClickListener);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animals animals = AnimalsList.get(position);

        holder.rowName1.setText(animals.getName1());
        holder.rowHarvest1.setText(animals.getHarvest1());
        holder.rowOrder1.setText(animals.getOrder1());
        holder.Remainder1.setText(animals.getRemainder1());
        holder.price1.setText(animals.getUnitPrice1());
        holder.pickupDate1.setText(animals.getPickupDate1());

    }

    @Override
    public int getItemCount() {
        return AnimalsList.size();
    }
}
