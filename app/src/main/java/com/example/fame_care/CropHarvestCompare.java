package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class CropHarvestCompare extends AppCompatActivity {

    private EditText comctype, comcamount, compercentage, comexpect;
    private Button calculate;
    private ImageView imgHome;
    DBHelper3 db3;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_harvest_compare);

        comctype = findViewById(R.id.et_comparecroptype);
        comcamount = findViewById(R.id.et_comparecropamount);
        comexpect = findViewById(R.id.et_compareamount2);
        compercentage = findViewById(R.id.et_grossincome);
        calculate = (Button) findViewById(R.id.btn_percentage);
        db3 = new DBHelper3(this);
        imgHome = findViewById(R.id.iv_home);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.et_compareamount2, "[1-9]{1}[0-9]{1}[0-9]{1}$", R.string.empty_value);

        final String id = getIntent().getStringExtra("id");

        CropHarvestMethods meths = db3.getSelectData(Integer.parseInt(id));

        comctype.setText(meths.getcType());
        comcamount.setText(meths.getcAmount());

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){
                    calculatepercentage();
                    Toast.makeText(CropHarvestCompare.this, "Calculation Success!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CropHarvestCompare.this, "Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadHome();
            }
        });

    }

    public void calculatepercentage(){
        float amount = Integer.parseInt(comcamount.getText().toString());
        float expect = Integer.parseInt(comexpect.getText().toString());

        System.out.println(amount);
        System.out.println(expect);

        System.out.println((amount/expect) * 100);

        float percentage = (amount/expect)*100;

        compercentage.setText(String.valueOf(percentage));
    }

    public void loadHome(){
        Intent intent = new Intent(this, FarmCareHome.class);
        startActivity(intent);
    }
}