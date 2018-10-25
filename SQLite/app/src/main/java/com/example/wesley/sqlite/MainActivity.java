package com.example.wesley.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView txtRS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRS = (TextView) findViewById(R.id.txtRS);

        try {

            //Criar Banco de Dados
            SQLiteDatabase bd = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Tabela
            bd.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER primary key AUTOINCREMENT, nome varchar(150), idade int(3))");

            //Insert
            //bd.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Wesley Schneider Aires', 18)");
            //bd.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Thalya Ribeiro Oreste', 19)");


            //Select
            Cursor cursor = bd.rawQuery("SELECT * FROM pessoas WHERE idade > 18", null);

            int indexColumnId = cursor.getColumnIndex("id");
            int indexColumnNome = cursor.getColumnIndex("nome");
            int indexColumnIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            String result  = "";

            while(cursor != null){
                int id = cursor.getInt(indexColumnId);
                String nome = cursor.getString(indexColumnNome);
                int idade = cursor.getInt(indexColumnIdade);

                result += "ID: " + id +"\n" + "Nome: " + nome + "\n" + "Idade: " + idade + "\n\n\n\n";

                txtRS.setText(result);
                cursor.moveToNext();
            }

        }catch (Exception e){
            Log.i("Erro:", e.toString());
        }

    }
}
