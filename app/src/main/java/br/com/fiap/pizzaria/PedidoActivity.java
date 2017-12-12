package br.com.fiap.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.fiap.pizzaria.model.Pedido;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class PedidoActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextView usernameTextView;

    @BindView(R.id.rgTamanho)
    RadioGroup rgTamanho;

    @BindView(R.id.spPagamento)
    Spinner spPagamento;

    @BindArray(R.array.pagamentos)
    String[] pagamentos;

    private Pedido pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            String username = getIntent().getStringExtra(Extras.EXTRA_USERNAME);
            usernameTextView.setText(String.format("Usuario: %s", username));

            pedido = new Pedido(username);

//            ckAtum.setOnCheckedChangeListener(onSaboresChange);
//            ckBacon.setOnCheckedChangeListener(onSaboresChange);
//            ckCalabresa.setOnCheckedChangeListener(onSaboresChange);
//            ckMussarela.setOnCheckedChangeListener(onSaboresChange);

//            rgTamanho.setOnCheckedChangeListener(onTamanhoChange);

//            spPagamento.setOnItemSelectedListener(onPagamentoClick);
        }
    }

    @OnCheckedChanged({
            R.id.ckAtum,
            R.id.ckBacon,
            R.id.ckCalabresa,
            R.id.ckMussarela})
    void onSaboresChange(CheckBox checkBox, boolean isChecked) {
        String sabor = checkBox.getText().toString();
        if (isChecked) {
            pedido.addSabor(sabor);
        } else {
            pedido.removeSabor(sabor);
        }
    }

//    private CompoundButton.OnCheckedChangeListener onSaboresChange = new CompoundButton.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            String sabor = buttonView.getText().toString();
//            if (isChecked) {
//                pedido.addSabor(sabor);
//            } else {
//                pedido.removeSabor(sabor);
//            }
//
//        }
//    };

//    private RadioGroup.OnCheckedChangeListener onTamanhoChange = new RadioGroup.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            RadioButton radioButton = (RadioButton) findViewById(checkedId);
//            pedido.setTamanho(radioButton.getText().toString());
//        }
//    };

    private String getTamanho() {
        int idRes = rgTamanho.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(idRes);
        return radioButton.getText().toString();
    }

//    private AdapterView.OnItemSelectedListener onPagamentoClick = new AdapterView.OnItemSelectedListener() {
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            String pagamento = pagamentos[position];
//            pedido.setFormaPegamento(pagamento);
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    };

    private String getPagamento() {
//        int position = spPagamento.getSelectedItemPosition();
//        return pagamentos[position];
        return spPagamento.getSelectedItem().toString();
    }

    @OnCheckedChanged({
            R.id.ckBordaRecheada,
            R.id.ckRefrigerante,
            R.id.ckSobremesa,
            R.id.ckReceioExtra})
    void onExtrasChange(CheckBox checkBox, boolean isChecked) {
        String extra = checkBox.getText().toString();
        if (isChecked) {
            pedido.addExtra(extra);
        } else {
            pedido.removeExtra(extra);
        }
    }

    @OnClick(R.id.btFecharPedido)
    public void fecharPedido() {

        pedido.setTamanho(getTamanho());
        pedido.setFormaPegamento(getPagamento());

        Intent intent = new Intent(this, ConfirmarPedidoActivity.class);
        intent.putExtra(Extras.EXTRA_PEDIDO, pedido);
        startActivity(intent);
    }
}
