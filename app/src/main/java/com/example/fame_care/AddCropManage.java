package com.example.fame_care;

import android.app.DatePickerDialog;
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

public class AddCropManage extends AppCompatActivity {

    private Button add , view;
    private EditText section, croptype, lpdate, dpdate  ;
    private ImageView imageView3;
    DBHelper10 DB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop_manage);

        imageView3= (ImageView) findViewById(R.id.imageView3 );
        add = (Button) findViewById(R.id.btn_cropAdd);
        view = (Button) findViewById(R.id.btn_cropView);
        section = findViewById(R.id.pt_section);
        croptype = findViewById(R.id.pt_croptype);
        lpdate = findViewById(R.id.pt_lpd);
        dpdate = findViewById(R.id.pt_dpd);
        DB = new DBHelper10(this);


       // addCropManage();

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openHomePage();}
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openCropManageViewPage();}
        });

        add.setOnClickListener((v)->{
            if(section.length() == 0 || croptype.length() == 0 || lpdate.length() == 0 || dpdate.length()== 0 )
            {
               Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
               // section.setError("Please fill the field");
            }
           /* else if(croptype.length() == 0)
            {
                //Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
                croptype.setError("Please fill the field");
            }

            else if(lpdate.length() == 0)
            {
               // Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
                lpdate.setError("Please fill the field");
            }
            else if(dpdate.length()== 0)
            {
                //Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
                dpdate.setError("Please fill the field");
            }*/
            else{
            addCropManage();
            }
        });

        lpdate .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddCropManage.this,
                        new DatePickerDialog.OnDateSetListener() {




                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                Toast.makeText(AddCropManage.this,dayOfMonth + "-" + (monthOfYear + 1) + "-" + year,Toast.LENGTH_LONG).show();
                                lpdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        dpdate .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddCropManage.this,
                        new DatePickerDialog.OnDateSetListener() {




                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                Toast.makeText(AddCropManage.this,dayOfMonth + "-" + (monthOfYear + 1) + "-" + year,Toast.LENGTH_LONG).show();
                                dpdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
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

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }

}