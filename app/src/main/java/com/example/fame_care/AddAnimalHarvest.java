package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAnimalHarvest extends AppCompatActivity {

    private EditText anitype, protype, section, date, amount;
    private Button submit, clear;
    DBHelper2 DB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal_harvest);

        anitype = findViewById(R.id.et_addanimalhardata);
        protype = findViewById(R.id.et_addanimalproducttype);
        section = findViewById(R.id.et_addanimalsectiondata);
        date = findViewById(R.id.et_addanimaldatedata);
        amount = findViewById(R.id.et_addanimalamountdata);
        submit = findViewById(R.id.btn_animalharvestsubmit);
        clear = findViewById(R.id.btn_animalharvestclear);
        DB2 = new DBHelper2(this);

        addAniHarvest();

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

        submit.setOnClickListener(v -> {
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
                addAniHarvest();
            }
        });

    }

    private void addAniHarvest(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = DB2.addanimalharvest(anitype.getText().toString(), protype.getText().toString(), section.getText().toString(), date.getText().toString(), amount.getText().toString());
                if(var){
                    Toast.makeText(AddAnimalHarvest.this, "Record Inserted!", Toast.LENGTH_LONG).show();
                    openAnimalHarvestPage();
                }
                else{
                    Toast.makeText(AddAnimalHarvest.this, "Error!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void openAnimalHarvestPage(){
        Intent intent = new Intent(this, AnimalHarvest.class);
        startActivity(intent);
    }

}