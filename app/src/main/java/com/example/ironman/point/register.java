package com.example.ironman.point;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Ironman on 2015/11/4.
 */
public class register extends Activity {
    private EditText edit1,edit2,edit3;
    Button registerButton;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        edit1=(EditText)findViewById(R.id.account);
        edit2=(EditText)findViewById(R.id.password);
        edit3=(EditText)findViewById(R.id.passwordAgain);
        registerButton=(Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=edit2.getText().toString();
                String b=edit3.getText().toString();
                //判断两次密码是否输入相同
                if(a.equals(b)){
                    Intent intent =new Intent(register.this,login.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(register.this,"两次密码不相同",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
