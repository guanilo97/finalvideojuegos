package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetallePokemon;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.modelos.Pokemons;
import com.example.myapplication.services.pokemones;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHlder>{
    private List<Pokemons> mData;
    private MainActivity mainActivity;
    public PokemonAdapter(List<Pokemons> data,MainActivity mainActivity){
        mData=data;
        this.mainActivity=mainActivity;
    }
    public PokemonAdapter(List<Pokemons> data){
        mData=data;
    }

    @NonNull
    @Override
    public PokemonViewHlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pokemon,parent,false);
        return new PokemonViewHlder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHlder holder, int position) {
        TextView tvNombreLista =holder.mView.findViewById(R.id.tvnombrelista);
        TextView tvPhone=holder.mView.findViewById(R.id.tvPhoneLista);
        ImageView ivpoke=holder.mView.findViewById(R.id.ivpoke);

        final Pokemons pokemons=mData.get(position);
        tvNombreLista.setText(pokemons.getNombre());
        tvPhone.setText(pokemons.getTipo());
        Picasso.get().load(pokemons.getImage()).into(ivpoke);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.context, "Este mensaje de click "+ position,Toast.LENGTH_SHORT).show();
                Context context=view.getContext();
                Intent intent=new Intent(context, DetallePokemon.class);
                intent.putExtra("id",pokemons.getId());
                intent.putExtra("name",pokemons.getNombre());
                intent.putExtra("email",pokemons.getTipo());
                intent.putExtra("phone",pokemons.getLatitud());
                intent.putExtra("phone",pokemons.getLongitud());
                //intent.putExtra("imagen",contacto.getImage());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class  PokemonViewHlder extends RecyclerView.ViewHolder{
        private View mView;
        public Context context ;
        public PokemonViewHlder(@NonNull View itemView,Context context) {
            super(itemView);
            mView=itemView;
            this.context=context;
        }
    }


}