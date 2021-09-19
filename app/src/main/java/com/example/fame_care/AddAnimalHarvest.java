package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddAnimalHarvest extends AppCompatActivity {

    private EditText anitype, protype, section, date, amount;
    private Button submit;

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

    }
}