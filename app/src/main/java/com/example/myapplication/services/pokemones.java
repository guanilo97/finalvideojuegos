package com.example.myapplication.services;

import com.example.myapplication.modelos.Pokemons;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface pokemones {
   @GET("pokemons/n00024074")
   Call<List<Pokemons>> getAll();

   @POST("pokemons/n00024074/crear")
   Call<pokemones> create(@Body Pokemons pokemons);
}
