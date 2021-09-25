package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class AddCropHarvest extends AppCompatActivity {

    private EditText croptype, csection, cdate, camount, cconditon;
    private Button submit, clear;
    DBHelper3 DB3;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop_harvest);

        croptype = findViewById(R.id.et_addcroptype);
        csection = findViewById(R.id.et_addcropsection);
        cdate = findViewById(R.id.et_addcropdate);
        camount = findViewById(R.id.et_addcropamount);
        cconditon = findViewById(R.id.et_addcropcondition);
        submit = findViewById(R.id.btn_cropharvestadd);
        clear = findViewById(R.id.btn_cropharvestclear);
        DB3 = new DBHelper3(this);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.et_addcropamount, "[1-9]{1}[0-9]{1}[0-9]{1}$", R.string.empty_value);

        addcropHarvest();

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                croptype.setText("");
                csection.setText("");
                cdate.setText("");
                camount.setText("");
                cconditon.setText("");
            }
        });
    }

    private void addcropHarvest(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var3 = DB3.addcropharvest(croptype.getText().toString(), csection.getText().toString(), cdate.getText().toString(), camount.getText().toString(), cconditon.getText().toString());
                if(var3){
                    Toast.makeText(AddCropHarvest.this, "Record Inserted!", Toast.LENGTH_LONG).show();
                    openCropHarvestPage();
                }
                else{
                    Toast.makeText(AddCropHarvest.this, "Error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void openCropHarvestPage(){
        Intent intent = new Intent(this, CropHarvest.class);
        startActivity(intent);
    }
}