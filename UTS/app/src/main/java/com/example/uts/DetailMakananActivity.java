package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailMakananActivity extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        TextView tvMknNama = findViewById(R.id.tv_mkn_nama);
        TextView tvMknDetail = findViewById(R.id.tv_mkn_detail);
        TextView tvMknHarga = findViewById(R.id.tv_mkn_harga);

        Makanan makanan = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (makanan != null) {
            tvMknNama.setText(makanan.getNama());
            tvMknDetail.setText(makanan.getDetail());
            tvMknHarga.setText(makanan.getHarga());
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Makanan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}