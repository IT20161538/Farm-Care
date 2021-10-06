package com.example.fame_care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddAnimalVacc_Detail extends AppCompatActivity {
    private Button add , view, calc;
    private EditText section, animalType,dateOfBirth, lvDate, dvDate, age  ;
    private ImageView imageView3;
    DBHelper11 DB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal_vacc_detail);

        imageView3= (ImageView) findViewById(R.id.imageView3 );

        section= findViewById(R.id.pt_animalSection);
        animalType = findViewById(R.id.pt_animalType);
        dateOfBirth = findViewById(R.id.pt_dob);
        lvDate = findViewById(R.id.pt_lvd);
        dvDate = findViewById(R.id.pt_dvd);
        age = findViewById(R.id.pt_age);

        add = findViewById(R.id.btn_Animaladd);
        view= findViewById(R.id.btn_Animalview);
        calc = findViewById(R.id.btn_calcAge);

        DB = new DBHelper11(this);

        //addAnimalManage();
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openHomePage();}
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openAnimalCropView(); }
        });

        add.setOnClickListener((v)->{
            if(section.length() == 0 || animalType.length() == 0 || dateOfBirth.length() == 0 || lvDate.length()== 0 || dvDate.length()== 0)
            {
                Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
                //section.setError("Please fill the field");
            }
           /* else if(animalType.length() == 0)
            {
                //Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
                animalType.setError("Please fill the field");
            }
            else if(dateOfBirth.length() == 0)
            {
               // Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
                dateOfBirth.setError("Please fill the field");
            }
            else if(lvDate.length()== 0)
            {
                //Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
                lvDate.setError("Please fill the field");

            }
            else if(dvDate.length()== 0)
            {
               // Toast.makeText(getApplicationContext(),"please fill the field",Toast.LENGTH_SHORT).show();
                dvDate.setError("Please fill the field");
            }*/
            else{
            addAnimalManage();
            }
        });


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculateAge();
            }
        });
    }

    public void calculateAge(){

        int date1, date2, Aage;

        date1 = Integer.parseInt(dateOfBirth.getText().toString());
        date2 = Integer.parseInt(dvDate .getText().toString());
        //Aage = Integer.parseInt(age.getText().toString());

        Aage = date2 - date1;
        age.setText(String.valueOf(Aage));

    }

    public void addAnimalManage(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean var = DB.addAnimalManage(section.getText().toString(), animalType.getText().toString(),dateOfBirth.getText().toString(),lvDate.getText().toString(),dvDate.getText().toString(),age.getText().toString());
                section.setText("");
                animalType.setText("");
                dateOfBirth.setText("");
                lvDate.setText("");
                dvDate.setText("");
                age.setText("");

                if(var){
                    Toast.makeText(AddAnimalVacc_Detail.this, "Insertion Success!", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(AddAnimalVacc_Detail.this, "Insertion Error!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void openAnimalCropView(){

        Intent intent = new Intent(this, AnimalManage_view.class);
        startActivity(intent);

    }

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }
}