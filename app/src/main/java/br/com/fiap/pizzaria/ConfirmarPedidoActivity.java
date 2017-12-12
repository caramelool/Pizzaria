package br.com.fiap.pizzaria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.fiap.pizzaria.model.Pedido;

public class ConfirmarPedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);

        if (getIntent() != null) {
            Pedido pedido = getIntent().getParcelableExtra(Extras.EXTRA_PEDIDO);
        }
    }
}
