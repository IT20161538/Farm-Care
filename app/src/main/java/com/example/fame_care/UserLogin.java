package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {

    EditText username, password;
    Button login, back;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        username = (EditText) findViewById(R.id.et_userloginname);
        password = (EditText) findViewById(R.id.etp_userloginpassword);
        login = (Button) findViewById(R.id.btn_userlogin);
        back = (Button) findViewById(R.id.signuplabel);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String un = username.getText().toString();
                String pw = password.getText().toString();

                if(un.equals("")||pw.equals("")){
                    Toast.makeText(UserLogin.this, "Please fill the missing fields", Toast.LENGTH_LONG).show();
                }
                else{
                    Boolean checkunpw = DB.checkusernamepassword(un, pw);
                    if(checkunpw == true){
                        Toast.makeText(UserLogin.this, "Log in Successfull", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), FarmCareHome.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(UserLogin.this, "Invalid Username or Password!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSignupPage();
            }
        });
    }

    public void loadSignupPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}