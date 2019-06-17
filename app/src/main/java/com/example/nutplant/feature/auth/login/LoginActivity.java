package com.example.nutplant.feature.auth.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutplant.MainActivity;
import com.example.nutplant.R;
import com.example.nutplant.feature.auth.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity implements LoginContract.View {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvDaftar)
    TextView tvDaftar;

    private ProgressDialog dialog;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Login");
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
    }

    @Override
    public void login(boolean isSuccess, String meessages) {
        if(isSuccess){
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else Toast.makeText(this, meessages , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel(); //or u can use dismiss
    }

    @OnClick({R.id.btnLogin,R.id.tvDaftar})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                attachLogin(etEmail.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.tvDaftar:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    private void attachLogin(String email, String password) {
        String emailError = null;
        String passwordError = null;

        if (TextUtils.isEmpty(email))
            emailError = "Email cannot be empty";
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            emailError = "Email is invalid";

        if (password.length() < 6)
            passwordError = "Password consist min 6 characters";

        if (emailError == null && passwordError == null)
            presenter.login(email, password);
        else {
            etEmail.setError(emailError);
            etPassword.setError(passwordError);
        }
    }
}

