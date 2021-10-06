package com.example.fame_care;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Crops_view extends AppCompatActivity {

    private Button createNewCrop;
    private ListView list;
    private List<CropManageModel> cropManages;
    private ImageView imageView3;
    Context context;
    DBHelper10 DB ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crops_view);

        imageView3= (ImageView) findViewById(R.id.imageView3 );

        createNewCrop = findViewById(R.id.btn_newaddcrop);
        list = findViewById(R.id.lv_cropmanage);
       // cropview =new ArrayList<>();
        cropManages = new ArrayList<>();
        context = this;
        DB = new DBHelper10(context);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openHomePage();}
        });

        cropManages =DB.getAllCropManageDetails();
        //cropview = DB.getAllCropManageDetails();

        CropManageAdapter adapter = new CropManageAdapter(context, R.layout.single_cropmanage_view,cropManages);
        list.setAdapter(adapter);


        createNewCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openAddCropManagePage();}

        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                final CropManageModel model = cropManages.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(model.getCroptype());
                builder.setMessage(model.getSection());
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DB.deleteCropManage(model.getId());
                        startActivity(new Intent(context,Crops_view.class));
                    }
                });

                builder.setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       // startActivity(new Intent(context,EditCropManage.class));
                        Intent intent = new Intent(context,EditCropManage.class);

                        intent.putExtra("id",String.valueOf(model.getId()));
                        startActivity(intent);

                    }
                });
                builder.show();
            }
        });

    }

    public void openAddCropManagePage(){
        Intent intent =new Intent(this, AddCropManage.class);
        startActivity(intent);
    }

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }
}