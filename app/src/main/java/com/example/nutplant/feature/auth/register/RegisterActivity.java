package com.example.nutplant.feature.auth.register;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutplant.MainActivity;
import com.example.nutplant.R;
import com.example.nutplant.feature.auth.login.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends Activity implements RegisterContract.View {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tvMasuk)
    TextView tvMasuk;
    RegisterContract.Presenter presenter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter = new  RegisterPresenter(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.setTitle("Register");
    }

    @OnClick(R.id.btnRegister)
    public void onViewClicked() {
        attachRegister(etName.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());
    }

    private void attachRegister(String nama, String email, String password) {
        String namaError = null;
        String emailError = null;
        String passwordError = null;

        if (TextUtils.isEmpty(nama))
            namaError = "Name cannot be empty";

        if (TextUtils.isEmpty(email))
            emailError = "Email gaboleh kosong dong";
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            emailError = "Email invalid";

        if (password.length() < 6)
            passwordError= "Password min 6 character";

        if (emailError == null && passwordError == null)
            presenter.register(nama, email, password);
        else{
            etName.setError(namaError);
            etEmail.setError(emailError);
            etPassword.setError(passwordError);
        }
    }

    @Override
    public void register(boolean isSucces, String message) {
        if(isSucces){
            finish();
        }Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel(); //or u can use dismiss
    }
}
