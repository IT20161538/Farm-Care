package com.example.fame_care;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditCropManage extends AppCompatActivity {

    private EditText editSection, editCropType, editLPDate, editDPDate;
    private Button edit;
    private DBHelper10 DB;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_crop_manage);

        context = this;
        DB = new DBHelper10(context);

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

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String section = editSection.getText().toString();
                String cropType = editCropType.getText().toString();
                String lpDate = editLPDate.getText().toString();
                String dpDate = editDPDate.getText().toString();

                CropManageModel crop = new CropManageModel(Integer.parseInt(id),section,cropType,lpDate,dpDate);

                int state = DB.updateSingleRow(crop);

                startActivity(new Intent(context,Crops_view.class));
            }
        });



    }
}