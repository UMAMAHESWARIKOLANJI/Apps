package com.example.umamaheshwari.apps;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.security.cert.Extension;
import java.util.Calendar;
import java.util.Objects;

import static java.lang.String.*;

public class DetailActivity extends AppCompatActivity {

    EditText ename, egender, etpassword, btext;
    RadioButton rbut, rrbt, rb;
    RadioGroup rg;
    Button btnback, btnsub;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ename = (EditText) findViewById(R.id.ename);
        egender = (EditText) findViewById(R.id.egender);
        etpassword = (EditText) findViewById(R.id.etpassword);
        rbut = (RadioButton) findViewById(R.id.rbut);
        rrbt = (RadioButton) findViewById(R.id.rrbt);
        rg = (RadioGroup) findViewById(R.id.rgroup);
        btnback = (Button) findViewById(R.id.btnback);
        btnsub = (Button) findViewById(R.id.btnsub);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailActivity.this, CardDetail.class);
                startActivity(i);
            }
        });
    }
    public void rbclick(View v) {
        int radiobuttonid = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radiobuttonid);

        Toast.makeText(getBaseContext(), rb.getText(), Toast.LENGTH_LONG).show();
    }
}