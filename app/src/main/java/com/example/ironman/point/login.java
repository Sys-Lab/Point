package com.example.ironman.point;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ironman on 2015/11/4.
 */
public class login extends Activity {
    private EditText accountEdit,passwordEdit;
    private Button login,register;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        accountEdit=(EditText)findViewById(R.id.accountLogin);
        passwordEdit=(EditText)findViewById(R.id.passwordLogin);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String account = accountEdit.getText().toString();
               String password= passwordEdit.getText().toString();
                if(account.equals("aaaaaa")&&password.equals("123456")) {
                    Intent intent = new Intent(login.this, point.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(login.this,"账号或密码输入错误",Toast.LENGTH_LONG).show();
                }
            }
        });
        register=(Button)findViewById(R.id.register);
       //注册跳转
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });


    }}
