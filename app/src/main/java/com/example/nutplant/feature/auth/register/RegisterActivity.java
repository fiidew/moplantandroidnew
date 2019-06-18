package com.example.nutplant.feature.auth.register;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutplant.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends Activity implements RegisterContract.View {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tvMasuk)
    TextView tvMasuk;
    RegisterContract.Presenter presenter;
    ProgressDialog dialog;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_alamat)
    EditText etAlamat;
    @BindView(R.id.et_telfon)
    EditText etTelfon;
    @BindView(R.id.btnRegister)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter = new RegisterPresenter(this);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.setTitle("Register");
    }

    @OnClick(R.id.btnRegister)
    public void onViewClicked() {
        attachRegister(etUsername.getText().toString() , etAlamat.getText().toString(), etTelfon.getText().toString() ,etName.getText().toString(), etPassword.getText().toString());
    }

    private void attachRegister(String username, String alamat, String telfon, String nama, String password) {
        String namaError = null;
        String passwordError = null;
        String alamatError = null;
        String telfonError = null;
        String usernameError = null;


        if (TextUtils.isEmpty(nama))
            namaError = "Name cannot be empty";

        if (TextUtils.isEmpty(telfon))
            telfonError = "Telephone cannot be empty";

        if (TextUtils.isEmpty(alamat))
            namaError = "Alamat cannot be empty";

        if (TextUtils.isEmpty(username))
            usernameError = "Username gaboleh kosong dong";

        if (password.length() < 6)
            passwordError = "Password min 6 character";

        if (usernameError == null && passwordError == null && namaError == null && alamatError == null && passwordError == null && telfonError == null)
            presenter.register(nama, password, alamat, telfon, username);
        else {
            etName.setError(namaError);
            etPassword.setError(passwordError);
            etAlamat.setError(alamatError);
            etTelfon.setError(telfonError);
            etUsername.setError(usernameError);

        }
    }

    @Override
    public void register(boolean isSucces, String message) {
        if (isSucces) {
            finish();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel(); //or u can use dismiss
    }
}
