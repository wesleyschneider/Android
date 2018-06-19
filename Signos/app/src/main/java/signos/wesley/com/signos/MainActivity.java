package signos.wesley.com.signos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listSignos;
    private String[] signos = {"Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Libra", "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes"};
    private String[] desc = {
            "Impulsivo, o ariano não pensa muito sobre seus atos. É aquele que primeiro age, depois reflete. Agitado, precisa de muita atividade para gastar a energia, senão pode ficar agressivo e explosivo.",
            "Teimoso, o taurino é determinado e protetor. Precisa de segurança e estabilidade para ser feliz, e conquista isso com muito trabalho e concentração. Carinhoso, o taurino pode ser ciumento com quem ama.",
            "Espontâneo e um pouco instável, o geminiano é uma verdadeira caixinha de surpresas. Como é volátil, muitas vezes nem mesmo o geminiano se entende, mas o importante é que ele está sempre de bom humor e em busca de aventuras.",
            "Família é a palavra-chave para o canceriano. Tranquilo e emotivo, gosta de ficar em casa, fazer programas com quem ama e curtir momentos com os parentes. Curioso, faz amizade com facilidade, mas pode ser um pouco sensível.",
            "Este é signo que veio para brilhar. O leonino gosta de chamar a atenção e ser o centro do mundo, mas também é muito amável e leal. Simpático e comunicativo, o nativo de leão pode ser um pouco ciumento e inseguro.",
            "Perspicaz e inteligente, o virginiano está acostumado com o sucesso, por isso se cobra muito, assim como aos demais. Por isso, pode ser um pouco rígido e magoar quem ama. Tímido, prefere programas tranquilos a grandes eventos.",
            "O libriano gosta do que é belo e harmonioso. Não gosta de conflitos e por isso tenta ser imparcial em debates e brigas. Indeciso, pode demorar muito para escolher coisas simples, como o que comer ou vestir. Bom gosto define este signo.",
            "Determinado, o escorpiano vai até o fim para conquistar os seus objetivos. Sensual e romântico, gosta de estar em relacionamentos, mas pode ser desconfiado enquanto não se sentir seguro com a pessoa.",
            "Um signo de bem com a vida, que está sempre em busca de ação e que vive rodeado de amigos. Este é o signo de sagitário, que é sonhador e adora conhecer pessoas e lugares novos.",
            "Trabalhador, tímido e educado, o capricórnio pode passar uma imagem de fechado e até mesmo antipático, mas é que ele eprecisa confiar em quem está ao seu lado para se abrir totalmente. Com paciência, ele se mostra um amigo leal e um companheiro fiel.",
            "Independente, o aquariano preza muito por sua liberdade. Gosta de viajar, sair e conhecer pessoas novas. Tem uma mente aberta e gosta de tudo o que é inovador e moderno, desde roupas e tecnologia, até mesmo atitudes comportamentais.",
            "Este é o signo mais romântico do zodíaco. Sonhador e carinhoso, ele está sempre preocupado com o bem estar dos outros. Sensível e carinhoso, acredita em contos de fadas e acha que todos merecem um final feliz."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listSignos = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, signos);

        listSignos.setAdapter(adapter);
        
        listSignos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), desc[i], Toast.LENGTH_SHORT).show();
            }
        });



    }
}
