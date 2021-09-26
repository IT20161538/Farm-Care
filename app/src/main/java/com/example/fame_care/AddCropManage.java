package com.example.fame_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCropManage extends AppCompatActivity {

    private Button add , view;
    private EditText section, croptype, lpdate, dpdate  ;
    DBHelper10 DB ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop_manage);

        add = (Button) findViewById(R.id.btn_cropAdd);
        view = (Button) findViewById(R.id.btn_cropView);
        section = findViewById(R.id.pt_section);
        croptype = findViewById(R.id.pt_croptype);
        lpdate = findViewById(R.id.pt_lpd);
        dpdate = findViewById(R.id.pt_dpd);
        DB = new DBHelper10(this);


        addCropManage();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openCropManageViewPage();}
        });

    }

    public void addCropManage(){
        add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean var = DB.addcrop(section.getText().toString(), croptype.getText().toString(),lpdate.getText().toString(),dpdate.getText().toString());

                section.setText("");
                croptype.setText("");
                lpdate.setText("");
                dpdate.setText("");

                if(var){
                    Toast.makeText(AddCropManage.this, "Insertion Success!", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(AddCropManage.this, "Insertion Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void openCropManageViewPage(){
        Intent intent = new Intent(this, Crops_view.class);
        startActivity(intent);
    }

}