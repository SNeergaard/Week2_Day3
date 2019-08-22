package com.example.week2_day3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnimalsActivity extends AppCompatActivity{
    RecyclerView rvAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvAnimal = findViewById(R.id.rvAnimals);

        setContentView(R.layout.activity_animals);
        Intent animal_intent = getIntent();
        Bundle animalBundle = animal_intent.getExtras();
        ArrayList<> animalArray = animalBundle.getParcelableArray("animal");
        ArrayAdapter<String> animalAdapter = new ArrayAdapter<>(this, R.layout.recycleciew_item, animalArray);
        rvAnimal.setAdapter(animalAdapter);
    }


}
