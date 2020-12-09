package com.example.myapplication.modelos;

import com.example.myapplication.services.pokemones;

public class Pokemons {
    public int id;
    public String nombre;
    public String tipo;
    public String latitud;
    public String longitud;
    public String image;
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Pokemons(int id,String nombre,String tipo,String latitud,String longitud,String image){
    this.id=id;
    this.nombre=nombre;
    this.latitud=latitud;
    this.longitud=longitud;
    this.tipo=tipo;
    this.image=image;
    }

    public Pokemons(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
