package com.example.fame_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class activity_add_crop extends AppCompatActivity {

    DBHelper21 myDb;
    EditText et_cname,et_charvest,et_corder1,et_cremainder,et_ccompany,et_cpick_date,et_cunit_price,et_cincome;
    Button btn_add_crop,btn_view_all,btn_cincome ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop);
        myDb = new DBHelper21(this);

        btn_cincome = (Button) findViewById(R.id.btn_cropincome );
        btn_view_all = (Button) findViewById(R.id.btn_view_all);
        btn_add_crop = (Button) findViewById(R.id.btn_add_crop);
        et_cname = (EditText) findViewById(R.id.et_cname);
        et_charvest = (EditText) findViewById(R.id.et_charvest);
        et_corder1 = (EditText) findViewById(R.id.et_croporder);
        et_cremainder = (EditText) findViewById(R.id.et_cremainder);
        et_ccompany = (EditText) findViewById(R.id.et_ccompany);
        et_cpick_date = (EditText) findViewById(R.id.et_cpickup_date);
        et_cunit_price = (EditText) findViewById(R.id.et_crop_unitp);
        et_cincome = (EditText) findViewById(R.id.et_cropincome);
        AddData();
        viewAll();
        btn_cincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateIncome();
            }
        });
    }

    private void AddData(){
        btn_add_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = myDb.insertData(et_cname.getText().toString(), et_charvest.getText().toString(),
                        et_corder1.getText().toString(),et_cremainder.getText().toString(), et_ccompany.getText().toString(),
                        et_cpick_date .getText().toString(),et_cunit_price  .getText().toString());

                if(var){
                    Toast.makeText(activity_add_crop.this, "Insertion Success!", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(activity_add_crop.this, "Registration Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void viewAll() {
        btn_view_all.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(activity_add_crop.this,activity_crop.class);
                        //i.putExtra("data",buffer.toString());
                        startActivity(i);
                        // Show all data
                        //showMessage("Data",buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    /*public void calculateIncome(){
        int unitp1, order1, income1;

        unitp1 =Integer.parseInt(et_cunit_price .getText().toString());
        order1= Integer.parseInt( et_corder1.getText().toString());
        //Aage = Integer.parseInt(age.getText().toString());

        income1 = unitp1*order1;
        et_cincome.setText(String.valueOf(income1));

    }*/
    public void calculateIncome(){
        int unitp, order, income;

        unitp =Integer.parseInt(et_cunit_price.getText().toString());
        order= Integer.parseInt(et_corder1  .getText().toString());
        //Aage = Integer.parseInt(age.getText().toString());

        income = unitp*order;
        et_cincome.setText(String.valueOf(income));

    }
}