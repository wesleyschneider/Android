package com.example.wesley.checkbox;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button btnMostrar;
    private TextView txtResultado;

    private CheckBox opcao1;
    private CheckBox opcao2;
    private CheckBox opcao3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMostrar = (Button) findViewById(R.id.btnShow);
        txtResultado = (TextView) findViewById(R.id.txtResult);

        opcao1 = (CheckBox) findViewById(R.id.option1);
        opcao2 = (CheckBox) findViewById(R.id.option2);
        opcao3 = (CheckBox) findViewById(R.id.option3);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "Item: " + opcao1.getText() + " Status: " + opcao1.isChecked() + "\n";
                res += "Item: " + opcao2.getText() + " Status: " + opcao2.isChecked() + "\n";
                res += "Item: " + opcao3.getText() + " Status: " + opcao3.isChecked() + "\n";

                txtResultado.setText(res);

            }
        });

    }
}
