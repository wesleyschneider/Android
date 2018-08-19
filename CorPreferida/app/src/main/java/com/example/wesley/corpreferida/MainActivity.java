package com.example.wesley.corpreferida;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnMudar;
    private TextView txtTitle;

    private RadioGroup rdGroup;
    private RadioButton rdSelect;
    private RadioButton rdVermelho;
    private RadioButton rdAmarelo;
    private RadioButton rdPreto;

    private ConstraintLayout layout;

    public static final String ARQUIVO_PREFERENCE = "ARQUIVO_PREFERENCE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
        btnMudar = (Button) findViewById(R.id.btnMudar);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        layout = (ConstraintLayout) findViewById(R.id.layoutId);

        rdVermelho = (RadioButton) findViewById(R.id.rdVermelho);
        rdAmarelo = (RadioButton) findViewById(R.id.rdAmarelo);
        rdPreto = (RadioButton) findViewById(R.id.rdPreto);

        btnMudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idRdSelect = rdGroup.getCheckedRadioButtonId();

                if(idRdSelect > 0) {
                    rdSelect = (RadioButton) findViewById(idRdSelect);

                    String cor = rdSelect.getText().toString();

                    SharedPreferences shared = getSharedPreferences(ARQUIVO_PREFERENCE, 0);
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("cor", cor);
                    editor.commit();

                    changeBackground(cor);

                }
            }
        });

        SharedPreferences shared = getSharedPreferences(ARQUIVO_PREFERENCE, 0);

        if(shared.contains("cor")){
            String cor = shared.getString("cor", "0");
            changeBackground(cor);
        }

    }

    private void changeBackground(String cor){
        switch(cor){
            case "Vermelho":
                layout.setBackgroundColor(Color.parseColor("#FFD40909"));
                txtTitle.setTextColor(Color.parseColor("#FFFFFF"));

                rdVermelho.setTextColor(Color.parseColor("#FFFFFF"));
                rdAmarelo.setTextColor(Color.parseColor("#FFFFFF"));
                rdPreto.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case "Amarelo":
                layout.setBackgroundColor(Color.parseColor("#FFDBF303"));

                txtTitle.setTextColor(Color.parseColor("#000000"));

                rdVermelho.setTextColor(Color.parseColor("#000000"));
                rdAmarelo.setTextColor(Color.parseColor("#000000"));
                rdPreto.setTextColor(Color.parseColor("#000000"));
                break;
            case "Preto":
                layout.setBackgroundColor(Color.parseColor("#FF232323"));
                txtTitle.setTextColor(Color.parseColor("#FFFFFF"));

                rdVermelho.setTextColor(Color.parseColor("#FFFFFF"));
                rdAmarelo.setTextColor(Color.parseColor("#FFFFFF"));
                rdPreto.setTextColor(Color.parseColor("#FFFFFF"));
                break;
        }
    }
}
