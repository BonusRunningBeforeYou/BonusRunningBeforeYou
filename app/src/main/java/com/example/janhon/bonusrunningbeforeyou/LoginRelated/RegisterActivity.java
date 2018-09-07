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

import com.example.janhon.bonusrunningbeforeyou.R;
import com.example.janhon.bonusrunningbeforeyou.Running.RunningActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText etSetEmail, etSetPassword, etConfirmPassword;
    private Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        handleViews();
    }

    private void handleViews() {
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(RegisterActivity.this,RunningActivity.class);
            finish();
        }

        etSetEmail = findViewById(R.id.etRegisterEmail);
        etSetPassword = findViewById(R.id.etRegisterPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btRegister = findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }

    private void registerUser() {
        String email = etSetEmail.getText().toString().trim() ;
        String password = etSetPassword.getText().toString().trim();
        String confirmpassword = etConfirmPassword.getText().toString().trim();
        Log.i("Test", confirmpassword);
        Log.i("Test", password);
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

        if(!password.equalsIgnoreCase(confirmpassword)){
            Toast.makeText(this,"Password not correct", Toast.LENGTH_LONG).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(getApplicationContext(),RunningActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    FirebaseAuthException e = (FirebaseAuthException)task.getException();
                    Toast.makeText(RegisterActivity.this, "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();
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

}