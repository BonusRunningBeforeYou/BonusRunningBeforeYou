package com.example.janhon.bonusrunningbeforeyou.LoginRelated;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.janhon.bonusrunningbeforeyou.R;

public class ForgetActivity extends AppCompatActivity {
    private Button btSendOut;
    private EditText etSendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        handleViews();
    }

    private void handleViews() {
        btSendOut = findViewById(R.id.btSendEmail);
        etSendEmail = findViewById(R.id.etSendEmail);

        btSendOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
