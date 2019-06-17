package com.example.umamaheshwari.apps;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CardDetail extends AppCompatActivity {

    Button btnprvw, sub, bod;
    TextView txtvw;

    Calendar c;
    DatePickerDialog dpd;

    RadioGroup gr;
    RadioButton hrice, arce, nrec, srce, crce, rb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);

        btnprvw = (Button) findViewById(R.id.btnprvw);
        sub = (Button)findViewById(R.id.sub);
        txtvw = (TextView) findViewById(R.id.txtvw);
        hrice = (RadioButton)findViewById(R.id.hrice);
        arce = (RadioButton)findViewById(R.id.arce);
        nrec = (RadioButton)findViewById(R.id.nrec);
        srce = (RadioButton)findViewById(R.id.srce);
        crce = (RadioButton)findViewById(R.id.crce);
        gr = (RadioGroup)findViewById(R.id.rggrp);
        bod = (Button) findViewById(R.id.bod);

        bod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(CardDetail.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        txtvw.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
                    }
                }, day, month, year);
                dpd.show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardDetail.this, alert.class);
                startActivity(intent);
            }
        });

    }
    public void rbclick(View v){
        int radiobuttonid = gr.getCheckedRadioButtonId();
        rb = (RadioButton)findViewById(radiobuttonid);

        Toast.makeText(getBaseContext(), rb.getText(), Toast.LENGTH_SHORT).show();

    }
}




