package com.aplicativo_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaContatosActivity extends AppCompatActivity {

    private ListView lista_contatos;

    public String [] contatos = {
            "1","2","3","4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        lista_contatos = findViewById(R.id.lista_contatos);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.activity_list_item,
                android.R.id.text1, contatos
        );

        lista_contatos.setAdapter(adapter);
    }
}