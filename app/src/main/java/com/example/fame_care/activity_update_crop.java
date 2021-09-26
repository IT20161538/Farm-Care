package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_update_crop extends AppCompatActivity{
    DBHelper21 myDb;
    String ProductId;
    EditText UpdateName,UpdateHarvest,UpdateOrder,UpdateRemainder,UpdateCompanyName,UpdatePdate,UpdateUnitprice;
    Button updateCrop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_crop);

        Intent intent = getIntent();

        ProductId = intent.getStringExtra("ProductId");
        System.out.println(ProductId);
        myDb = new DBHelper21(this);

        UpdateName = (EditText) findViewById(R.id.et_cname_update);
        UpdateHarvest = (EditText) findViewById(R.id.et_charvest_update);
        UpdateOrder = (EditText) findViewById(R.id.et_croporder_update);
        UpdateRemainder = (EditText) findViewById(R.id.et_cremainder_update);
        UpdatePdate = (EditText) findViewById(R.id.et_cpickup_date_update);
        UpdateUnitprice = (EditText) findViewById(R.id.et_crop_unitp_update);

        updateCrop = (Button) findViewById(R.id.btn_update_crop);

        UpdateName.setText(intent.getStringExtra("Name"));
        UpdateHarvest.setText(intent.getStringExtra("Harvest"));
        UpdateOrder.setText(intent.getStringExtra("Order"));
        UpdateRemainder.setText(intent.getStringExtra("Remainder"));
        UpdatePdate.setText(intent.getStringExtra("PickupDate"));
        UpdateUnitprice.setText(intent.getStringExtra("UnitPrice"));

        updateCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.updateData(ProductId,UpdateName.getText().toString(),UpdateHarvest.getText().toString(),UpdateOrder.getText().toString(),UpdateRemainder.getText().toString(),UpdatePdate.getText().toString(),UpdateUnitprice.getText().toString());

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Crop edited successfully",
                        Toast.LENGTH_SHORT);
                toast.show();

                Intent i = new Intent(getApplicationContext(),activity_crop.class);
                startActivity(i);
            }
        });
    }
}