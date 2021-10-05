package com.example.fame_care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class  activity_add_animal1 extends AppCompatActivity {

    DBHelper20 myDb;
    EditText et_aname,et_eharvest,et_aorder,et_aremainder,et_acompany,et_apick_date,et_aunit_price,et_animal_income;
    Button btn_add_animal,btn_view_all2,btn_aincome,btn_clear_animal;
    ImageView imageView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal1);
        myDb = new DBHelper20(this);

        imageView12= (ImageView) findViewById(R.id.imageView12 );
        btn_clear_animal = (Button) findViewById(R.id.btn_clear_animal);
        btn_aincome = (Button) findViewById(R.id.btn_aincome );
        btn_view_all2 = (Button) findViewById(R.id.btn_view_all2);
        btn_add_animal = (Button) findViewById(R.id.btn_add_animal);
        et_aname = (EditText) findViewById(R.id.et_aname);
        et_eharvest = (EditText) findViewById(R.id.et_eharvest);
        et_aorder = (EditText) findViewById(R.id.et_aorder);
        et_aremainder = (EditText) findViewById(R.id.et_aremainder);
        et_acompany = (EditText) findViewById(R.id.et_acompany);
        et_apick_date = (EditText) findViewById(R.id.et_apick_date);
        et_aunit_price = (EditText) findViewById(R.id.et_aunit_price);
        et_animal_income=(EditText) findViewById(R.id.et_animal_income);
        AddData();
        viewAll();

        btn_add_animal .setOnClickListener(v -> {
            if( et_aname.length() == 0 || et_eharvest.length() == 0 ||et_aorder  .length() == 0 || et_aremainder.length() == 0 || et_acompany.length() == 0||et_apick_date .length() == 0||et_aunit_price .length() == 0||et_animal_income.length() == 0){
                Toast.makeText(this, "Please fill the missing fields!", Toast.LENGTH_LONG).show();
            }
            else if(!et_aname.getText().toString().matches("[a-z,' ',A-Z]*")){
                et_aname.setError("Enter Only Characters!");
            }

            else{
                AddData();
            }
        });
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity_add_animal1.this,FarmCareHome.class);
                startActivity(i);
            }
        });
        btn_aincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateIncome();
            }
        });
        btn_clear_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_aname.setText("");
                et_eharvest.setText("");
                et_aorder.setText("");
                et_aremainder.setText("");
                et_acompany .setText("");
                et_apick_date .setText("");
                et_aunit_price  .setText("");
                et_animal_income .setText("");
            }
        });

    }



    private void AddData(){
        btn_add_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = myDb.insertData(et_aname.getText().toString(), et_eharvest.getText().toString(), et_aorder.getText().toString(), et_aremainder.getText().toString(), et_acompany.getText().toString(), et_apick_date .getText().toString(),et_aunit_price  .getText().toString());
                if(var){
                    Toast.makeText(activity_add_animal1.this, "Insertion Success!", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(activity_add_animal1.this, "Registration Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
   public void calculateIncome(){
        int unitp, order, income;

        unitp =Integer.parseInt(et_aunit_price .getText().toString());
        order= Integer.parseInt(et_aorder .getText().toString());
        //Aage = Integer.parseInt(age.getText().toString());

        income = unitp*order;
        et_animal_income.setText(String.valueOf(income));

    }
    /*public void viewAll() {
        btn_view_all2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData2();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ProductId :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Harvest :"+ res.getString(2)+"\n");
                            buffer.append("Orderr :"+ res.getString(3)+"\n");
                            buffer.append("Remainder :"+ res.getString(4)+"\n");
                            buffer.append("CompanyName :"+ res.getString(5)+"\n");
                            buffer.append("PickupDate:"+ res.getString(6)+"\n");
                            buffer.append("UnitPrice:"+ res.getString(7)+"\n\n");



                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
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
    }*/

//    public void viewAll() {
//        btn_view_all2.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Intent i = new Intent(activity_add_animal1.this,activity_animal1.class);
//                        //i.putExtra("data",buffer.toString());
//                        startActivity(i);
//                        // Show all data
//                        //showMessage("Data",buffer.toString());
//                    }
//                }
//        );
//    }

    public void viewAll() {
        btn_view_all2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(activity_add_animal1.this,activity_animal1.class);
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


    }



