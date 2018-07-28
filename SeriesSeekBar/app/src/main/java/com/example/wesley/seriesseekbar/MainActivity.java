package com.example.wesley.seriesseekbar;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends Activity {

    private ImageView imageResult;
    private SeekBar seekbarNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageResult = (ImageView) findViewById(R.id.imgResult);
        seekbarNivel = (SeekBar) findViewById(R.id.seekNivel);

        seekbarNivel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int valorProgesso = i;

                seekbarNivel.setMax(3);

                switch(valorProgesso){

                    case 0:
                        imageResult.setImageResource(R.drawable.pouco);
                        break;

                    case 1:
                        imageResult.setImageResource(R.drawable.medio);
                        break;

                    case 2:
                        imageResult.setImageResource(R.drawable.muito);
                        break;

                    case 3:
                        imageResult.setImageResource(R.drawable.susto);
                        break;

                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
