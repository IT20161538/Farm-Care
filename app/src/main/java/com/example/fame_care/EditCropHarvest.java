package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditCropHarvest extends AppCompatActivity {

    private EditText ctype, csection, cdate, camount, ccondition;
    private Button update, clear;
    DBHelper3 DBhelper3;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_crop_harvest);

        DBhelper3 = new DBHelper3(this);
        ctype = findViewById(R.id.et_editcroptype);
        csection = findViewById(R.id.et_editcropsection);
        cdate = findViewById(R.id.et_editcropdate);
        camount = findViewById(R.id.et_editcropamount);
        ccondition = findViewById(R.id.et_editcropcondition);
        update = findViewById(R.id.btn_cropharvestupdate);
        clear = findViewById(R.id.btn_cropharvestclear);

        final String id = getIntent().getStringExtra("id");

        CropHarvestMethods meths = DBhelper3.getSelectData(Integer.parseInt(id));

        ctype.setText(meths.getcType());
        csection.setText(meths.getcSection());
        cdate.setText(meths.getcDate());
        camount.setText(meths.getcAmount());
        ccondition.setText(meths.getcCondition());

        /*update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ctype2 = ctype.getText().toString();
                String csection2 = csection.getText().toString();
                String cdate2 = cdate.getText().toString();
                String camount2 = camount.getText().toString();
                String cconditon2 = ccondition.getText().toString();

                CropHarvestMethods meths2 = new CropHarvestMethods(Integer.parseInt(id), ctype2, csection2, cdate2, camount2, cconditon2);
                int state = DBhelper3.updateCropHarvest(meths2);
                Toast.makeText(EditCropHarvest.this, "Record Updated!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, CropHarvest.class);
                startActivity(intent);
            }
        });*/

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctype.setText("");
                csection.setText("");
                cdate.setText("");
                camount.setText("");
                ccondition.setText("");
            }
        });

        update.setOnClickListener(v -> {
            if(ctype.length() == 0 || csection.length() == 0 || cdate.length() == 0 || camount.length() == 0 || ccondition.length() == 0){
                Toast.makeText(this, "Please fill the missing fields!", Toast.LENGTH_LONG).show();
            }
            else if(!ctype.getText().toString().matches("[a-z,A-Z]*")){
                ctype.setError("Enter Only Characters!");
            }
            else if(!camount.getText().toString().matches("[0-9]*")){
                camount.setError("Enter Only Characters!");
            }
            else{
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String ctype2 = ctype.getText().toString();
                        String csection2 = csection.getText().toString();
                        String cdate2 = cdate.getText().toString();
                        String camount2 = camount.getText().toString();
                        String cconditon2 = ccondition.getText().toString();

                        CropHarvestMethods meths2 = new CropHarvestMethods(Integer.parseInt(id), ctype2, csection2, cdate2, camount2, cconditon2);
                        int state = DBhelper3.updateCropHarvest(meths2);
                        Toast.makeText(EditCropHarvest.this, "Record Updated!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, CropHarvest.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    /*public void updateCrops(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ctype2 = ctype.getText().toString();
                String csection2 = csection.getText().toString();
                String cdate2 = cdate.getText().toString();
                String camount2 = camount.getText().toString();
                String cconditon2 = ccondition.getText().toString();

                CropHarvestMethods meths2 = new CropHarvestMethods(Integer.parseInt(id), ctype2, csection2, cdate2, camount2, cconditon2);
                int state = DBhelper3.updateCropHarvest(meths2);
                Toast.makeText(EditCropHarvest.this, "Record Updated!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, CropHarvest.class);
                startActivity(intent);
            }
        });
    }*/
}