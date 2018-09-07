package com.example.janhon.bonusrunningbeforeyou.LoginRelated;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.example.janhon.bonusrunningbeforeyou.R;
import com.example.janhon.bonusrunningbeforeyou.Running.RunningActivity;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText etEmail, etPassword;
    private Button btLogin, btWantRegister, btForgetPassword, btFBLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        handleViews();
    }

    private void handleViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
        btWantRegister = findViewById(R.id.btWantRegister);
        btForgetPassword = findViewById(R.id.btForgetPassword);
        btFBLogin = findViewById(R.id.btFBLogin);

        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(),RunningActivity.class));
        }

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btWantRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });


        btFBLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RunningActivity.class);
                startActivity(intent);
            }
        });

    }

    public void login() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        Log.d("AUTH", email + "/" + password);
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("onComplete", "onComplete");
                if(task.isSuccessful()){
                    //start profile activity
                    startActivity(new Intent(getApplicationContext(),RunningActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,"Incorrect username or password.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 8;
    }


    public void onLoginClick(View view) {
    }


    public void onForgetPasswordClick(View view) {
    }

}