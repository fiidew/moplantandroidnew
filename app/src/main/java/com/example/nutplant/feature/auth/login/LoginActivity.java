package com.example.nutplant.feature.auth.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutplant.R;
import com.example.nutplant.feature.auth.register.RegisterActivity;
import com.example.nutplant.feature.manage.ManageActivity;
import com.example.nutplant.utils.SessionManager;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.InstanceIdResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity implements LoginContract.View {

    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvDaftar)
    TextView tvDaftar;
    @BindView(R.id.et_username)
    EditText etUsername;

    private ProgressDialog dialog;
    private LoginPresenter presenter;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        presenter = new LoginPresenter(this,this);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Login");
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
    }

    @Override
    public void login(boolean isSuccess, String meessages) {
        if (isSuccess) {
            FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
                @Override
                public void onSuccess(InstanceIdResult instanceIdResult) {
                    String token = instanceIdResult.getToken();
                    Log.d("Token", "onSuccess: " + token);
                    presenter.updateToken(sessionManager.getToken(),sessionManager.getIdUser(),token);
                }
            });
        } else Toast.makeText(this, meessages, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isSuccessUpdateToken(boolean isSuccess, String meessages) {
        if (isSuccess)
        {
            Intent intent = new Intent(this, ManageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else
        {
            Toast.makeText(this, meessages, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoading(boolean show) {
        if (show) dialog.show();
        else dialog.cancel(); //or u can use dismiss
    }

    @OnClick({R.id.btnLogin, R.id.tvDaftar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                attachLogin(etUsername.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.tvDaftar:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    private void attachLogin(String username, String password) {
        String usernameError = null;
        String passwordError = null;

        if (TextUtils.isEmpty(username))
            usernameError = "Email cannot be empty";

        if (password.length() < 6)
            passwordError = "Password consist min 6 characters";

        if (usernameError == null && passwordError == null)
            presenter.login(username, password);
        else {
            etUsername.setError(usernameError);
            etPassword.setError(passwordError);
        }
    }
}

