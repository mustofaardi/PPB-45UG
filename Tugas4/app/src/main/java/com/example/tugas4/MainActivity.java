package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataHelper myDb;
    EditText editTitle, editMc, editHeroine, editGenre, editYear, editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataHelper(this);

        editTitle = (EditText) findViewById(R.id.editText_title);
        editMc = (EditText) findViewById(R.id.editText_mc);
        editHeroine = (EditText) findViewById(R.id.editText_heroine);
        editGenre = (EditText) findViewById(R.id.editText_genre);
        editYear = (EditText) findViewById(R.id.editText_year);
        editTextId = (EditText)findViewById(R.id.editText_id);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data dihapus",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data tidak dihapus",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editTitle.getText().toString(),
                                editMc.getText().toString(),
                                editHeroine.getText().toString(),
                                editGenre.getText().toString(),
                                editYear.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data diubah",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data tidak diubah",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editTitle.getText().toString(),
                                editMc.getText().toString(),
                                editHeroine.getText().toString(),
                                editGenre.getText().toString(),
                                editYear.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this, "Data ditambahkan", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Data tidak ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id : "+ res.getString(0)+"\n");
                            buffer.append("Judul : "+ res.getString(1)+"\n");
                            buffer.append("MC : "+ res.getString(2)+"\n");
                            buffer.append("Heroine : "+ res.getString(3)+"\n");
                            buffer.append("Genre : "+ res.getString(4)+"\n");
                            buffer.append("Tahun Rilis : "+ res.getString(5)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}