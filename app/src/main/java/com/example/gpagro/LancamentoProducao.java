package com.example.gpagro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class LancamentoProducao extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();

    DatePicker dpdata_Lancamento;
    EditText editData_Lancamento;
    EditText edit_valorUnitario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento_producao);

        edit_valorUnitario = findViewById(R.id.editValorUnitario);
        edit_valorUnitario.requestFocus();

        Spinner dropdown = findViewById(R.id.list_itemTipoProducao);

        String[] items = new String[]{
                " ", "Pecuária - leite", "Pecuária - gado de corte", "Plantação de hortaliças",
                "Suinocultura", "Piscicultura", "Caprinocultura"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);


        this.mViewHolder.buttonSalvar = findViewById(R.id.bt_Salvar_Lancamento_Producao);
        this.mViewHolder.buttonSalvar.setOnClickListener(this);
        this.mViewHolder.buttonLimpar = findViewById(R.id.bt_Limpar_Lancamento_Producao);
        this.mViewHolder.buttonLimpar.setOnClickListener(this);

        editData_Lancamento = findViewById(R.id.editData_Lancamento_Producao);

        dpdata_Lancamento = findViewById(R.id.DP_data_Lancamento_Producao);

        editData_Lancamento.setText(dpdata_Lancamento.getDayOfMonth() + "/" + (dpdata_Lancamento.getMonth() + 1) + "/" + dpdata_Lancamento.getYear());

        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int ano = c.get(Calendar.DAY_OF_MONTH);

        // set current date into datepicker
        dpdata_Lancamento.init(dia, mes, ano, null);

        editData_Lancamento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    dpdata_Lancamento.setVisibility(View.VISIBLE);

                } else {
                    dpdata_Lancamento.setVisibility(View.INVISIBLE);
                    editData_Lancamento.setText(dpdata_Lancamento.getDayOfMonth() + "/" + (dpdata_Lancamento.getMonth() + 1) + "/" + dpdata_Lancamento.getYear());
                }

            }
        });

    }

    @Override
    public void onClick(View v) {


    }

    private static class ViewHolder {
        Button buttonSalvar;
        Button buttonLimpar;
    }


}
