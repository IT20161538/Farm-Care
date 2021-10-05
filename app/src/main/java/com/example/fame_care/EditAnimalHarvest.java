package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditAnimalHarvest extends AppCompatActivity {

    private EditText anitype, protype, section, date, amount;
    private Button update, clear;
    DBHelper2 dbHelper2;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_animal_harvest);

        dbHelper2 = new DBHelper2(this);
        anitype = findViewById(R.id.et_editanimalhardata);
        protype = findViewById(R.id.et_editanimalproducttype);
        section = findViewById(R.id.et_editanimalsectiondata);
        date = findViewById(R.id.et_editanimaldatedata);
        amount = findViewById(R.id.et_editanimalamountdata);
        update = findViewById(R.id.btn_animalharvestupdate);
        clear = findViewById(R.id.btn_animalharvestclear);

        final String id = getIntent().getStringExtra("id");

        AnimalHarvestMethods meths = dbHelper2.getSelectData(Integer.parseInt(id));

        anitype.setText(meths.getaType());
        protype.setText(meths.getpType());
        section.setText(meths.getaSection());
        date.setText(meths.getaDate());
        amount.setText(meths.getaAmount());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String anitype2 = anitype.getText().toString();
                String protype2 = protype.getText().toString();
                String section2 = section.getText().toString();
                String date2 = date.getText().toString();
                String amount2 = amount.getText().toString();

                AnimalHarvestMethods meths2 = new AnimalHarvestMethods(Integer.parseInt(id), anitype2, protype2, section2, date2, amount2);
                int state = dbHelper2.updateAnimalHarvest(meths2);
                Toast.makeText(EditAnimalHarvest.this, "Record Updated!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, AnimalHarvest.class);
                startActivity(intent);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anitype.setText("");
                protype.setText("");
                section.setText("");
                date.setText("");
                amount.setText("");
            }
        });

        update.setOnClickListener(v -> {
            if(anitype.length() == 0 || protype.length() == 0 || section.length() == 0 || date.length() == 0 || amount.length() == 0){
                Toast.makeText(this, "Please fill the missing fields!", Toast.LENGTH_LONG).show();
            }
            else if(!anitype.getText().toString().matches("[a-z,A-Z]*")){
                anitype.setError("Enter Only Characters!");
            }
            else if(!amount.getText().toString().matches("[0-9]*")){
                amount.setError("Enter Only Numbers!");
            }
            else{
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String anitype2 = anitype.getText().toString();
                        String protype2 = protype.getText().toString();
                        String section2 = section.getText().toString();
                        String date2 = date.getText().toString();
                        String amount2 = amount.getText().toString();

                        AnimalHarvestMethods meths2 = new AnimalHarvestMethods(Integer.parseInt(id), anitype2, protype2, section2, date2, amount2);
                        int state = dbHelper2.updateAnimalHarvest(meths2);
                        Toast.makeText(EditAnimalHarvest.this, "Record Updated!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, AnimalHarvest.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}