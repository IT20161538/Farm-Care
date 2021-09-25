package com.example.fame_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AnimalHarvest extends AppCompatActivity {

    private Button addnew;
    private ListView aniharvestlist;
    Context context;
    private List<AnimalHarvestMethods> aharvestlist;
    DBHelper2 dbHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_harvest);

        addnew = findViewById(R.id.btn_animaladdnew);
        aniharvestlist = findViewById(R.id.animalharvest_list);
        context = this;
        aharvestlist = new ArrayList<>();
        dbHelper2 = new DBHelper2(this);

        aharvestlist = dbHelper2.getAnimalHarvest();

        AnimalHarvestAdapter aniadapter = new AnimalHarvestAdapter(context, R.layout.animal_harvest_view, aharvestlist);
        aniharvestlist.setAdapter(aniadapter);

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAnimalHarvest();
                Toast.makeText(AnimalHarvest.this, "Please Wait!", Toast.LENGTH_LONG).show();
            }
        });

        aniharvestlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AnimalHarvestMethods methods = aharvestlist.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Animal Harvest");
                builder.setMessage("Select Actions");
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AnimalHarvest.this, "Please Wait!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, EditAnimalHarvest.class);
                        intent.putExtra("id", String.valueOf(methods.getId()));
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHelper2.deleteAnimalHarvest(methods.getId());
                        Toast.makeText(AnimalHarvest.this, "Record Deleted!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(context, AnimalHarvest.class));
                    }
                });
                builder.show();
            }
        });
    }
    public void addAnimalHarvest(){
        Intent intent = new Intent(this, AddAnimalHarvest.class);
        startActivity(intent);
    }

}