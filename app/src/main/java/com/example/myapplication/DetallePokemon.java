package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);
        int id = getIntent().getIntExtra("id",1);
        String nombre =getIntent().getStringExtra("nombre");
        String tipo =getIntent().getStringExtra("tipo");
        //String imagen=getIntent().getStringExtra("imagen");

        ImageView imagenn = findViewById(R.id.ivPokeDe);
        TextView nombres = findViewById(R.id.textNombreDe);
        TextView tipos = findViewById(R.id.textTipoDE);
        nombres.setText(nombre);
        tipos.setText(tipo);
        Button btnubicacion = findViewById(R.id.btnUbi);
        btnubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}