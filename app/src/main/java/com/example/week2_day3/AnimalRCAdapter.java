package com.example.week2_day3;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AnimalRCAdapter extends RecyclerView.Adapter<AnimalRCAdapter.ViewHolder>{


    private ArrayList<Animal> animalArrayList;
    //I had the option to auto select animalArrayList1
    public AnimalRCAdapter(ArrayList<Animal> animalArrayList) {this.animalArrayList = animalArrayList;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleciew_item, parent, false);
        return new ViewHolder(inflatedItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal currentAnimal = animalArrayList.get(position);
        holder.populateValues(currentAnimal);
    }

    @Override
    public int getItemCount() {
        return animalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvAnimal;
        private Animal itemAnimal;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAnimal = itemView.findViewById(R.id.tvAnimal);
            itemView.setOnClickListener(this);
        }
        public void setItemAnimal(Animal itemAnimal){ this.itemAnimal = itemAnimal; }

        public void populateValues(Animal animal) {
            tvAnimal.setText(animal.getAnimal());
            setItemAnimal(animal);
        }

        @Override
        public void onClick(View view) {
           // animalArrayList
            tvAnimal.getText();
//            Intent animal_intent = getIntent();
//            Bundle animalBundle = animal_intent.getExtras();
//            ArrayList<Animal> biomeArrayList = animalBundle.getParcelableArrayList("animal");
//            ArrayList<Animal> detailList = new ArrayList<>();
            Intent detailsIntent = new Intent(view.getContext(), DetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("desc", itemAnimal);
            detailsIntent.putExtras(bundle);
            view.getContext().startActivity(detailsIntent);
        }
    }
}
