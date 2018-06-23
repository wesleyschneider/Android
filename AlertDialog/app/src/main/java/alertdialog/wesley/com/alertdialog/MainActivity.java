package alertdialog.wesley.com.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button btnA;

    //Variavel para o Dialog
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = (Button) findViewById(R.id.btnAbrir);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cria o AlertDialog
                dialog = new AlertDialog.Builder( MainActivity.this );

                //Titulo
                dialog.setTitle("Titulo do AlertDialog");

                //Mensagem
                dialog.setMessage("Mensagem do AlertDialog");

                //False = Se clicar fora da dialog não irá fechar
                dialog.setCancelable(false);

                dialog.setIcon(android.R.drawable.ic_delete);

                //Botão Não
                dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Pressionado o Botão Não", Toast.LENGTH_SHORT).show();
                    }
                });

                //Botão Sim
                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Pressionado o Botão Sim", Toast.LENGTH_SHORT).show();
                    }
                });


                dialog.create();
                dialog.show();

            }
        });

    }
}
