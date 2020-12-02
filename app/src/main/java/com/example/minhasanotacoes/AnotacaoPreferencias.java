package com.example.minhasanotacoes;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "anotacao.txt";
    private final String CHAVE_TEXTO = "texto";

    public AnotacaoPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_TEXTO, anotacao);
        boolean confirmacao = editor.commit();

    }

    public String recuperaAnotacao(){
        String texto = preferences.getString(CHAVE_TEXTO, "");
        return texto;
    }
}
