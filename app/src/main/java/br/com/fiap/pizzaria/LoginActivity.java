package br.com.fiap.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    TextInputLayout username;
    @BindView(R.id.password)
    TextInputLayout password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btConectar)
    public void conectar() {

        if (hasErrorInUsername() | hasErrorInPassword()) {
            return;
        }

        Intent intent = new Intent(this, PedidoActivity.class);
        intent.putExtra(Extras.EXTRA_USERNAME, username.getEditText().getText().toString());
        startActivity(intent);
        clear();
    }

    private boolean hasErrorInUsername() {
        if (TextUtils.isEmpty(username.getEditText().getText())) {
            username.setError("Login não informado");
            return true;
        }
        username.setError(null);
        return false;
    }

    private boolean hasErrorInPassword() {
        if (TextUtils.isEmpty(password.getEditText().getText())) {
            password.setError("Senha não informada");
            return true;
        }
        password.setError(null);
        return false;
    }

    private void clear() {
        username.getEditText().setText("");
        password.getEditText().setText("");
        username.getEditText().requestFocus();
    }
}
