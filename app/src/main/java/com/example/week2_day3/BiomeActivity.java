package com.example.week2_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class BiomeActivity extends AppCompatActivity {
    private ArrayList<String> categories = new ArrayList<>();
    ArrayList<Animal> animalList = new ArrayList<>();
    private ListView listBiome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biome);
        listBiome = findViewById(R.id.listBiome);
        //Adapter
        CreateCatigorys();

        ArrayAdapter<String> BiomeAdapter = new ArrayAdapter<>(this, R.layout.listview_item, categories);
        listBiome.setAdapter(BiomeAdapter);
        listBiome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                getanimallist();
                ArrayList<Animal> biomeAnimalsArrayList = new ArrayList<>();
                Intent biome_intent = new Intent(view.getContext(), AnimalsActivity.class);
                //I want to load all animals of the same biome into the recycler view
                for (Animal animal : animalList) {
                    if(animal.getBiome() == categories.get(j)) {  //if anial is from this biome
                        biomeAnimalsArrayList.add(animal);
                    }
                }
                biome_intent.putExtra("animal",biomeAnimalsArrayList);
                startActivity(biome_intent);
            }
        });
    }

    private ArrayList<Animal> getanimallist(){
        if (animalList.isEmpty()) {
            animalList.add(new Animal("Arctic", "Polar Bear", "YO! That white bear's a unit!", R.raw.bear_polar));
            animalList.add(new Animal("Arctic", "Penguin", "These birds gave up wings for flipers, because they are extra", R.raw.penguin3));
            animalList.add(new Animal("Arctic", "Harp Seal", "the cutest little floofest seal around", R.raw.harpseals));
            animalList.add(new Animal("Jungle", "Monkey", "little monkey fella", R.raw.monkey1));
            animalList.add(new Animal("Jungle", "Tiger", "this ferocious cat screams that the start of movies", R.raw.tiger6));
            animalList.add(new Animal("Jungle", "Lemur", "The hopping star of Zuboomafoo", R.raw.lemur4));
            animalList.add(new Animal("Savannah", "Hyena", "They are having a giggle because im not sure if this is a dog or not.", R.raw.hyena));
            animalList.add(new Animal("Savannah", "Elephent", "These are the biggest land animal around. They also think you are cute:)", R.raw.elephantcub));
            animalList.add(new Animal("Savannah", "Warthog", "you will need a large gun if 30-50 of these show up", R.raw.hog11));
            animalList.add(new Animal("Desert", "Rattle Snake", "Watch out this danger noodle plays maracas", R.raw.rattlesnakerattle));
            animalList.add(new Animal("Desert", "Coyote", "This boi will never catch a roadrunner", R.raw.coyote1));
            animalList.add(new Animal("Desert", "Bat", "Against popular belief probably not here to suck you blood.", R.raw.bat2));
        }
        return animalList;
    }

    private void CreateCatigorys(){
        categories.add("Arctic");
        categories.add("Jungle");
        categories.add("Savannah");
        categories.add("Desert");
    }

}
