package com.example.geng.yikaodemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geng.yikaodemo.com.melon.geng.DBhelper.MySQLiteHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    //定义对象
    private CheckBox checkBox;
    private EditText count;
    private EditText password;
    private Button login;
    //定义数据库
    private String UserName = "sa";
    private String Password = "89655086";
    //配置路径
    private String dbURL = "jdbc:jtds:sqlserver://172.18.165.69:1433;DatabaseName=YIKAO2";
    //请求码，用来识别设置ip和端口等配置返回的对象
    private int requestCode=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化对象
        count=(EditText)findViewById(R.id.judgeID);
        password=(EditText)findViewById(R.id.judgePwd);
        login=(Button)findViewById(R.id.login);
        //保存密码复选框
        checkBox=(CheckBox)findViewById(R.id.Save);
        //获取用户信息
        getAccount();
        //定义子线程，用来执行网络任务
        new Thread(new Runnable() {
            @Override
            public void run() {
                //当用户点击登录时触发该事件
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //获取用户输入的账号和密码
                        String jID=count.getText().toString();
                        String jPwd = password.getText().toString();
                        //判断用户是否选择了保存密码
                        if (checkBox.isChecked()){
                            //保存密码
                            File file=new File(getFilesDir(),"user.txt");
                            FileOutputStream fos=null;
                            try {
                                fos=new FileOutputStream(file);
                                String et_username=count.getText().toString();
                                String et_password=password.getText().toString();
                                //双#号用来分割用户输入的账号和密码
                                fos.write((et_username+"##"+et_password).getBytes());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }finally {
                                try {
                                    fos.close();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        if ("".equals(jID)&&"".equals(jPwd)){
                            Toast.makeText(MainActivity.this,"账号,密码不能为空",Toast.LENGTH_SHORT).show();
                        }//这里只要账号和密码相等就能登录成功
                        else if (jID.equals(jPwd)){
                            try{
                                //跳转到Mark.java
                                Intent intent=new Intent(getApplicationContext(),Mark.class);
                                Bundle bundle=new Bundle();
                                bundle.putString("username",UserName);
                                bundle.putString("password",Password);
                                bundle.putString("dbURL",dbURL);
                                bundle.putString("judgeId",jID);
                                intent.putExtra("info",bundle);
                                startActivity(intent);
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                        else Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
    // 重写了创建菜单的方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
//用来监听用户按下菜单键时触发的动作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()){
            item.setChecked(true);
        }
        switch (item.getItemId()) {
            case R.id.xph :
                Intent Xiongpaihao = new Intent(MainActivity.this, Xiongpaihao.class);
                startActivityForResult(Xiongpaihao,requestCode);
                break;
            case R.id.net:
                Intent net = new Intent(MainActivity.this, SetIPandPort.class);
                startActivityForResult(net,requestCode);
                break;
        }
        return true;
    }
    //重写该方法，用来接收用户修改的数据，例如ip地址以及数据库的用户名和密码
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int returnIP=1002;
        if (requestCode==0&&resultCode==returnIP){
            Bundle bundle=data.getBundleExtra("ipAndPort");
            String un=bundle.getString("username");
            String pwd=bundle.getString("password");
            String ip=bundle.getString("ip");
            String port=bundle.getString("port");
            UserName = un;
            Password = pwd;
            dbURL = "jdbc:jtds:sqlserver://"+ip+":"+port+";DatabaseName=YIKAO2";
        }
    }
    public void  getAccount() {
        //创建文件路径以及定义文件名
        File file=new File(getFilesDir(),"user.txt");
        //判断文件是否存在，若存在执行if
        if (file.exists()){
            try {
                //新建输入流
                FileInputStream fis=new FileInputStream(file);
                //读取文件user.txt内容
                BufferedReader br=new BufferedReader(new InputStreamReader(fis));
                String info=br.readLine();
                String []infoArray=info.split("##");
                count.setText(infoArray[0]);
                password.setText(infoArray[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
