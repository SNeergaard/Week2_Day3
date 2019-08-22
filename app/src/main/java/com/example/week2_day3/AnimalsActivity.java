package com.example.week2_day3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnimalsActivity extends AppCompatActivity{
public static final String TAG = "LOG ANIMIAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        RecyclerView rvAnimal;

        rvAnimal = findViewById(R.id.rvAnimals);

        //opening bundle
        Intent animal_intent = getIntent();
        Bundle animalBundle = animal_intent.getExtras();
        ArrayList<Animal> biomeArrayList = animalBundle.getParcelableArrayList("animal");
        Log.d(TAG, "onCreate: " + biomeArrayList.toString());
        //layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAnimal.setLayoutManager(layoutManager);
        //adapter
        AnimalRCAdapter animalRCAdapter = new AnimalRCAdapter(biomeArrayList);
        rvAnimal.setAdapter(animalRCAdapter);



        //ArrayAdapter<String> animalAdapter = new ArrayAdapter<String>(this, R.layout.recycleciew_item, biomeArrayList);
        //rvAnimal.setAdapter(animalAdapter);
    }


}
