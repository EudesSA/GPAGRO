package com.example.gpagro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        // Desativa nome do Aplicativo no Topo.
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Mostrar icone no lugar de Texto.
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Define qual icone vai aparecer.
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mViewHolder.buttonTelaLancamentoCusto = findViewById(R.id.bt_Tela_lacamento_Custo);
        this.mViewHolder.buttonTelaLancamentoCusto.setOnClickListener(this);
        this.mViewHolder.buttonTelaLancamentoProducao = findViewById(R.id.bt_Tela_Lancamento_Producao);
        this.mViewHolder.buttonTelaLancamentoProducao.setOnClickListener(this);
        this.mViewHolder.buttonTelaCustoProducao = findViewById(R.id.bt_Tela_Custo_x_Producao);
        this.mViewHolder.buttonTelaCustoProducao.setOnClickListener(this);
        this.mViewHolder.buttonTelaCustoTotal = findViewById(R.id.bt_Tela_CustoTotal);
        this.mViewHolder.buttonTelaCustoTotal.setOnClickListener(this);
        this.mViewHolder.buttonTelaProducaoTotal = findViewById(R.id.bt_Tela_ProducaoTotal);
        this.mViewHolder.buttonTelaProducaoTotal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.bt_Tela_lacamento_Custo) {
            //Logica do Botão
            Intent intent = new Intent(this, LancamentoCusto.class);
            startActivity(intent);
        } else if (id == R.id.bt_Tela_Lancamento_Producao) {
            //Logica do Botão
            Intent intent = new Intent(this, LancamentoProducao.class);
            startActivity(intent);
        } else if (id == R.id.bt_Tela_Custo_x_Producao) {
            //Logica do Botão
            Intent intent = new Intent(this, CustoProducao.class);
            startActivity(intent);
        } else if (id == R.id.bt_Tela_CustoTotal) {
            //Logica do Botão
            Intent intent = new Intent(this, CustoTotal.class);
            startActivity(intent);
        } else if (id == R.id.bt_Tela_ProducaoTotal) {
            //Logica do Botão
            Intent intent = new Intent(this, ProducaoTotal.class);
            startActivity(intent);
        }
    }

    private static class ViewHolder {
        Button buttonTelaLancamentoCusto;
        Button buttonTelaLancamentoProducao;
        Button buttonTelaCustoProducao;
        Button buttonTelaCustoTotal;
        Button buttonTelaProducaoTotal;
    }
}
