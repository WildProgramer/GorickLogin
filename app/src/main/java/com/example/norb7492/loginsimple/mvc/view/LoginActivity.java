package com.example.norb7492.loginsimple.mvc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.norb7492.loginsimple.BaseActivity;
import com.example.norb7492.loginsimple.R;
import com.example.norb7492.loginsimple.mvc.controller.LoginController;




import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.editTextEmail)
    EditText editTextEmail;

    @BindView(R.id.editTextPassword)
    EditText getEditTextPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loginController = new LoginController(this);

    }


    @OnClick(R.id.btnLogin)
    public void loginSignInButton(View view){


        loginController.signInUser(editTextEmail, getEditTextPassword);





    }


}
