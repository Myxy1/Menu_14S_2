package com.example.menu_14s_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextNev;
    private Button buttonMentes;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        buttonMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNev.getText().toString().equals("")) {
                    Toast.makeText(MainActivity2.this, "Nem lehet üres név", Toast.LENGTH_SHORT).show();
                    editTextNev.setError("Nem lehet üres név");
                } else {
                    //putString beletettünk a Data.xml file-ba egy változót
                    editor.putString("nev", editTextNev.getText().toString());
                    //Véglegesítés
                    //commit visszatérési értékként boolean, ha sikeres feltöltés, akkor true, ellenben meg false
                    boolean seged = editor.commit();
                    Log.d("sikeres feltöltés", "" + seged);
                    //apply visszatérési értéke az void
                    //editor.apply();

                    //Vissza menjünk a másik Activity-re
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    //Folyamat elindítása:
                    startActivity(intent);
                    //BackStack - kút példa
                    finish();

                    //asdfoaféadjflaes
                }
            }
        });
    }

    public void init() {
        editTextNev = findViewById(R.id.editTextNev);
        buttonMentes = findViewById(R.id.buttonMentes);
        sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}