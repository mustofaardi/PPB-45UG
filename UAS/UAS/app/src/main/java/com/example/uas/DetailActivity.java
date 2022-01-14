package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    TextView nomor, nama, jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        database = new Database(this);
        nomor = findViewById(R.id.nomor);
        nama = findViewById(R.id.nama);
        jumlah = findViewById(R.id.jumlah);
        btn_simpan = findViewById(R.id.btn_simpan);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery( "SELECT * FROM barang WHERE nomor = '" +
                getIntent().getStringExtra("nomor")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            nomor.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            jumlah.setText(cursor.getString(2).toString());
        }
    }
}