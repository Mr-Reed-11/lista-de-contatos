package com.aplicativo_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class AdicionarContatoActivity extends AppCompatActivity {

    Button btn_adicionar_contato, btn_cacelar;

    TextInputEditText inp_nome, inp_telefone, inp_email, inp_endereco, inp_nascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_contato);
    }

    public void fechar_tela(View v){
        this.finish();
    }
}