package com.aplicativo_agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_adicionar;
    Button btn_listar;
    SQLiteDatabase banco = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_listar = findViewById(R.id.btn_listar);
        btn_adicionar = findViewById(R.id.btn_adicionar);

        abrirBanco();

        btn_listar.setOnClickListener(view -> {
            openContactsListActivity();
        });
        btn_adicionar.setOnClickListener(view -> {
            openAddContactActivity();
        });
    }

    /* Abre a tela de cadastro */
    public void openAddContactActivity() {
        Intent intent = new Intent(MainActivity.this, AdicionarContatoActivity.class);
        startActivity(intent);
    }

    /* Abre a lista de contatos */
    public void openContactsListActivity() {
        Intent intent = new Intent(MainActivity.this, ListaContatosActivity.class);
    }

    public void abrirBanco() {
        try {
            banco = openOrCreateDatabase("banco_contatos", MODE_PRIVATE, null);
        } catch (Exception ex) {
            msg("Erro na Criação ou Abertura do Banco de dados.");
        } finally {
            msg("Banco de dados aberto.");
        }
    }

    public void abrirFecharTabela() {
        try {
            banco.execSQL("CREATE TABLE IF NOT EXISTS contatos(id INTERGER PRIMARY KEY, nome TEXT, fone TEXT);");
        } catch (Exception ex) {
            msg("Erro ao criar Tabela!");
        } finally {
            msg("Tabela criada!");
        }
    }

    public void msg(String msg) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setMessage(msg);
        adb.setNeutralButton("OK", null);
        adb.show();
    }

}