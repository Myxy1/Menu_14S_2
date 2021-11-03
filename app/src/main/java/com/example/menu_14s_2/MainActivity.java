package com.example.menu_14s_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonNev, buttonInformacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonNev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Átmegyünk egyik Activity-ről a másikra
                //Intent ==> megnyitunk egy másik ablakot
                //Honnan -- hova
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //Folyamat elindítása:
                startActivity(intent);
                //BackStack - kút példa
                finish();
            }
        });

        buttonInformacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences --> globális változó map
                //String nev = "Nev"
                //file név, titkosítás
                SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
                String seged = sharedPreferences.getString("nev", "Nincs mentve név");
                Toast.makeText(MainActivity.this, seged, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init() {
        buttonNev = findViewById(R.id.buttonNev);
        buttonInformacio = findViewById(R.id.buttonInformacio);
    }
}