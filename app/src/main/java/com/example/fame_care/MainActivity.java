package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login, signin;
    private EditText name, email, phone, location, un, pw;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.btnloginlable);
        signin = (Button) findViewById(R.id.btn_signin);
        name = findViewById(R.id.et_signinname);
        email = findViewById(R.id.et_signinemail);
        phone = findViewById(R.id.et_signinphone);
        location = findViewById(R.id.et_signinlocation);
        un = findViewById(R.id.et_signinusername);
        pw = findViewById(R.id.editTextTextPassword2);

        DB = new DBHelper(this);

        registerUser();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });

    }

    private void registerUser(){
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = DB.register(name.getText().toString(), email.getText().toString(), phone.getText().toString(), location.getText().toString(), un.getText().toString(), pw.getText().toString());

                if(var){
                    Toast.makeText(MainActivity.this, "Registration Success!", Toast.LENGTH_LONG).show();
                    openLoginPage();
                }
                else{
                    Toast.makeText(MainActivity.this, "Registration Error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void openLoginPage(){
        Intent intent = new Intent(this, UserLogin.class);
        startActivity(intent);
    }
}