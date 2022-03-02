package com.example.imusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class language extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;

    Button back;

    TextView textView;

    public static final String EXTRA_NAME2="com.example.imusic.extra.NAME2";
    public static final String EXTRA_NAME3="com.example.imusic.extra.NAME3";
    public static final String EXTRA_NAME4="com.example.imusic.extra.NAME4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_layout);

        Intent intent= getIntent();
        String lang = intent.getStringExtra(MainActivity.EXTRA_NAME);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        textView=findViewById(R.id.textView3);
        back=findViewById(R.id.back);

        String eng = "english";
        if(lang.equals(eng)){
            b1.setText("At my worst");
            b2.setText("Let me love you");
            b3.setText("Sugar & Brownies");
            b4.setText("Trampoline");
            b5.setText("Way back home");
            textView.setText("English Songs");


        }
        else{
            b1.setText("Dil ko karaar aaya");
            b2.setText("Dil na jaaneya");
            b3.setText("Kabhii tumhe");
            b4.setText("Pal");
            b5.setText("Tera hua");
            textView.setText("Hindi Songs");

        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(language.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void openSong1(View v){
        Intent intent= new Intent(language.this, song.class);
        startActivity(intent);

        String sn = "1";
        intent.putExtra(EXTRA_NAME2, sn);

        String sname=b1.getText().toString();
        intent.putExtra(EXTRA_NAME3, sname);

        String l=textView.getText().toString();
        intent.putExtra(EXTRA_NAME4,l);
        startActivity(intent);
    }
    public void openSong2(View v){
            Intent intent= new Intent(language.this, song.class);
            startActivity(intent);

            String sn = "2";
            intent.putExtra(EXTRA_NAME2, sn);

            String sname=b2.getText().toString();
            intent.putExtra(EXTRA_NAME3, sname);

            String l=textView.getText().toString();
            intent.putExtra(EXTRA_NAME4,l);
            startActivity(intent);
        }
        public void openSong3(View v){
                Intent intent= new Intent(language.this, song.class);
                startActivity(intent);

                String sn = "3";
                intent.putExtra(EXTRA_NAME2, sn);

                String sname=b3.getText().toString();
                intent.putExtra(EXTRA_NAME3, sname);

                String l=textView.getText().toString();
                intent.putExtra(EXTRA_NAME4,l);
                startActivity(intent);
            }
        public void openSong4(View v){
                Intent intent= new Intent(language.this, song.class);
                startActivity(intent);

                String sn = "4";
                intent.putExtra(EXTRA_NAME2, sn);

                String sname=b4.getText().toString();
                intent.putExtra(EXTRA_NAME3, sname);

                String l=textView.getText().toString();
                intent.putExtra(EXTRA_NAME4,l);
                startActivity(intent);
            }
        public void openSong5(View v){
                Intent intent= new Intent(language.this, song.class);
                startActivity(intent);

                String sn = "5";
                intent.putExtra(EXTRA_NAME2, sn);

                String sname=b5.getText().toString();
                intent.putExtra(EXTRA_NAME3, sname);

                String l=textView.getText().toString();
                intent.putExtra(EXTRA_NAME4,l);
                startActivity(intent);
            }

}