package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.myapplication.services.pokemones;

import com.example.myapplication.modelos.Pokemons;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class crearpokemon extends AppCompatActivity {
    String imagen ;
    private static final int SELECT_FILE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearpokemon);
        final EditText txtNombres = findViewById(R.id.txtNames);
        final EditText txtTipos =findViewById(R.id.txtTipo);
        final EditText txtLatitud = findViewById(R.id.txtlatitud);
        final EditText txtLongitud = findViewById(R.id.txtlongitud);
        Button CargarPorGaleria = findViewById(R.id.btnimagen);

        CargarPorGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(
                        Intent.createChooser(intent, "Seleccione una imagen"),
                        SELECT_FILE);
            }
        });
        Button btnGuardarContacto=findViewById(R.id.btnguardar);
        btnGuardarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pokemons poke = new Pokemons();
                //Obtenermos los textos
                poke.setNombre(txtNombres.getText().toString());
                poke.setTipo(txtTipos.getText().toString());
                poke.setLatitud(txtLatitud.getText().toString());
                poke.setLongitud(txtLongitud.getText().toString());
                poke.setImage(imagen);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                pokemones service=retrofit.create(pokemones.class);

               service.create(poke).enqueue(new Callback<pokemones>() {
                   @Override
                   public void onResponse(Call<pokemones> call, Response<pokemones> response) {

                   }

                   @Override
                   public void onFailure(Call<pokemones> call, Throwable t) {

                   }
               });
                //ENVIAR AL INICIO
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

                Log.d("urlDeImagen",imagen);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        Uri selectedImageUri = null;
        Uri selectedImage;

        String filePath = null;
        switch (requestCode) {
            case SELECT_FILE:
                if (resultCode == MainActivity.RESULT_OK) {
                    selectedImage = imageReturnedIntent.getData();
                    String selectedPath=selectedImage.getPath();
                    if (requestCode == SELECT_FILE) {

                        if (selectedPath != null) {
                            InputStream imageStream = null;
                            try {
                                imageStream = getContentResolver().openInputStream(
                                        selectedImage);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            // Transformamos la URI de la imagen a inputStream y este a un Bitmap
                            Bitmap bmp = BitmapFactory.decodeStream(imageStream);

                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                            byte[] imageBytes = baos.toByteArray();
                            String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);

                            //decode base64 string to image
                            imageBytes = Base64.decode(imageString, Base64.DEFAULT);
                            Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);


                            // Ponemos nuestro bitmap en un ImageView que tengamos en la vista
                            ImageView mImg = (ImageView) findViewById(R.id.ivpokemonCrear);
                            mImg.setImageBitmap(bmp);

                            Log.d("cadena",imageString);
                            copiarimagen(imageString);

                        }
                    }
                }
                break;
        }
    }

    public void copiarimagen(String imageString){
        imagen = imageString;
    }
}