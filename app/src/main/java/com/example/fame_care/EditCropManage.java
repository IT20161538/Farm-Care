package com.example.fame_care;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class EditCropManage extends AppCompatActivity {

    private EditText editSection, editCropType, editLPDate, editDPDate;
    private Button edit;
    private DBHelper10 DB;
    private Context context;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_crop_manage);

        context = this;
        DB = new DBHelper10(context);

        imageView3 = (ImageView) findViewById(R.id.imageView3);

        editSection = findViewById(R.id.pt_editSectionCrop);
        editCropType = findViewById(R.id.pt_editCroptype);
        editLPDate = findViewById(R.id.pt_editcroplpd);
        editDPDate = findViewById(R.id.pt_editcropdpd);
        edit = findViewById(R.id.btn_editCropM);

        final String id = getIntent().getStringExtra("id");
        //CropManageModel cropmodel = DB.getSingleRow(Integer.parseInt(id));
        CropManageModel cropManages = DB.getSingleRow(Integer.parseInt(id));

        editSection.setText(cropManages.getSection());
        editCropType.setText(cropManages.getCroptype());
        editLPDate.setText(cropManages.getLpdate());
        editDPDate.setText(cropManages.getDpdate());

        edit.setOnClickListener((v) -> {
            if (editSection.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            } else if (editCropType.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            } else if (editLPDate.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            } else if (editDPDate.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            } else {

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String section = editSection.getText().toString();
                        String cropType = editCropType.getText().toString();
                        String lpDate = editLPDate.getText().toString();
                        String dpDate = editDPDate.getText().toString();

                        CropManageModel crop = new CropManageModel(Integer.parseInt(id), section, cropType, lpDate, dpDate);

                        int state = DB.updateSingleRow(crop);
                        Toast.makeText(EditCropManage.this, "Record Updated!", Toast.LENGTH_LONG).show();

                        startActivity(new Intent(context, Crops_view.class));
                    }
                });
            }

        });

       imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditCropManage.this,FarmCareHome.class);
                startActivity(i);
            }
        });

        editLPDate .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(EditCropManage.this,
                        new DatePickerDialog.OnDateSetListener() {




                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                Toast.makeText(EditCropManage.this,dayOfMonth + "-" + (monthOfYear + 1) + "-" + year,Toast.LENGTH_LONG).show();
                                editLPDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        editDPDate .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(EditCropManage.this,
                        new DatePickerDialog.OnDateSetListener() {




                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                Toast.makeText(EditCropManage.this,dayOfMonth + "-" + (monthOfYear + 1) + "-" + year,Toast.LENGTH_LONG).show();
                                editDPDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


    }
}