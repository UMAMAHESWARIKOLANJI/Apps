package com.example.umamaheshwari.apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etpassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etpassword = (EditText)findViewById(R.id.etpassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valid(etUsername.getText().toString(), etpassword.getText().toString());
            }
        });
    }
    public void valid(String Username, String Password){
        if (Username.equals("user") && Password.equals("1234")){
            Intent in = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(in);
        }else{
        Toast.makeText(MainActivity.this,"Input Invalid", Toast.LENGTH_LONG).show();

    }

  }

}