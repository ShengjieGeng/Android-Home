package com.example.geng.yikaodemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by geng on 2016/8/25.
 */
public class SetIPandPort extends Activity {
    private EditText ip;
    private EditText port;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setipandport);
        ip= (EditText) findViewById(R.id.IP);
        port= (EditText) findViewById(R.id.port);
        username= (EditText) findViewById(R.id.UserName);
        password= (EditText) findViewById(R.id.SqlServerPassword);
    }
    public void onClick(View view){
        int returnIP=1002;
        Intent intent= new Intent();
        Bundle bundle=new Bundle();
        bundle.putString("ip",ip.getText().toString());
        bundle.putString("port",port.getText().toString());
        bundle.putString("username",username.getText().toString());
        bundle.putString("password",password.getText().toString());
        intent.putExtra("ipAndPort",bundle);
        setResult(returnIP,intent);
        finish();
    }
}
