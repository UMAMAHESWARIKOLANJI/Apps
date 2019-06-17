package com.example.umamaheshwari.apps;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alert extends AppCompatActivity {
    Button btn;
    EditText etph,ettxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        if(ContextCompat.checkSelfPermission(alert.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(alert.this,
                    Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(alert.this,
                        new String[]{Manifest.permission.SEND_SMS}, 1);
            } else {
                ActivityCompat.requestPermissions(alert.this,
                        new String[] {Manifest.permission.SEND_SMS}, 1);
            }
            } else {
        }
        btn = (Button)findViewById(R.id.btn);
        etph = (EditText)findViewById(R.id.etph);
        ettxt = (EditText)findViewById(R.id.ettxt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=etph.getText().toString();
                String text=ettxt.getText().toString();
                try {
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(phone, null, text, null, null);
                    Toast.makeText(alert.this, "RECEIVED", Toast.LENGTH_SHORT).show();
                }catch (Exception e)
                {
                    Toast.makeText(alert.this, "NOT RECEIVED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch (requestCode){
            case 1:{
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(alert.this,
                            Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "No Permission Granted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
