package br.edu.utfpr.arthursottile.doremix;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MusicaActivity extends AppCompatActivity {


    private ListView listViewMusica;
    private List<Musica> listaMusica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        setTitle(getString(R.string.setlist_exemplo));

        listViewMusica = findViewById(R.id.listViewMusica);
        popularListaMusica();


        MusicaAdapter adapter = new MusicaAdapter(this, listaMusica);
        listViewMusica.setAdapter(adapter);


        listViewMusica.setOnItemClickListener((parent, view, position, id) -> {
            Musica m = listaMusica.get(position);
            Toast.makeText(this, "Música selecionada: " + m.getTitulo() + " - " + m.getAutor(), Toast.LENGTH_SHORT).show();
        });
    }


    private void popularListaMusica() {
        String[] titulos = getResources().getStringArray(R.array.musica_Titulo);
        String[] autores = getResources().getStringArray(R.array.musica_Autor);
        String[] tons = getResources().getStringArray(R.array.musica_Tom);
        int[] duracoes = getResources().getIntArray(R.array.musica_Duracao);


        listaMusica = new ArrayList<>();
        int n = titulos.length; // arrays têm o mesmo tamanho
        for (int i = 0; i < n; i++) {
            listaMusica.add(new Musica(titulos[i], autores[i], tons[i], duracoes[i]));
        }
    }

    public void abreSobre(View view){

        Intent intentAbre = new Intent(this, SobreActivity.class);

        startActivity(intentAbre);

    }

    public void abrirNovaMusica(View view){

    }

}