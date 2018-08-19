package com.example.wesley.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txtBloco;
    private Button btnSalvar;

    public static final String ARQUIVO = "anotacao.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBloco = (EditText) findViewById(R.id.txtBloco);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String texto = txtBloco.getText().toString();

                if(!texto.equals("")){
                    saveArchive(texto);
                    Toast.makeText(MainActivity.this, "Anotações salvas com sucesso!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        if(readArchive() != null){
            txtBloco.setText(readArchive());
            txtBloco.setSelection(txtBloco.getText().length());
        }

    }

    private void saveArchive(String texto){
        try{
            OutputStreamWriter output = new OutputStreamWriter(openFileOutput(ARQUIVO, Context.MODE_PRIVATE));
            output.write(texto);
            output.close();
        }catch(IOException e){
            Log.v("MainActivity", e.toString());
        }
    }

    private String readArchive(){
        String rs = "";

        try{
            //Abre o arquivo
            InputStream archive = openFileInput(ARQUIVO);

            if(archive != null){
                //Ler o arquivo
                InputStreamReader inputReader = new InputStreamReader(archive);

                //Gerar buffer do arquivo lido
                BufferedReader buffered = new BufferedReader(inputReader);

                //Salvar texto do arquivo
                String linha = "";
                while((linha = buffered.readLine()) != null){
                    rs += linha;
                }

                //Fechar o arquivo
                archive.close();
            }

        }catch(IOException e){
            Log.v("MainActivity", e.toString());
        }

        return rs;
    }
}
