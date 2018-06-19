package listview.wesley.com.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listItems;

    //Lista de itens para ser inserido na ListView
    private String[] items = {
            "Angra dos Reis", "Caldas Novas", "Campos do Jordão", "Costa do Sauípe", "Ilhéus", "Porto Seguro",
            "Rio de Janeiro", "Tiradentes", "Praga", "Santiago", "Zurique", "Caribe", "Buenos Aires", "Budapest",
            "Cancun", "Aruda"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems = (ListView) findViewById(R.id.listviewId);

        //Cria um adaptador para adicionar os itens dentro da ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, items
        );
        //Manda o adaptador para a ListView
        listItems.setAdapter(adapter);

        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String valor = (String) listItems.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), valor, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
