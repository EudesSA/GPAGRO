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


public class LancamentoCusto extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();

    DatePicker dpdata_Validade;
    DatePicker dpdata_Pagamento;
    EditText editData_Validade;
    EditText editData_Pagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento_custo);

        Spinner dropdown = findViewById(R.id.list_itemTipoProducao);

        String[] items = new String[]{
                " ","Pecuária - leite","Pecuária - gado de corte", "Plantação de hortaliças",
                "Suinocultura", "Piscicultura", "Caprinocultura"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);


        this.mViewHolder.buttonSalvar = findViewById(R.id.bt_Salvar_Lancamento_Custo);
        this.mViewHolder.buttonSalvar.setOnClickListener(this);
        this.mViewHolder.buttonLimpar = findViewById(R.id.bt_Limpar_Lancamento_Custo);
        this.mViewHolder.buttonLimpar.setOnClickListener(this);


        editData_Validade = findViewById(R.id.editData_Validade);
        editData_Pagamento = findViewById(R.id.editData_Pagamento);
        dpdata_Validade = findViewById(R.id.DP_data_Validade);
        dpdata_Pagamento = findViewById(R.id.DP_data_Pagamento);

        editData_Validade.setText(dpdata_Validade.getDayOfMonth()+"/"+ (dpdata_Validade.getMonth() + 1)+"/"+ dpdata_Validade.getYear());
        editData_Pagamento.setText(dpdata_Pagamento.getDayOfMonth()+"/"+ (dpdata_Pagamento.getMonth() + 1)+"/"+ dpdata_Pagamento.getYear());

        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int ano = c.get(Calendar.DAY_OF_MONTH);

        // set current date into datepicker
        dpdata_Validade.init(dia, mes, ano, null);
        dpdata_Pagamento.init(dia, mes, ano, null);

        editData_Validade.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    dpdata_Validade.setVisibility(View.VISIBLE);

                }else{
                    dpdata_Validade.setVisibility(View.INVISIBLE);
                    editData_Validade.setText(dpdata_Validade.getDayOfMonth()+"/"+ (dpdata_Validade.getMonth() + 1)+"/"+ dpdata_Validade.getYear());
                }

            }
        });
        editData_Pagamento.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    dpdata_Pagamento.setVisibility(View.VISIBLE);

                }else{
                    dpdata_Pagamento.setVisibility(View.INVISIBLE);
                    editData_Pagamento.setText(dpdata_Pagamento.getDayOfMonth()+"/"+ (dpdata_Pagamento.getMonth() + 1)+"/"+ dpdata_Pagamento.getYear());
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
