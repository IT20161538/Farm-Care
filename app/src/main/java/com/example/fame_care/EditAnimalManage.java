package com.example.fame_care;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditAnimalManage extends AppCompatActivity {

    private EditText editSection, editType, editDOB, editLVD, editDVD, editAge;
    private Button edit;
    private DBHelper11 DB;
    private Context context;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_animal_manage);

        context = this;
        DB= new DBHelper11(context);

        imageView3= (ImageView) findViewById(R.id.imageView3 );

        editSection =findViewById(R.id.pt_editAnimal_section);
        editType = findViewById(R.id.pt_editAnimal_type);
        editDOB = findViewById(R.id.pt_editAnimal_dob);
        editLVD = findViewById(R.id.pt_editAnimal_lvd);
        editDVD = findViewById(R.id.pt_editAnimal_dvd);
        editAge =findViewById(R.id.pt_editAnimal_age);
        edit = findViewById(R.id.btn_editAnimalM);

        final String id = getIntent().getStringExtra("id");
        AnimalManageModel animalsModel = DB.getSingleRow(Integer.parseInt(id));

        editSection.setText(animalsModel.getSection());
        editType.setText(animalsModel.getAnimalType());
        editDOB .setText(animalsModel.getDateOfBirth());
        editLVD.setText(animalsModel.getLvDate());
        editDVD.setText(animalsModel.getDvDate());
        editAge.setText(animalsModel.getAge());

        edit.setOnClickListener((v) -> {
            if (editSection.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            } else if (editType.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            } else if (editDOB.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            } else if (editLVD.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            }
            else if (editDVD.length() == 0) {
                Toast.makeText(getApplicationContext(), "please fill the field", Toast.LENGTH_SHORT).show();
            }else {

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String section = editSection.getText().toString();
                        String animalType = editType.getText().toString();
                        String DOB = editDOB.getText().toString();
                        String lvDate = editLVD.getText().toString();
                        String dvDate = editDVD.getText().toString();
                        String Age = editAge.getText().toString();

                        AnimalManageModel animal = new AnimalManageModel(Integer.parseInt(id), section, animalType, DOB, lvDate, dvDate, Age);

                        int state = DB.updateSingleRow(animal);
                        Toast.makeText(EditAnimalManage.this, "Record Updated!", Toast.LENGTH_LONG).show();

                        startActivity(new Intent(context, AnimalManage_view.class));

                    }
                });
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditAnimalManage.this,FarmCareHome.class);
                startActivity(i);
            }
        });

    }
}