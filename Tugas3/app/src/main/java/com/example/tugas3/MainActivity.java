package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText angk1,angk2;
    TextView hasilnya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angk1 = (EditText) findViewById(R.id.angka1);
        angk2 = (EditText) findViewById(R.id.angka2);
        hasilnya = (TextView) findViewById(R.id.hasilhitung);
    }

    public void hitungPenjumlahan(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil = a1+a2;
        hasilnya.setText(hasil.toString());
    }

    public void hitungPengurangan(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil = a1-a2;
        hasilnya.setText(hasil.toString());
    }

    public void hitungPerkalian(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil = a1*a2;
        hasilnya.setText(hasil.toString());
    }

    public void hitungPembagian(View view) {
        double a1 = Double.parseDouble(angk1.getText().toString());
        double a2 = Double.parseDouble(angk2.getText().toString());
        Double hasil = a1/a2;
        hasilnya.setText(hasil.toString());
    }
}