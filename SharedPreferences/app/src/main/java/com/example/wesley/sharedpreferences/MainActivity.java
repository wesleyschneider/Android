package com.example.wesley.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtRS;
    private Button btnSalvar;
    private EditText txtNome;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = (EditText) findViewById(R.id.txtNome);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        txtRS = (TextView) findViewById(R.id.txtResult2);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences shared = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = shared.edit();

                if(txtNome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por Favor, preencha o nome!", Toast.LENGTH_SHORT).show();
                }else{
                    editor.putString("nome", txtNome.getText().toString());
                    editor.commit();
                }

                Insert();

            }
        });



    }
    public void Insert(){

        SharedPreferences shared = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        if (shared.contains("nome")) {
            String a = shared.getString("nome", "Usuário não definido!");
            txtRS.setText("Olá, "+a);

        } else {
            txtRS.setText("Olá, Usuário não definido");
        }
    }
}
