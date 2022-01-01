package com.example.tugas8;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tugas8.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;
    public static final String nama_pulau[]={"Sumatra", "Jawa", "Kalimantan", "Sulawesi", "Bali", "NTB", "NTT", "Maluku", "Papua"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        spinner = findViewById(R.id.pilihpulau);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, nama_pulau);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        double lati, longi;
        switch(position)
        {
            case 0:
                mMap.clear();
                LatLng aceh = new LatLng(5.2817319, 95.4854631);
                mMap.addMarker(new MarkerOptions().position(aceh).title("NAD"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(aceh));

                LatLng medan = new LatLng(3.6422756, 98.5294071);
                mMap.addMarker(new MarkerOptions().position(medan).title("Medan"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(medan));

                LatLng palembang = new LatLng(-2.9549663,104.692924);
                mMap.addMarker(new MarkerOptions().position(palembang).title("Palembang"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(palembang));
                break;
            case 1:
                mMap.clear();
                LatLng bogor = new LatLng(-6.545286,106.5339038);
                mMap.addMarker(new MarkerOptions().position(bogor).title("Bogor"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bogor));

                LatLng jakarta = new LatLng(-6.229728,106.6894316);
                mMap.addMarker(new MarkerOptions().position(jakarta).title("Jakarta"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(jakarta));

                LatLng semarang = new LatLng(-7.0247246,110.3470247);
                mMap.addMarker(new MarkerOptions().position(semarang).title("Semarang"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(semarang));

                LatLng surabaya = new LatLng(-7.2756141,112.6426433);
                mMap.addMarker(new MarkerOptions().position(surabaya).title("Surabaya"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(surabaya));
                break;
            case 2:
                mMap.clear();
                LatLng balikpapan = new LatLng(-1.1746021,116.7717075);
                mMap.addMarker(new MarkerOptions().position(balikpapan).title("Balikpapan"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(balikpapan));
                break;
            case 3:
                mMap.clear();
                LatLng makassar = new LatLng(-5.1114857,119.332587);
                mMap.addMarker(new MarkerOptions().position(makassar).title("Makassar"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(makassar));
                break;
            case 4:
                mMap.clear();
                LatLng bali = new LatLng(-8.6726769,115.1542328);
                mMap.addMarker(new MarkerOptions().position(bali).title("Denpasar"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bali));
                break;
            case 5:
                mMap.clear();
                LatLng ntb = new LatLng(-8.5933635,116.4570882);
                mMap.addMarker(new MarkerOptions().position(ntb).title("NTB"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ntb));
                break;
            case 6:
                mMap.clear();
                LatLng ntt = new LatLng(-9.5283609,119.8153825);
                mMap.addMarker(new MarkerOptions().position(ntt).title("NTT"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(ntt));
                break;
            case 7:
                mMap.clear();
                LatLng maluku = new LatLng(-3.7047644,128.1147537);
                mMap.addMarker(new MarkerOptions().position(maluku).title("Ambon"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(maluku));
                break;
            case 8:
                mMap.clear();
                LatLng papua = new LatLng(-4.530618,135.7062244);
                mMap.addMarker(new MarkerOptions().position(papua).title("Papua"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(papua));
                break;
            default:
                Toast.makeText(this, "Pilihan Tidak Ada", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}