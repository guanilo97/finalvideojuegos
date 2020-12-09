package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCrearpokemons=findViewById(R.id.btncrear);
        Button btnListarpokemos=findViewById(R.id.btnlista);

        btnCrearpokemons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),crearpokemon.class);
                startActivity(intent);
            }
        });
        btnListarpokemos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Listapokemos.class);
                startActivity(intent);
            }
        });
    }
    }
