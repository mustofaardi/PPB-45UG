package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    EditText nomor, nama, jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        database = new Database(this);
        nomor = findViewById(R.id.nomor);
        nama = findViewById(R.id.nama);
        jumlah = findViewById(R.id.jumlah);
        btn_simpan = findViewById(R.id.btn_simpan);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM barang WHERE nomor = '" +
                getIntent().getStringExtra("nomor")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            nomor.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            jumlah.setText(cursor.getString(2).toString());
        }

        btn_simpan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("update barang set nomor = '" +
                        nomor.getText().toString()+"', nama = '" +
                        nama.getText().toString()+"', jumlah = '" +
                        jumlah.getText().toString()+"' where nomor = '" +
                        getIntent().getStringExtra("nomor")+"'");
                Toast.makeText(UpdateActivity.this, "Data Berhasil di Update", Toast.LENGTH_SHORT).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}