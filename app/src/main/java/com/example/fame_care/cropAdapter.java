package com.example.fame_care;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cropAdapter extends RecyclerView.Adapter<cropAdapter.ViewHolder>{
    Context context;
    List<Crops> cropsList;
    RecyclerView rvPrograms;
    DBHelper21 myDb;
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowName;
        TextView rowHarvest;
        TextView rowOrder;
        TextView Remainder;
        TextView price;
        TextView pickupDate;
        ImageView delete;
        ImageView edit;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowName = itemView.findViewById(R.id.list_name);
            rowHarvest = itemView.findViewById(R.id.list_harvest);
            rowOrder= itemView.findViewById(R.id.list_order);
            Remainder= itemView.findViewById(R.id.list_remainder);
            price= itemView.findViewById(R.id.list_price);
            pickupDate= itemView.findViewById(R.id.list_date);
            edit= itemView.findViewById(R.id.edlList);
            delete= itemView.findViewById(R.id.delList);


        }

    }
    public cropAdapter(Context context, List<Crops> contactsList, RecyclerView rvPrograms, DBHelper21 mydb) {
        this.context = context;
        this.cropsList = contactsList;
        this.rvPrograms = rvPrograms;
        myDb = mydb;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, parent, false);
        //view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Crops crops = cropsList.get(position);

        holder.rowName.setText(crops.getName());
        holder.rowHarvest.setText(crops.getHarvest());
        holder.rowOrder.setText(crops.getOrder());
        holder.Remainder.setText(crops.getRemainder());
        holder.price.setText(crops.getUnitPrice());
        holder.pickupDate.setText(crops.getPickupDate());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ProductID = crops.getProductId();
                System.out.println(myDb.toString()+"/"+ ProductID);
                myDb.deleteData(ProductID);

                Intent i = new Intent(context,activity_add_crop.class);
                context.startActivity(i);

            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,activity_update_crop.class);
                i.putExtra("ProductId",crops.getProductId());
                i.putExtra("Name",crops.getName());
                i.putExtra("Harvest",crops.getHarvest());
                i.putExtra("Order",crops.getOrder());
                i.putExtra("Remainder",crops.getRemainder());
                i.putExtra("CompanyName",crops.getCompanyName());
                i.putExtra("PickupDate",crops.getPickupDate());
                i.putExtra("UnitPrice",crops.getUnitPrice());
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return cropsList.size();
    }
}
