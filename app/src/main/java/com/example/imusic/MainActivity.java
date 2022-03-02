package com.example.imusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_NAME="com.example.imusic.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openHindi(View v){
        Toast.makeText(this, "Opening hindi songs", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, language.class);

        String lang = "hindi";
        intent.putExtra(EXTRA_NAME, lang);
        startActivity(intent);
    }
    public void openEnglish(View v){
        Toast.makeText(this, "Opening english songs", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, language.class);
        startActivity(intent);

        String lang = "english";
        intent.putExtra(EXTRA_NAME, lang);
        startActivity(intent);
    }

}