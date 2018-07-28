package com.example.wesley.togglebuttons;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private ToggleButton togglePower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        togglePower = (ToggleButton) findViewById(R.id.tooglePower);

        togglePower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                String rs;

                if(b){
                    rs = "Ligado";
                }else{
                    rs = "Desligado";
                }

                Toast.makeText(getApplicationContext(), "O estado do botão mudou para: "+rs, Toast.LENGTH_LONG).show();

            }
        });

    }
}
