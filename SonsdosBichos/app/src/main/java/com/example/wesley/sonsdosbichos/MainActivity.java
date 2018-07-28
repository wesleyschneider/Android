package com.example.wesley.sonsdosbichos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView buttonCao;
    private ImageView buttonGato;
    private ImageView buttonLeao;
    private ImageView buttonMacaco;
    private ImageView buttonOvelha;
    private ImageView buttonVaca;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCao = (ImageView) findViewById(R.id.btnCao);
        buttonGato = (ImageView) findViewById(R.id.btnGato);
        buttonLeao = (ImageView) findViewById(R.id.btnLeao);
        buttonMacaco = (ImageView) findViewById(R.id.btnMacaco);
        buttonOvelha = (ImageView) findViewById(R.id.btnOvelha);
        buttonVaca = (ImageView) findViewById(R.id.btnVaca);

        buttonCao.setOnClickListener(this);
        buttonGato.setOnClickListener(this);
        buttonLeao.setOnClickListener(this);
        buttonMacaco.setOnClickListener(this);
        buttonOvelha.setOnClickListener(this);
        buttonVaca.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btnCao:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cao);
                startSound();
                break;
            case R.id.btnGato:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.gato);
                startSound();
                break;
            case R.id.btnLeao:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.leao);
                startSound();
                break;
            case R.id.btnMacaco:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.macaco);
                startSound();
                break;
            case R.id.btnOvelha:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.ovelha);
                startSound();
                break;
            case R.id.btnVaca:
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.vaca);
                startSound();
                break;
        }

    }

    public void startSound(){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer != null && mediaPlayer.isPlaying()){

            mediaPlayer.release();
            mediaPlayer = null;

        }
        super.onDestroy();

    }


}
