package com.example.peiming.a01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button button = (Button) findViewById(R.id.login_btn);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                EditText idText= (EditText)findViewById(R.id.login_id);
                EditText passwordText = (EditText) findViewById(R.id.login_password);
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

                Intent intent = getIntent();
                String realId = intent.getStringExtra("id");
                String realPassword = intent.getStringExtra("password");
                if (!realId.equals(id)) {
                    Toast.makeText(getApplicationContext(), "id不存在", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!realPassword.equals(password)) {
                    Toast.makeText(getApplicationContext(), "密码不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), "登录成功，欢迎你，" + id, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


    private boolean isIdValid(String id) {
        return id.length() >= 3;
    }

    private boolean isPasswordValid(String password) {
        return  password.length() >= 6;
    }
}
