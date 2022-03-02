package com.example.imusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class song extends AppCompatActivity {

    TextView textView;
    private ImageButton play;

    private ImageButton prev;
    private ImageButton next;
    private SeekBar seekBar;
    MediaPlayer mediaPlayer;
    Button back;

    Handler handler= new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_layout);

        final boolean[] flag = {false};

        textView=findViewById(R.id.textView4);
        play=findViewById(R.id.play);
        prev=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        seekBar=findViewById(R.id.seekBar);
        back=findViewById(R.id.back2);

        Intent intent= getIntent();
        String songName = intent.getStringExtra(language.EXTRA_NAME2);
        String lang = intent.getStringExtra(language.EXTRA_NAME4);
        String name=intent.getStringExtra(language.EXTRA_NAME3);

        textView.setText("Playing\n"+name+"...");
        int num=Integer.parseInt(songName);

        String eng = "English Songs";
        if(lang.equals(eng)){
            if(num==1){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.at_my_worst);
            }
            if(num==2){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.let_me_love_you);
            }
            if(num==3){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sugar_and_brownies);
            }
            if(num==4){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.trampoline);
            }
            if(num==5){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.way_back_home);
            }
        }

        else{
            if(num==1){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dil_ko_karaar_aaya);
            }
            if(num==2){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dil_na_jaaneya);
            }
            if(num==3){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kabhii_tumhhe);
            }
            if(num==4){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pal);
            }
            if(num==5){
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tera_hua);
            }
        }
//        mediaPlayer.start();

        seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag[0]){
                    mediaPlayer.start();
                    UpdateSeekBar updateSeekBar = new UpdateSeekBar();
                    handler.post(updateSeekBar);
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);
                    flag[0] =true;

                }
                else{
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_baseline_play_circle_filled_24);
                    flag[0] =false;
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                Intent intent = new Intent(song.this, MainActivity.class);
                startActivity(intent);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int SUB_TIME=5000;
                int curPos=mediaPlayer.getCurrentPosition();
                if(curPos-SUB_TIME>0){
                    mediaPlayer.seekTo(curPos-SUB_TIME);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ADD_TIME=5000;
                int curPos=mediaPlayer.getCurrentPosition();
                int duration=mediaPlayer.getDuration();
                if(curPos+ADD_TIME<duration){
                    mediaPlayer.seekTo(curPos+ADD_TIME);
                }
            }
        });

    }

    public class UpdateSeekBar implements Runnable{

        @Override
        public void run(){
            seekBar.setProgress(mediaPlayer.getCurrentPosition());

            handler.postDelayed(this,100);
        }
    }

}