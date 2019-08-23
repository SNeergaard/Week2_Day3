package com.example.week2_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    TextView tvDescription;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvDescription = findViewById(R.id.tvDescripton);

        Intent desc_intent = getIntent();
        Animal passedAnimal = desc_intent.getExtras().getParcelable("desc");
        bindViews();
        populateViews(passedAnimal);
        mediaPlayer = MediaPlayer.create(this, passedAnimal.getSound());
        mediaPlayer.start();
    }

    protected void onPause(){
        mediaPlayer.stop();
    }

    private void populateViews(Animal passedAnimal) {
        tvDescription.setText(passedAnimal.getDescription());
    }

    private void bindViews() {
        tvDescription = findViewById(R.id.tvDescripton);
    }


}
