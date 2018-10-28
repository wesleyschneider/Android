package com.example.wesley.todo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtAdd;
    private Button btnAdd;
    private RecyclerView recyclerView;
    private SQLiteDatabase bd;
    ArrayList<String> itens;


    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando os Componentes
        txtAdd = findViewById(R.id.txtAdd);
        btnAdd = findViewById(R.id.btnAdd);

        try{

            //Banco de dados
            bd = openOrCreateDatabase("apptodo", MODE_PRIVATE, null);

            bd.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR(200))");

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String texto = txtAdd.getText().toString();

                    Insert(texto);
                    txtAdd.setText("");
                    SelectTarefas();
                }
            });

            SelectTarefas();

        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Não foi possível conectar-se ao banco de dados!", Toast.LENGTH_LONG).show();
        }

    }

    private void Insert(String texto){
        try {

            if(!texto.equals("")) {
                bd.execSQL("INSERT INTO tarefas(tarefa) VALUES('" + texto + "')");
            }else{
                Toast.makeText(getApplicationContext(), "Digite uma tarefa!", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("Error", " " + e.getMessage());
            Toast.makeText(getApplicationContext(), "Erro ao inserir registro!", Toast.LENGTH_LONG).show();
        }
    }

    private void SelectTarefas(){
        try {
            //Manipular registros salvos (Basicamente um obj no php)
            Cursor cursor = bd.rawQuery("SELECT * FROM tarefas", null);

            updateRecycler(cursor);

            cursor.close();

        }catch (Exception e){
            Log.e("Error", " " + e.getMessage());
            Toast.makeText(getApplicationContext(), "Erro ao atualizar tarefas!", Toast.LENGTH_LONG).show();
        }
    }

    private void updateRecycler(Cursor cursor){

        //Criar adaptador
        itens = new ArrayList<String>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Listar as tarefas
        if(cursor.moveToFirst()){

            do{
                //Log.i("Resultado " , "ID: " + cursor.getInt(cursor.getColumnIndex("id")) + "     Tarefa:" + cursor.getString(cursor.getColumnIndex("tarefa")));
                itens.add(cursor.getInt(cursor.getColumnIndex("id")) + ". " + cursor.getString(cursor.getColumnIndex("tarefa")));
            }while(cursor.moveToNext());

        }

        AdapterTarefas adapter = new AdapterTarefas(itens);
        recyclerView.setAdapter(adapter);
    }

}
