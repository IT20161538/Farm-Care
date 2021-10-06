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

public class AnimalManage_view extends AppCompatActivity {

    private Button createNewAnimal;
    private ListView list;
    private List<AnimalManageModel> animalManageView;
    private ImageView imageView3;
    Context context;
    DBHelper11 DB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_manage_view);

        imageView3= (ImageView) findViewById(R.id.imageView3 );

        createNewAnimal = findViewById(R.id.btn_newaddAnimal);
        list = findViewById(R.id.lv_animalManage);
        animalManageView = new ArrayList<>();
        context = this;
        DB = new DBHelper11(context);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openHomePage();}
        });

        animalManageView = DB.getAllAnimalManageDetails();

        AnimalManageAdapter adapter = new AnimalManageAdapter(context, R.layout.single_animalmanage_view,animalManageView);
        list.setAdapter(adapter);

        createNewAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openAddAnimalManagePage();}
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                final AnimalManageModel model = animalManageView.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(model.getAnimalType());
                builder.setMessage(model.getSection());
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DB.deleteAnimalManage(model.getId());
                        startActivity(new Intent(context,AnimalManage_view.class));
                    }
                });

                builder.setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(context,EditAnimalManage.class);

                        intent.putExtra("id",String.valueOf(model.getId()));
                        startActivity(intent);

                    }
                });

                builder.show();
            }
        });
    }

    public void openAddAnimalManagePage(){
        Intent intent =new Intent(this,AddAnimalVacc_Detail.class);
        startActivity(intent);
    }

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }

}