package com.example.wesley.radiobuttons;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button buttonEnviar;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGrupo);
        buttonEnviar = (Button) findViewById(R.id.btnEnviar);


        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idRadioButton = radioGroup.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(idRadioButton);

                Toast.makeText(getApplicationContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
