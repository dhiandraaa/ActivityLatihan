package com.example.dicoding.belajardic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText panjang, lebar, tinggi;
    private Button hitung;
    private TextView hasil;
    private String STATE_HASIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panjang = (EditText)findViewById(R.id.panjang);
        lebar = (EditText)findViewById(R.id.lebar);
        tinggi = (EditText)findViewById(R.id.tinggi);
        hitung = (Button)findViewById(R.id.hitung);
        hasil = (TextView)findViewById(R.id.result);
        hitung.setOnClickListener(this);

        if (savedInstanceState != null) {
            String save = savedInstanceState.getString(STATE_HASIL);
            hasil.setText(save);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL,hasil.getText().toString());
        super.onSaveInstanceState(outState);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.hitung) {
            String lenght = panjang.getText().toString().trim();
            String width = lebar.getText().toString().trim();
            String height = tinggi.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(lenght)) {
                isEmptyFields = true;
                panjang.setError("Field ini tidak oleh kosong");
            }
            if (TextUtils.isEmpty(width)) {
                isEmptyFields = true;
                lebar.setError("Field ini tidak oleh kosong");
            }
            if (TextUtils.isEmpty(height)) {
                isEmptyFields = true;
                tinggi.setError("Field ini tidak oleh kosong");
            }
            if (!isEmptyFields) {
                double p = Double.parseDouble(lenght);
                double l = Double.parseDouble(width);
                double t = Double.parseDouble(height);
                double Volume = p * l * t;
                hasil.setText(String.valueOf(Volume));
            }

        }
    }

}
