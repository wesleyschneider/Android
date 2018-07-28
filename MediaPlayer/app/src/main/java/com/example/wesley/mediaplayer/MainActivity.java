package com.example.wesley.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button buttonTocar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTocar = (Button) findViewById(R.id.btnTocar);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.musica);

        buttonTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mediaPlayer.isPlaying()){
                    pausarMusica();
                }else{
                    tocarMusica();
                }

            }
        });

    }

    private void tocarMusica(){

        if(mediaPlayer != null){
            mediaPlayer.start();
            buttonTocar.setText("Pausar");
        }

    }

    private void pausarMusica(){

        if(mediaPlayer != null){
            mediaPlayer.stop();
            buttonTocar.setText("Tocar");
        }

    }

    @Override
    protected void onDestroy(){

        if(mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

            Toast.makeText(getApplicationContext(), "Destroido", Toast.LENGTH_SHORT).show();
        }
        super.onDestroy();
    }

}
