package com.example.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText anotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anotacao = findViewById(R.id.editTextAnotacao);

        preferencias = new AnotacaoPreferencias(getApplicationContext());



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validar se possui texto
                String textoAnotacao = anotacao.getText().toString();
                if(textoAnotacao.equals("")){
                    Snackbar.make(view, "Preencha anotaçao!", Snackbar.LENGTH_LONG).show();
                }else{
                    preferencias.salvarAnotacao(textoAnotacao);
                    Snackbar.make(view, "Anotaçao salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }



        });

        String texto = preferencias.recuperaAnotacao();
        if(!texto.equals("")){
            anotacao.setText(texto);
        }
    }

}
