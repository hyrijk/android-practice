package com.example.peiming.a01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText idText = (EditText) findViewById(R.id.id);
        final EditText passwordText = (EditText) findViewById(R.id.password);
        final Button registerBtn = (Button) findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idText.getText().toString();
                String password = passwordText.getText().toString();
                if (!isIdValid(id)) {
                    Toast.makeText(getApplicationContext(), "id 太短，至少3个字符", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isPasswordValid(password)) {
                    Toast.makeText(getApplicationContext(), "密码太短，至少6个字符", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("password", password);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "注册成功，请登录", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean isIdValid(String id) {
        return id.length() >= 3;
    }

    private boolean isPasswordValid(String password) {
        return  password.length() >= 6;
    }
}
