package com.example.fame_care;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SendMessage extends AppCompatActivity {

    private Button btn_send;
    private EditText contactno,message;
    private DBHelper9 DB;
    private Context context;
    ImageView imageView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        context = this;
        DB = new DBHelper9(context);

        imageView3= (ImageView) findViewById(R.id.imageView3);
        contactno = findViewById(R.id.et_sendcontactnodata);
        message = findViewById(R.id.et_sendmessagedata);
        btn_send = (Button) findViewById(R.id.btn_send);

        final String id = getIntent().getStringExtra("id");
        EmployeeModelClass employeeModelClass = DB.getSingleMessageEmloyeeModelClass(Integer.parseInt(id));

        contactno.setText(employeeModelClass.getContactno());

        ActivityCompat.requestPermissions(SendMessage.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });

    }

    public void sendSMS(View view){
        String messageText = message.getText().toString();
        String contact = contactno.getText().toString();

        if(!contact.equals("") && !contact.equals("")) {
            SmsManager mySmsManager = SmsManager.getDefault();
            mySmsManager.sendTextMessage(contact, null, messageText, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent Successfully", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(getApplicationContext(), "SMS Sent Error", Toast.LENGTH_LONG).show();

        }
    }

    public void openHomePage(){
        Intent intent = new Intent(this,FarmCareHome.class);
        startActivity(intent);
    }
}