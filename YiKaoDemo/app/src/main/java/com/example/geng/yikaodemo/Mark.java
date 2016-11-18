package com.example.geng.yikaodemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mark extends Activity {
    private int button_tag;//用一个整型tag用来标示用户按下的提交键
    private Button totalSubmit;//总提交
    //下面十个是提交按钮
    private Button line1;
    private Button line2;
    private Button line3;
    private Button line4;
    private Button line5;
    private Button line6;
    private Button line7;
    private Button line8;
    private Button line9;
    private Button line10;
    //下拉列表对象
    private Spinner spinner;
    //获取下一组的胸牌号
    private Button next;
    //定义单选按钮对象
    private RadioGroup subGroup;
    //给每个专业的考场定义一个帧布局
    private FrameLayout FM_fzby1;
    private FrameLayout FM_fzby2;
    private FrameLayout FM_jmc1;
    private FrameLayout FM_jmc2;
    private FrameLayout FM_llc1;
    private FrameLayout FM_llc2;
    private FrameLayout FM_lxw1;
    private FrameLayout FM_lxw2;
    private FrameLayout FM_tywd1;
    private FrameLayout FM_tywd2;
    private FrameLayout FM_wdbd1;
    private FrameLayout FM_wdbd2;
    private FrameLayout FM_zgw1;
    private FrameLayout FM_zgw2;
    //定义一个线性布局
    private LinearLayout ll_court;
    //服装表演第一小组
    private EditText fzby_1_00;
    private EditText fzby_1_01;
    private EditText fzby_1_10;
    private EditText fzby_1_11;
    private EditText fzby_1_20;
    private EditText fzby_1_21;
    private EditText fzby_1_30;
    private EditText fzby_1_31;
    private EditText fzby_1_40;
    private EditText fzby_1_41;
    private EditText fzby_1_50;
    private EditText fzby_1_51;
    private EditText fzby_1_60;
    private EditText fzby_1_61;
    private EditText fzby_1_70;
    private EditText fzby_1_71;
    private EditText fzby_1_80;
    private EditText fzby_1_81;
    private EditText fzby_1_90;
    private EditText fzby_1_91;
    //服装表演第二小组
    private EditText fzby_2_00;
    private EditText fzby_2_01;
    private EditText fzby_2_10;
    private EditText fzby_2_11;
    private EditText fzby_2_20;
    private EditText fzby_2_21;
    private EditText fzby_2_30;
    private EditText fzby_2_31;
    private EditText fzby_2_40;
    private EditText fzby_2_41;
    private EditText fzby_2_50;
    private EditText fzby_2_51;
    private EditText fzby_2_60;
    private EditText fzby_2_61;
    private EditText fzby_2_70;
    private EditText fzby_2_71;
    private EditText fzby_2_80;
    private EditText fzby_2_81;
    private EditText fzby_2_90;
    private EditText fzby_2_91;
    //健美操第一小组
    private EditText jmc_1_00;
    private EditText jmc_1_01;
    private EditText jmc_1_02;
    private EditText jmc_1_03;
    private EditText jmc_1_10;
    private EditText jmc_1_11;
    private EditText jmc_1_12;
    private EditText jmc_1_13;
    private EditText jmc_1_20;
    private EditText jmc_1_21;
    private EditText jmc_1_22;
    private EditText jmc_1_23;
    private EditText jmc_1_30;
    private EditText jmc_1_31;
    private EditText jmc_1_32;
    private EditText jmc_1_33;
    private EditText jmc_1_40;
    private EditText jmc_1_41;
    private EditText jmc_1_42;
    private EditText jmc_1_43;
    private EditText jmc_1_50;
    private EditText jmc_1_51;
    private EditText jmc_1_52;
    private EditText jmc_1_53;
    private EditText jmc_1_60;
    private EditText jmc_1_61;
    private EditText jmc_1_62;
    private EditText jmc_1_63;
    private EditText jmc_1_70;
    private EditText jmc_1_71;
    private EditText jmc_1_72;
    private EditText jmc_1_73;
    private EditText jmc_1_80;
    private EditText jmc_1_81;
    private EditText jmc_1_82;
    private EditText jmc_1_83;
    private EditText jmc_1_90;
    private EditText jmc_1_91;
    private EditText jmc_1_92;
    private EditText jmc_1_93;
    //健美操第二小组
    private EditText jmc_2_00;
    private EditText jmc_2_10;
    private EditText jmc_2_20;
    private EditText jmc_2_30;
    private EditText jmc_2_40;
    private EditText jmc_2_50;
    private EditText jmc_2_60;
    private EditText jmc_2_70;
    private EditText jmc_2_80;
    private EditText jmc_2_90;
    //啦啦操第一小组
    private EditText llc_1_00;
    private EditText llc_1_01;
    private EditText llc_1_10;
    private EditText llc_1_11;
    private EditText llc_1_20;
    private EditText llc_1_21;
    private EditText llc_1_30;
    private EditText llc_1_31;
    private EditText llc_1_40;
    private EditText llc_1_41;
    private EditText llc_1_50;
    private EditText llc_1_51;
    private EditText llc_1_60;
    private EditText llc_1_61;
    private EditText llc_1_70;
    private EditText llc_1_71;
    private EditText llc_1_80;
    private EditText llc_1_81;
    private EditText llc_1_90;
    private EditText llc_1_91;
    //啦啦操第二小组
    private EditText llc_2_00;
    private EditText llc_2_10;
    private EditText llc_2_20;
    private EditText llc_2_30;
    private EditText llc_2_40;
    private EditText llc_2_50;
    private EditText llc_2_60;
    private EditText llc_2_70;
    private EditText llc_2_80;
    private EditText llc_2_90;
    //流行舞第一小组
    private EditText lxw_1_00;
    private EditText lxw_1_01;
    private EditText lxw_1_02;
    private EditText lxw_1_03;
    private EditText lxw_1_04;
    private EditText lxw_1_05;
    private EditText lxw_1_10;
    private EditText lxw_1_11;
    private EditText lxw_1_12;
    private EditText lxw_1_13;
    private EditText lxw_1_14;
    private EditText lxw_1_15;
    private EditText lxw_1_20;
    private EditText lxw_1_21;
    private EditText lxw_1_22;
    private EditText lxw_1_23;
    private EditText lxw_1_24;
    private EditText lxw_1_25;
    private EditText lxw_1_30;
    private EditText lxw_1_31;
    private EditText lxw_1_32;
    private EditText lxw_1_33;
    private EditText lxw_1_34;
    private EditText lxw_1_35;
    private EditText lxw_1_40;
    private EditText lxw_1_41;
    private EditText lxw_1_42;
    private EditText lxw_1_43;
    private EditText lxw_1_44;
    private EditText lxw_1_45;
    private EditText lxw_1_50;
    private EditText lxw_1_51;
    private EditText lxw_1_52;
    private EditText lxw_1_53;
    private EditText lxw_1_54;
    private EditText lxw_1_55;
    private EditText lxw_1_60;
    private EditText lxw_1_61;
    private EditText lxw_1_62;
    private EditText lxw_1_63;
    private EditText lxw_1_64;
    private EditText lxw_1_65;
    private EditText lxw_1_70;
    private EditText lxw_1_71;
    private EditText lxw_1_72;
    private EditText lxw_1_73;
    private EditText lxw_1_74;
    private EditText lxw_1_75;
    private EditText lxw_1_80;
    private EditText lxw_1_81;
    private EditText lxw_1_82;
    private EditText lxw_1_83;
    private EditText lxw_1_84;
    private EditText lxw_1_85;
    private EditText lxw_1_90;
    private EditText lxw_1_91;
    private EditText lxw_1_92;
    private EditText lxw_1_93;
    private EditText lxw_1_94;
    private EditText lxw_1_95;
    //流行舞第二小组
    private EditText lxw_2_00;
    private EditText lxw_2_01;
    private EditText lxw_2_10;
    private EditText lxw_2_11;
    private EditText lxw_2_20;
    private EditText lxw_2_21;
    private EditText lxw_2_30;
    private EditText lxw_2_31;
    private EditText lxw_2_40;
    private EditText lxw_2_41;
    private EditText lxw_2_50;
    private EditText lxw_2_51;
    private EditText lxw_2_60;
    private EditText lxw_2_61;
    private EditText lxw_2_70;
    private EditText lxw_2_71;
    private EditText lxw_2_80;
    private EditText lxw_2_81;
    private EditText lxw_2_90;
    private EditText lxw_2_91;
    //体育舞蹈第一小组
    private EditText tywd_1_00;
    private EditText tywd_1_01;
    private EditText tywd_1_02;
    private EditText tywd_1_03;
    private EditText tywd_1_10;
    private EditText tywd_1_11;
    private EditText tywd_1_12;
    private EditText tywd_1_13;
    private EditText tywd_1_20;
    private EditText tywd_1_21;
    private EditText tywd_1_22;
    private EditText tywd_1_23;
    private EditText tywd_1_30;
    private EditText tywd_1_31;
    private EditText tywd_1_32;
    private EditText tywd_1_33;
    private EditText tywd_1_40;
    private EditText tywd_1_41;
    private EditText tywd_1_42;
    private EditText tywd_1_43;
    private EditText tywd_1_50;
    private EditText tywd_1_51;
    private EditText tywd_1_52;
    private EditText tywd_1_53;
    private EditText tywd_1_60;
    private EditText tywd_1_61;
    private EditText tywd_1_62;
    private EditText tywd_1_63;
    private EditText tywd_1_70;
    private EditText tywd_1_71;
    private EditText tywd_1_72;
    private EditText tywd_1_73;
    private EditText tywd_1_80;
    private EditText tywd_1_81;
    private EditText tywd_1_82;
    private EditText tywd_1_83;
    private EditText tywd_1_90;
    private EditText tywd_1_91;
    private EditText tywd_1_92;
    private EditText tywd_1_93;
    //体育舞蹈第二小组
    private EditText tywd_2_00;
    private EditText tywd_2_01;
    private EditText tywd_2_10;
    private EditText tywd_2_11;
    private EditText tywd_2_20;
    private EditText tywd_2_21;
    private EditText tywd_2_30;
    private EditText tywd_2_31;
    private EditText tywd_2_40;
    private EditText tywd_2_41;
    private EditText tywd_2_50;
    private EditText tywd_2_51;
    private EditText tywd_2_60;
    private EditText tywd_2_61;
    private EditText tywd_2_70;
    private EditText tywd_2_71;
    private EditText tywd_2_80;
    private EditText tywd_2_81;
    private EditText tywd_2_90;
    private EditText tywd_2_91;
    //舞蹈编导第一小组
    private EditText wdbd_1_00;
    private EditText wdbd_1_01;
    private EditText wdbd_1_02;
    private EditText wdbd_1_03;
    private EditText wdbd_1_04;
    private EditText wdbd_1_05;
    private EditText wdbd_1_10;
    private EditText wdbd_1_11;
    private EditText wdbd_1_12;
    private EditText wdbd_1_13;
    private EditText wdbd_1_14;
    private EditText wdbd_1_15;
    private EditText wdbd_1_20;
    private EditText wdbd_1_21;
    private EditText wdbd_1_22;
    private EditText wdbd_1_23;
    private EditText wdbd_1_24;
    private EditText wdbd_1_25;
    private EditText wdbd_1_30;
    private EditText wdbd_1_31;
    private EditText wdbd_1_32;
    private EditText wdbd_1_33;
    private EditText wdbd_1_34;
    private EditText wdbd_1_35;
    private EditText wdbd_1_40;
    private EditText wdbd_1_41;
    private EditText wdbd_1_42;
    private EditText wdbd_1_43;
    private EditText wdbd_1_44;
    private EditText wdbd_1_45;
    private EditText wdbd_1_50;
    private EditText wdbd_1_51;
    private EditText wdbd_1_52;
    private EditText wdbd_1_53;
    private EditText wdbd_1_54;
    private EditText wdbd_1_55;
    private EditText wdbd_1_60;
    private EditText wdbd_1_61;
    private EditText wdbd_1_62;
    private EditText wdbd_1_63;
    private EditText wdbd_1_64;
    private EditText wdbd_1_65;
    private EditText wdbd_1_70;
    private EditText wdbd_1_71;
    private EditText wdbd_1_72;
    private EditText wdbd_1_73;
    private EditText wdbd_1_74;
    private EditText wdbd_1_75;
    private EditText wdbd_1_80;
    private EditText wdbd_1_81;
    private EditText wdbd_1_82;
    private EditText wdbd_1_83;
    private EditText wdbd_1_84;
    private EditText wdbd_1_85;
    private EditText wdbd_1_90;
    private EditText wdbd_1_91;
    private EditText wdbd_1_92;
    private EditText wdbd_1_93;
    private EditText wdbd_1_94;
    private EditText wdbd_1_95;
    //舞蹈编导第二小组
    private EditText wdbd_2_00;
    private EditText wdbd_2_01;
    private EditText wdbd_2_10;
    private EditText wdbd_2_11;
    private EditText wdbd_2_20;
    private EditText wdbd_2_21;
    private EditText wdbd_2_30;
    private EditText wdbd_2_31;
    private EditText wdbd_2_40;
    private EditText wdbd_2_41;
    private EditText wdbd_2_50;
    private EditText wdbd_2_51;
    private EditText wdbd_2_60;
    private EditText wdbd_2_61;
    private EditText wdbd_2_70;
    private EditText wdbd_2_71;
    private EditText wdbd_2_80;
    private EditText wdbd_2_81;
    private EditText wdbd_2_90;
    private EditText wdbd_2_91;
    //中国舞第一小组
    private EditText zgw_1_00;
    private EditText zgw_1_01;
    private EditText zgw_1_02;
    private EditText zgw_1_03;
    private EditText zgw_1_04;
    private EditText zgw_1_05;
    private EditText zgw_1_10;
    private EditText zgw_1_11;
    private EditText zgw_1_12;
    private EditText zgw_1_13;
    private EditText zgw_1_14;
    private EditText zgw_1_15;
    private EditText zgw_1_20;
    private EditText zgw_1_21;
    private EditText zgw_1_22;
    private EditText zgw_1_23;
    private EditText zgw_1_24;
    private EditText zgw_1_25;
    private EditText zgw_1_30;
    private EditText zgw_1_31;
    private EditText zgw_1_32;
    private EditText zgw_1_33;
    private EditText zgw_1_34;
    private EditText zgw_1_35;
    private EditText zgw_1_40;
    private EditText zgw_1_41;
    private EditText zgw_1_42;
    private EditText zgw_1_43;
    private EditText zgw_1_44;
    private EditText zgw_1_45;
    private EditText zgw_1_50;
    private EditText zgw_1_51;
    private EditText zgw_1_52;
    private EditText zgw_1_53;
    private EditText zgw_1_54;
    private EditText zgw_1_55;
    private EditText zgw_1_60;
    private EditText zgw_1_61;
    private EditText zgw_1_62;
    private EditText zgw_1_63;
    private EditText zgw_1_64;
    private EditText zgw_1_65;
    private EditText zgw_1_70;
    private EditText zgw_1_71;
    private EditText zgw_1_72;
    private EditText zgw_1_73;
    private EditText zgw_1_74;
    private EditText zgw_1_75;
    private EditText zgw_1_80;
    private EditText zgw_1_81;
    private EditText zgw_1_82;
    private EditText zgw_1_83;
    private EditText zgw_1_84;
    private EditText zgw_1_85;
    private EditText zgw_1_90;
    private EditText zgw_1_91;
    private EditText zgw_1_92;
    private EditText zgw_1_93;
    private EditText zgw_1_94;
    private EditText zgw_1_95;
    //中国舞第二小组
    private EditText zgw_2_00;
    private EditText zgw_2_01;
    private EditText zgw_2_10;
    private EditText zgw_2_11;
    private EditText zgw_2_20;
    private EditText zgw_2_21;
    private EditText zgw_2_30;
    private EditText zgw_2_31;
    private EditText zgw_2_40;
    private EditText zgw_2_41;
    private EditText zgw_2_50;
    private EditText zgw_2_51;
    private EditText zgw_2_60;
    private EditText zgw_2_61;
    private EditText zgw_2_70;
    private EditText zgw_2_71;
    private EditText zgw_2_80;
    private EditText zgw_2_81;
    private EditText zgw_2_90;
    private EditText zgw_2_91;
    //服装表演胸牌号
    private TextView fzby1_x1;
    private TextView fzby1_x2;
    private TextView fzby1_x3;
    private TextView fzby1_x4;
    private TextView fzby1_x5;
    private TextView fzby1_x6;
    private TextView fzby1_x7;
    private TextView fzby1_x8;
    private TextView fzby1_x9;
    private TextView fzby1_x10;
    private TextView fzby2_x1;
    private TextView fzby2_x2;
    private TextView fzby2_x3;
    private TextView fzby2_x4;
    private TextView fzby2_x5;
    private TextView fzby2_x6;
    private TextView fzby2_x7;
    private TextView fzby2_x8;
    private TextView fzby2_x9;
    private TextView fzby2_x10;
    //健美操胸牌号
    private TextView jmc1_x1;
    private TextView jmc1_x2;
    private TextView jmc1_x3;
    private TextView jmc1_x4;
    private TextView jmc1_x5;
    private TextView jmc1_x6;
    private TextView jmc1_x7;
    private TextView jmc1_x8;
    private TextView jmc1_x9;
    private TextView jmc1_x10;
    private TextView jmc2_x1;
    private TextView jmc2_x2;
    private TextView jmc2_x3;
    private TextView jmc2_x4;
    private TextView jmc2_x5;
    private TextView jmc2_x6;
    private TextView jmc2_x7;
    private TextView jmc2_x8;
    private TextView jmc2_x9;
    private TextView jmc2_x10;
    //啦啦操胸牌号
    private TextView llc1_x1;
    private TextView llc1_x2;
    private TextView llc1_x3;
    private TextView llc1_x4;
    private TextView llc1_x5;
    private TextView llc1_x6;
    private TextView llc1_x7;
    private TextView llc1_x8;
    private TextView llc1_x9;
    private TextView llc1_x10;
    private TextView llc2_x1;
    private TextView llc2_x2;
    private TextView llc2_x3;
    private TextView llc2_x4;
    private TextView llc2_x5;
    private TextView llc2_x6;
    private TextView llc2_x7;
    private TextView llc2_x8;
    private TextView llc2_x9;
    private TextView llc2_x10;
    //流行舞胸牌号
    private TextView lxw1_x1;
    private TextView lxw1_x2;
    private TextView lxw1_x3;
    private TextView lxw1_x4;
    private TextView lxw1_x5;
    private TextView lxw1_x6;
    private TextView lxw1_x7;
    private TextView lxw1_x8;
    private TextView lxw1_x9;
    private TextView lxw1_x10;
    private TextView lxw2_x1;
    private TextView lxw2_x2;
    private TextView lxw2_x3;
    private TextView lxw2_x4;
    private TextView lxw2_x5;
    private TextView lxw2_x6;
    private TextView lxw2_x7;
    private TextView lxw2_x8;
    private TextView lxw2_x9;
    private TextView lxw2_x10;
    //体育舞蹈胸牌号
    private TextView tywd1_x1;
    private TextView tywd1_x2;
    private TextView tywd1_x3;
    private TextView tywd1_x4;
    private TextView tywd1_x5;
    private TextView tywd1_x6;
    private TextView tywd1_x7;
    private TextView tywd1_x8;
    private TextView tywd1_x9;
    private TextView tywd1_x10;
    private TextView tywd2_x1;
    private TextView tywd2_x2;
    private TextView tywd2_x3;
    private TextView tywd2_x4;
    private TextView tywd2_x5;
    private TextView tywd2_x6;
    private TextView tywd2_x7;
    private TextView tywd2_x8;
    private TextView tywd2_x9;
    private TextView tywd2_x10;
    //舞蹈编导胸牌号
    private TextView wdbd1_x1;
    private TextView wdbd1_x2;
    private TextView wdbd1_x3;
    private TextView wdbd1_x4;
    private TextView wdbd1_x5;
    private TextView wdbd1_x6;
    private TextView wdbd1_x7;
    private TextView wdbd1_x8;
    private TextView wdbd1_x9;
    private TextView wdbd1_x10;
    private TextView wdbd2_x1;
    private TextView wdbd2_x2;
    private TextView wdbd2_x3;
    private TextView wdbd2_x4;
    private TextView wdbd2_x5;
    private TextView wdbd2_x6;
    private TextView wdbd2_x7;
    private TextView wdbd2_x8;
    private TextView wdbd2_x9;
    private TextView wdbd2_x10;
    //中国舞胸牌号
    private TextView zgw1_x1;
    private TextView zgw1_x2;
    private TextView zgw1_x3;
    private TextView zgw1_x4;
    private TextView zgw1_x5;
    private TextView zgw1_x6;
    private TextView zgw1_x7;
    private TextView zgw1_x8;
    private TextView zgw1_x9;
    private TextView zgw1_x10;
    private TextView zgw2_x1;
    private TextView zgw2_x2;
    private TextView zgw2_x3;
    private TextView zgw2_x4;
    private TextView zgw2_x5;
    private TextView zgw2_x6;
    private TextView zgw2_x7;
    private TextView zgw2_x8;
    private TextView zgw2_x9;
    private TextView zgw2_x10;
    private Button submit_button[];
    //路径
    private File path;
    //文件
    private File f;
    //SQLServer 服务器
    private String UserName = "sa";
    private String Password = "89655086";
    private String dbURL = "jdbc:jtds:sqlserver://172.18.165.69:1433;DatabaseName=YIKAO2";
    //对话框对象
    private AlertDialog.Builder builder;
    private String submit_tag="line10";
    //用于记录裁判id
    private String judgeIds;
    //p_tag标记考试专业
    private String p_tag = "fzby";
    private String p_tag_table = "fzby1";
    //court1默认为第一小组
    private String court_tag = "court1";
    //定义一个关于专业的字符串数组
    private String pro[];
    //连接
    Connection con = null;
    //定义一个小型数据库对象db
    private SQLiteDatabase db;
    //每个专业的动作的id放进去
    private String [] fuzhuangby1_projectIDs;
    private String [] jianmeic1_projectIDs;
    private String [] lalac1_projectIDs;
    private String [] liuxingw1_projectIDs;
    private String [] tiyuwd1_projectIDs;
    private String [] wudaobd1_projectIDs;
    private String [] zhongguow1_projectIDs;
    private String [] fuzhuangby2_projectIDs;
    private String [] jianmeic2_projectIDs;
    private String [] lalac2_projectIDs;
    private String [] liuxingw2_projectIDs;
    private String [] tiyuwd2_projectIDs;
    private String [] wudaobd2_projectIDs;
    private String [] zhongguow2_projectIDs;
    // 整型的胸牌号的标示
    private  int begXiongPH=1;
    //获取失败标示
    private int deny=2;
    //给每个专业的考场定义文本框数组
    private TextView [] fzby1_xph;
    private TextView [] fzby2_xph;
    private TextView [] llc1_xph;
    private TextView [] llc2_xph;
    private TextView [] lxw1_xph;
    private TextView [] lxw2_xph;
    private TextView [] jmc1_xph;
    private TextView [] jmc2_xph;
    private TextView [] wdbd1_xph;
    private TextView [] wdbd2_xph;
    private TextView [] zgw1_xph;
    private TextView [] zgw2_xph;
    private TextView [] tywd1_xph;
    private TextView [] tywd2_xph;
    //获取胸牌号的布尔值
    private  boolean gainXPH=true;
    //提交失败标示
    private static int error=404;
    //提交成功标示
    private static int success=200;
    //用来判断网络是否连通
    private static int NetworkError=300;

    //静态的整型数值，用来判断按钮
    private static final int btn1_color=100001;
    private static final int btn2_color=100002;
    private static final int btn3_color=100003;
    private static final int btn4_color=100004;
    private static final int btn5_color=100005;
    private static final int btn6_color=100006;
    private static final int btn7_color=100007;
    private static final int btn8_color=100008;
    private static final int btn9_color=100009;
    private static final int btn10_color=100010;
    private static final int btntotal_color=100011;
    private boolean fortotal;
    //消息队列处理机制
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //判断发来的消息what的数值用来做出相应的动作
            if (msg.what==10010){
                Toast.makeText(Mark.this,"数据不能为空",Toast.LENGTH_SHORT).show();
            }
            else if(msg.what==3){
                //获取专业的下拉列表
                pro = getResources().getStringArray(R.array.professions);
                getSpinner();
                //监听事件
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if ("court1".equals(court_tag)) {//第一小组
                            switch (position) {
                                case 0:
                                    p_tag = "fzby";
                                    p_tag_table="fzby1";
                                    ll_court.setVisibility(View.VISIBLE);
                                    fzby1();
                                    break;
                                case 1:
                                    p_tag = "jmc";
                                    p_tag_table="jmc1";
                                    ll_court.setVisibility(View.VISIBLE);
                                    jmc1();
                                    break;
                                case 2:
                                    p_tag = "llc";
                                    p_tag_table="llc1";
                                    ll_court.setVisibility(View.VISIBLE);
                                    llc1();
                                    break;
                                case 3:
                                    p_tag = "lxw";
                                    p_tag_table="lxw1";
                                    ll_court.setVisibility(View.VISIBLE);
                                    lxw1();
                                    break;
                                case 4:
                                    p_tag = "tywd";
                                    p_tag_table="tywd1";
                                    ll_court.setVisibility(View.VISIBLE);
                                    tywd1();
                                    break;
                                case 5:
                                    p_tag = "wdbd";
                                    p_tag_table="wdbd1";
                                    ll_court.setVisibility(View.VISIBLE);
                                    wdbd1();
                                    break;
                                case 6:
                                    p_tag = "zgw";
                                    p_tag_table="zgw1";
                                    ll_court.setVisibility(View.VISIBLE);
                                    zgw1();
                                    break;
                            }
                        } else {//第二小组
                            switch (position) {
                                case 0:
                                    fzby2();
                                    p_tag = "fzby";
                                    p_tag_table="fzby2";
                                    ll_court.setVisibility(View.VISIBLE);
                                    break;
                                case 1:
                                    jmc2();
                                    p_tag = "jmc";
                                    p_tag_table="jmc2";
                                    ll_court.setVisibility(View.VISIBLE);
                                    break;
                                case 2:
                                    llc2();
                                    p_tag = "llc";
                                    p_tag_table="llc2";
                                    ll_court.setVisibility(View.VISIBLE);
                                    break;
                                case 3:
                                    lxw2();
                                    p_tag = "lxw";
                                    p_tag_table="lxw2";
                                    ll_court.setVisibility(View.VISIBLE);
                                    break;
                                case 4:
                                    tywd2();
                                    p_tag = "tywd";
                                    p_tag_table="tywd2";
                                    ll_court.setVisibility(View.VISIBLE);
                                    break;
                                case 5:
                                    wdbd2();
                                    p_tag = "wdbd";
                                    p_tag_table="wdbd2";
                                    ll_court.setVisibility(View.VISIBLE);
                                    break;
                                case 6:
                                    zgw2();
                                    p_tag = "zgw";
                                    p_tag_table="zgw2";
                                    ll_court.setVisibility(View.VISIBLE);
                                    break;
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                //给小组单选按钮组设置监听事件
                subGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        //判断小组组别
                        if (R.id.court1 == checkedId) {//第一组
                            court_tag = "court1";
                            switch (p_tag) {
                                case "fzby":
                                    p_tag_table="fzby1";
                                    fzby1();
                                    break;
                                case "jmc":
                                    p_tag_table="jmc1";
                                    jmc1();
                                    break;
                                case "llc":
                                    p_tag_table="llc1";
                                    llc1();
                                    break;
                                case "lxw":
                                    p_tag_table="lxw1";
                                    lxw1();
                                    break;
                                case "tywd":
                                    p_tag_table="tywd1";
                                    tywd1();
                                    break;
                                case "wdbd":
                                    p_tag_table="wdbd1";
                                    wdbd1();
                                    break;
                                case "zgw":
                                    p_tag_table="zgw1";
                                    zgw1();
                                    break;

                            }
                        } else {//第二组
                            court_tag = "court2";
                            switch (p_tag) {
                                case "fzby":
                                    p_tag_table="fzby2";
                                    fzby2();
                                    break;
                                case "jmc":
                                    p_tag_table="jmc2";
                                    jmc2();
                                    break;
                                case "llc":
                                    p_tag_table="llc2";
                                    llc2();
                                    break;
                                case "lxw":
                                    p_tag_table="lxw2";
                                    lxw2();
                                    break;
                                case "tywd":
                                    p_tag_table="tywd2";
                                    tywd2();
                                    break;
                                case "wdbd":
                                    p_tag_table="wdbd2";
                                    wdbd2();
                                    break;
                                case "zgw":
                                    p_tag_table="zgw2";
                                    zgw2();
                                    break;
                            }
                        }
                    }
                });
            }
            else if (msg.what==begXiongPH){
                ResultSet rs=(ResultSet) msg.obj;
                try{
                    if (rs.next()==false){
                        Toast.makeText(Mark.this,"请耐心等待裁判长的命令",Toast.LENGTH_SHORT).show();
                    }else {
                        int i=0;
                        //执行胸牌号的切换
                        switch(p_tag){
                            case "fzby":
                                do{
                                    fzby1_xph[i].setText(rs.getString("xiongPaiHao"));
                                    fzby2_xph[i].setText(rs.getString("xiongPaiHao"));
                                    i++;
                                }while (rs.next());
                                clearText_fzby1();
                                clearText_fzby2();
                                break;
                            case "jmc":
                                do{
                                    jmc1_xph[i].setText(rs.getString("xiongPaiHao"));
                                    jmc2_xph[i].setText(rs.getString("xiongPaiHao"));
                                    i++;
                                }while (rs.next());
                                clearText_jmc1();
                                clearText_jmc2();
                                break;
                            case "llc":
                                do{
                                    llc1_xph[i].setText(rs.getString("xiongPaiHao"));
                                    llc2_xph[i].setText(rs.getString("xiongPaiHao"));
                                    i++;
                                }while(rs.next());
                                clearText_llc1();
                                clearText_llc2();
                                break;
                            case "lxw":
                                do{
                                    lxw1_xph[i].setText(rs.getString("xiongPaiHao"));
                                    lxw2_xph[i].setText(rs.getString("xiongPaiHao"));
                                    i++;
                                }while (rs.next());
                                clearText_lxw1();
                                clearText_lxw2();
                                break;
                            case "tywd":
                                do{
                                    tywd1_xph[i].setText(rs.getString("xiongPaiHao"));
                                    tywd2_xph[i].setText(rs.getString("xiongPaiHao"));
                                    i++;
                                }while (rs.next());
                                clearText_tywd1();
                                clearText_tywd2();
                                break;
                            case "wdbd":
                            do{
                                wdbd1_xph[i].setText(rs.getString("xiongPaiHao"));
                                wdbd2_xph[i].setText(rs.getString("xiongPaiHao"));
                                i++;
                            }while (rs.next());
                            clearText_wdbd1();
                            clearText_wdbd2();
                            break;
                            case "zgw":
                                do {
                                    zgw1_xph[i].setText(rs.getString("xiongPaiHao"));
                                    zgw2_xph[i].setText(rs.getString("xiongPaiHao"));
                                    i++;
                                }while (rs.next());
                                clearText_zgw1();
                                clearText_zgw2();
                                break;
                        }
                        next.setText("获取下一组胸牌号");
                        next.setClickable(false);
                        next.setTextColor(getResources().getColor(R.color.submitButtonOff));
                        totalSubmit.setClickable(true);
                        totalSubmit.setTextColor(getResources().getColor(R.color.submitButtonOn));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if (msg.what==deny){
                Toast.makeText(Mark.this,"此组考生成绩未全部提交，不能请求下一组考试",Toast.LENGTH_LONG).show();
            }
            else if(msg.what==error){
                fortotal = false;
                Toast.makeText(Mark.this,"提交失败:重复录入数据，主键重复",Toast.LENGTH_SHORT).show();
            }
            else if (msg.what==success){
                Toast.makeText(Mark.this,"提交成功",Toast.LENGTH_SHORT).show();
                fortotal = true;
            }
            else if (msg.what==NetworkError){
                Toast.makeText(Mark.this,"提交失败：Class.forName::ClassNotFoundException.\n" +
                        "请先退出后设置网络",Toast.LENGTH_LONG).show();
            }
            else if(msg.what==btn1_color){
                line1.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line1.setClickable(false);
            }
            else if(msg.what==btn2_color){
                line2.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line2.setClickable(false);
            }
            else if(msg.what==btn3_color){
                line3.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line3.setClickable(false);
            }
            else if(msg.what==btn4_color){
                line4.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line4.setClickable(false);
            }
            else if(msg.what==btn5_color){
                line5.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line5.setClickable(false);
            }
            else if(msg.what==btn6_color){
                line6.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line6.setClickable(false);
            }
            else if(msg.what==btn7_color){
                line7.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line7.setClickable(false);
            }
            else if(msg.what==btn8_color){
                line8.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line8.setClickable(false);
            }
            else if(msg.what==btn9_color){
                line9.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line9.setClickable(false);
            }
            else if(msg.what==btn10_color){
                line10.setTextColor(getResources().getColor(R.color.submitButtonOff));
                line10.setClickable(false);
            }
            else if(msg.what==btntotal_color){
                if (fortotal){
                    next.setClickable(true);
                    next.setTextColor(getResources().getColor(R.color.submitButtonOn));
                    totalSubmit.setClickable(false);
                    totalSubmit.setTextColor(getResources().getColor(R.color.submitButtonOff));
                    pauseAll();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mark);
        //强制用横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //初始化操作
        init();
        //子线程开始
        thread1.start();
        //请求下一组的按钮
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        //gainXPH如果为真，允许裁判请求下一组
                        if (gainXPH){
                            Class.forName("net.sourceforge.jtds.jdbc.Driver");
                            con = DriverManager.getConnection(dbURL, UserName, Password);
                            String sql = "select xiongPaiHao from tempTable where xiongPaiHao " +
                                    "in( select top 10 xiongPaiHao from tempTable order by num desc)";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sql);
                            Message msg = new Message();
                            msg.obj = rs;
                            msg.what = begXiongPH;
                            handler.sendMessage(msg);
                            //切换值，此时裁判不能请求下一组
                            gainXPH=false;
                        }
                        else {
                            if ("line10".equals(submit_tag) || "lineTotal".equals(submit_tag)) {
                                resumeAll();
                                totalSubmit.setClickable(true);
                                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                                con = DriverManager.getConnection(dbURL, UserName, Password);
                                String sql = "select xiongPaiHao from tempTable where xiongPaiHao " +
                                        "in( select top 10 xiongPaiHao from tempTable order by num desc)";
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery(sql);
                                Message msg = new Message();
                                msg.obj = rs;
                                msg.what = begXiongPH;
                                handler.sendMessage(msg);
                            } else {
                                Message msg = new Message();
                                msg.what = deny;
                                handler.sendMessage(msg);
                            }
                        }
                    }catch (Exception e){
                        Message msg = Message.obtain();
                        msg.what=NetworkError;
                        handler.sendMessage(msg);
                    }
                }
            }).start();
//                totalSubmit.setTextColor(getResources().getColor(R.color.submitButtonOn));
                resumeAll();
            }

        });
    }
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            //创建本地文件
            path = new File("/sdcard/Yikao");
            f = new File("/sdcard/Yikao/YiKao.db");
            Intent intent = getIntent();
            Bundle bundle=intent.getBundleExtra("info");
            judgeIds = bundle.getString("judgeId");
            UserName=bundle.getString("username");
            Password=bundle.getString("password");
            dbURL=bundle.getString("dbURL");
                System.out.println("jid:"+judgeIds+"\n username:"+UserName+"\npwd:"+Password+"\ndburl"+dbURL);
            if (!path.exists()) {
                path.mkdirs();
            }
            if (!f.exists()) {
                try {
                    f.createNewFile();
                    String []sql_createTable=getCreateTableSQL();
                    db=SQLiteDatabase.openOrCreateDatabase(f,null);
                    for (String s:sql_createTable) {
                        db.execSQL(s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }Message msg=new Message();
            msg.what=3;
            handler.sendMessage(msg);
        }
    });
    //重写该方法，当用户按下返回键时触发该方法
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            try {
                builder = new AlertDialog.Builder(Mark.this);
                builder.setTitle("Exit");
                builder.setMessage("are you sure you want to quit?");
                // 相当于取消
                builder.setPositiveButton("cancle",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                // 相当于确定
                builder.setNegativeButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Mark.this.finish();
                            }
                        });
                builder.show();
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
//定义点击方法，当裁判按下提交时触发该方法
    public void onClick(final View v) {
        try {
            builder = new AlertDialog.Builder(Mark.this);
            builder.setTitle("提交");
            builder.setMessage("确认提交吗?");
            // 相当于取消
            builder.setPositiveButton("取消",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Mark.this, "提交已取消",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
            // 相当于确定
            builder.setNegativeButton("确认提交",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //判断用户按下的提交键
                            switch (v.getId()) {
                                case R.id.line1:
                                    submit_tag = "line1";
                                    button_tag = 0;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            //判断用户输入的是否为空，若为空提示裁判，不为空时执行else语句
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                //本地备份
                                                localCache_firstStep();
                                                //提交数据库
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn1_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line2:
                                    submit_tag = "line2";
                                    button_tag = 1;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn2_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line3:
                                    submit_tag = "line3";
                                    button_tag = 2;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn3_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line4:
                                    submit_tag = "line4";
                                    button_tag = 3;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn4_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line5:
                                    submit_tag = "line5";
                                    button_tag = 4;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn5_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line6:
                                    submit_tag = "line6";
                                    button_tag = 5;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn6_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line7:
                                    submit_tag = "line7";
                                    button_tag = 6;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn7_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line8:
                                    submit_tag = "line8";
                                    button_tag = 7;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn8_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line9:
                                    submit_tag = "line9";
                                    button_tag = 8;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn9_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.line10:
                                    submit_tag = "line10";
                                    button_tag = 9;
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verify_EditText_Empty()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btn10_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                                case R.id.total_submit:
                                    submit_tag = "lineTotal";
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (verifyAllEditText()==10010) {
                                                Message msg = new Message();
                                                msg.what =10010;
                                                handler.sendMessage(msg);
                                            } else {
                                                localCache_firstStep();
                                                inputDBTask();
                                                Message msg=new Message();
                                                msg.what=btntotal_color;
                                                handler.sendMessage(msg);
                                            }
                                        }
                                    }).start();
                                    break;
                            }
                        }
                    });
            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //确定所有提交的数据是否为空
    private int verifyAllEditText() {
        String [][] temp=switch_for_pro();
        int empty=0;
        for (String [] s1:temp){
            for (String s2:s1){
               if (s2.equals("")){
                   empty=10010;
                   break;
               }
            }
            if (empty==10010){
                break;
            }
        }
        return empty;
    }
    //判断提交的数据是否为空
    public int verify_EditText_Empty() {
        int temp_int = 1;
        switch (p_tag_table) {
            case "fzby1":
                temp_int = verify_2ET();
                break;
            case "fzby2":
                temp_int = verify_2ET();
                break;
            case "jmc1":
                temp_int = verify_4ET();
                break;
            case "jmc2":
                temp_int = verify_1ET();
                break;
            case "llc1":
                temp_int = verify_2ET();
                break;
            case "llc2":
                temp_int = verify_1ET();
                break;
            case "lxw1":
                temp_int = verify_6ET();
                break;
            case "lxw2":
                temp_int = verify_2ET();
                break;
            case "tywd1":
                temp_int = verify_4ET();
                break;
            case "tywd2":
                temp_int = verify_2ET();
                break;
            case "wdbd1":
                temp_int = verify_6ET();
                break;
            case "wdbd2":
                temp_int = verify_2ET();
                break;
            case "zgw1":
                temp_int = verify_6ET();
                break;
            case "zgw2":
                temp_int = verify_2ET();
                break;
        }
        return temp_int;
    }
    //只有2列的编辑框的情况
    public int verify_2ET(){
        String [][] temp=switch_for_pro();
        int temp_int=0;
        switch (submit_tag){
            case "line1":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line2":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line3":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line4":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line5":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line6":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line7":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line8":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line9":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line10":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")) {
                    temp_int = 10010;
                }
                break;
        }
        return temp_int;
    }
    //只有4列的编辑框的情况
    public int verify_4ET(){
        String [][] temp=switch_for_pro();
        int temp_int=0;
        switch (submit_tag){
            case "line1":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line2":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line3":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line4":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line5":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals(""))  {
                    temp_int = 10010;
                }
                break;
            case "line6":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line7":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals(""))  {
                    temp_int = 10010;
                }
                break;
            case "line8":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line9":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line10":
                if(temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||temp[button_tag][4].equals("")) {
                    temp_int = 10010;
                }
                break;
        }
        return temp_int;
    }
    //只有1列编辑框的情况
    public int verify_1ET(){
        String [][] temp=switch_for_pro();
        int temp_int=0;
        switch (submit_tag){
            case "line1":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line2":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line3":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line4":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line5":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line6":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line7":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line8":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line9":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line10":
                if (temp[button_tag][1].equals("")) {
                    temp_int = 10010;
                }
                break;
        }
        return temp_int;
    }
    //只有6列的编辑框的情况
    public int verify_6ET(){
        String [][] temp=switch_for_pro();
        int temp_int=0;
        switch (submit_tag){
            case "line1":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line2":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line3":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line4":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line5":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line6":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line7":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line8":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line9":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
            case "line10":
                if (temp[button_tag][1].equals("")||temp[button_tag][2].equals("")||temp[button_tag][3].equals("")||
                        temp[button_tag][4].equals("")||temp[button_tag][5].equals("")||temp[button_tag][6].equals("")) {
                    temp_int = 10010;
                }
                break;
        }
        return temp_int;
    }
    //本地缓存的第一步
    private void localCache_firstStep() {
        switch (p_tag) {
            case "fzby":
                if ("court1".equals(court_tag)) {
                    fzby1_localCache();
                } else {
                    fzby2_localCache();
                }
                break;
            case "jmc":
                if ("court1".equals(court_tag)) {
                    jmc1_localCache();
                } else {
                    jmc2_localCache();
                }
                break;
            case "llc":
                if ("court1".equals(court_tag)) {
                    llc1_localCache();
                } else {
                    llc2_localCache();
                }
                break;
            case "lxw":
                if ("court1".equals(court_tag)) {
                    lxw1_localCache();
                } else {
                    lxw2_localCache();
                }
                break;
            case "tywd":
                if ("court1".equals(court_tag)) {
                    tywd1_localCache();
                } else {
                    tywd2_localCache();
                }
                break;
            case "wdbd":
                if ("court1".equals(court_tag)) {
                    wdbd1_localCache();
                } else {
                    wdbd2_localCache();
                }
                break;
            case "zgw":
                if ("court1".equals(court_tag)) {
                    zgw1_localCache();
                } else {
                    zgw2_localCache();
                }
                break;
        }
    }
    //本地缓存
    private void fzby1_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues []valuesArray = new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XiangM", temp[button_tag][1]);
                    values.put("CaiY", temp[button_tag][2]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH",temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("XiangM", temp[i][1]);
                        v.put("CaiY", temp[i][2]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("fzby1", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //执行总提交
    private void excTotalSubmit(String tableName,ContentValues[] valuesArray) {
        for(ContentValues v:valuesArray){
            db.insert(tableName,null,v);
        }
    }
    private void fzby2_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray=new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("YuY", temp[button_tag][1]);
                    values.put("YongZ", temp[button_tag][2]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH",temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("YuY", temp[i][1]);
                        v.put("YongZ", temp[i][2]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("fzby2", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void jmc1_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray=new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("GaoTT", temp[button_tag][2]);
                    values.put("QuTFTT", temp[button_tag][3]);
                    values.put("NanDZH", temp[button_tag][4]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("XingT", temp[i][1]);
                        v.put("GaoTT", temp[i][2]);
                        v.put("QuTFTT", temp[i][3]);
                        v.put("NanDZH", temp[i][4]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("jmc1", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void jmc2_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray=new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("ChengT", temp[i][1]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("jmc2", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void llc1_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray=new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingT", temp[button_tag][1]);
                    values.put("SuZ", temp[button_tag][2]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("XingT", temp[i][1]);
                        v.put("SuZ", temp[i][2]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("llc1", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void llc2_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray=new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("ChengT", temp[button_tag][1]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("ChengT", temp[i][1]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("llc2", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void lxw1_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray = new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("XingX", temp[i][1]);
                        v.put("HengC", temp[i][2]);
                        v.put("ZongC", temp[i][3]);
                        v.put("HouY", temp[i][4]);
                        v.put("BanTPH", temp[i][5]);
                        v.put("JiQ", temp[i][6]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("lxw1", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void lxw2_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray = new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("MoF", temp[i][1]);
                        v.put("WaoDZP", temp[i][2]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("lxw2", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void tywd1_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues [] valuesArray=new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingTQZ", temp[button_tag][1]);
                    values.put("PingZ", temp[button_tag][2]);
                    values.put("Cha", temp[button_tag][3]);
                    values.put("ShuangFT", temp[button_tag][4]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("XingTQZ", temp[i][1]);
                        v.put("PingZ", temp[i][2]);
                        v.put("Cha", temp[i][3]);
                        v.put("ShuangFT", temp[i][4]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("tywd1", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void tywd2_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray=new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("LaDW", temp[button_tag][1]);
                    values.put("MoD", temp[button_tag][2]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("LaDW", temp[button_tag][1]);
                        v.put("MoD", temp[button_tag][2]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("tywd2", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void wdbd1_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray=new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingXXT", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ShuC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("DongZMF", temp[button_tag][6]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("XingXXT", temp[i][1]);
                        v.put("HengC", temp[i][2]);
                        v.put("ShuC", temp[i][3]);
                        v.put("HouY", temp[i][4]);
                        v.put("BanTPH", temp[i][5]);
                        v.put("DongZMF", temp[i][6]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("wdbd1", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void wdbd2_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray= new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("WaoDZP", temp[button_tag][1]);
                    values.put("MingTBY", temp[button_tag][2]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("WaoDZP", temp[i][1]);
                        v.put("MingTBY", temp[i][2]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("wdbd2", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void zgw1_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues [] valuesArray = new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("XingX", temp[button_tag][1]);
                    values.put("HengC", temp[button_tag][2]);
                    values.put("ZongC", temp[button_tag][3]);
                    values.put("HouY", temp[button_tag][4]);
                    values.put("BanTPH", temp[button_tag][5]);
                    values.put("JiQ", temp[button_tag][6]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("XingX", temp[i][1]);
                        v.put("HengC", temp[i][2]);
                        v.put("ZongC", temp[i][3]);
                        v.put("HouY", temp[i][4]);
                        v.put("BanTPH", temp[i][5]);
                        v.put("JiQ", temp[i][6]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("zgw1", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void zgw2_localCache() {
        try {
            String[][] temp = switch_for_pro();
            db=SQLiteDatabase.openOrCreateDatabase(f,null);
            ContentValues values = new ContentValues();
            ContentValues[] valuesArray =new ContentValues[10];
            switch (submit_tag) {
                case "line1":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "line2":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "line3":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "line4":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "line5":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "line6":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "line7":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WaoDZP", temp[button_tag][2]);
                    break;
                case "line8":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "line9":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "line10":
                    values.put("XPH", temp[button_tag][0]);
                    values.put("JID", judgeIds);
                    values.put("MoF", temp[button_tag][1]);
                    values.put("WuDZP", temp[button_tag][2]);
                    break;
                case "lineTotal":
                    for(int i=0;i<10;i++){
                        ContentValues v=new ContentValues();
                        v.put("XPH", temp[i][0]);
                        v.put("JID", judgeIds);
                        v.put("XingX", temp[i][1]);
                        v.put("HengC", temp[i][2]);
                        v.put("ZongC", temp[i][3]);
                        v.put("HouY", temp[i][4]);
                        v.put("BanTPH", temp[i][5]);
                        v.put("JiQ", temp[i][6]);
                        valuesArray[i]=v;
                    }
                    break;
            }
            if (submit_tag.equals("lineTotal")){
                excTotalSubmit(p_tag_table,valuesArray);
            }else {
                db.insert("zgw2", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //暂停所有的提交按钮
    public void pauseAll() {
        for (int i = 0; i < 10; i++) {
            submit_button[i].setTextColor(getResources().getColor(R.color.submitButtonOff));
            submit_button[i].setClickable(false);
        }
    }
    //恢复所有的提交按钮
    public void resumeAll() {
        for (int i = 0; i < 10; i++) {
            submit_button[i].setTextColor(getResources().getColor(R.color.submitButtonOn));
            submit_button[i].setClickable(true);
        }
    }

    //该方法进行数据库的录入
    public void inputDBTask() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, UserName, Password);
            String []sql = getSQL();
            Statement stmt = con.createStatement();//创建Statement
            int i=0;
            int j=0;
            for (String s:sql) {
                do{
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i=stmt.executeUpdate(s);
                    j++;
                    if (j==4){break;}
                }while (i==0);
            }
            if (i==1){
                Message msg=new Message();
                msg.what=success;
                handler.sendMessage(msg);
            }
            stmt.close();
            //测试数据库连接
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            Message msg = Message.obtain();
            msg.what=NetworkError;
            handler.sendMessage(msg);
        } catch (SQLException e) {
            e.printStackTrace();
            Message msg=new Message();
            msg.what=error;
            handler.sendMessage(msg);
        } finally {
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
    //获取sql语句
    public String [] getSQL() {
        String[][] strings = switch_for_pro();
        switch (p_tag) {
            case "fzby":
                if ("court1".equals(court_tag)) {
                    return fzby1_InputDBTask(strings);
                } else {
                    return fzby2_InputDBTask(strings);
                }
            case "jmc":
                if ("court1".equals(court_tag)) {
                    return jmc1_InputDBTask(strings);
                } else {
                    return jmc2_InputDBTask(strings);
                }
            case "llc":
                if ("court1".equals(court_tag)) {
                    return llc1_InputDBTask(strings);
                } else {
                    return llc2_InputDBTask(strings);
                }
            case "lxw":
                if ("court1".equals(court_tag)) {
                    return lxw1_InputDBTask(strings);
                } else {
                    return lxw2_InputDBTask(strings);
                }
            case "tywd":
                if ("court1".equals(court_tag)) {
                    return tywd1_InputDBTask(strings);
                } else {
                    return tywd2_InputDBTask(strings);
                }
            case "wdbd":
                if ("court1".equals(court_tag)) {
                    return wdbd1_InputDBTask(strings);
                } else {
                    return wdbd2_InputDBTask(strings);
                }
            case "zgw":
                if ("court1".equals(court_tag)) {
                    return zgw1_InputDBTask(strings);
                } else {
                    return zgw2_InputDBTask(strings);
                }
        }
        return null;
    }
    //创建数据库和表
    public String[] getCreateTableSQL() {
        String []createTableSQL=new String[]{
        "create table fzby1(_id integer primary key autoincrement,XPH char(10)," +
                        "JID char(10),XiangM float,CaiY float)"
        ,"create table fzby2(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),YuY float,YongZ float)"
        ,"create table jmc1(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),XingT float,GaoTT float,QuTFTT float,NanDZH float)"
        ,"create table jmc2(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),ChengT float)"
        ,"create table llc1(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),XingT float,SuZ float)"
        ,"create table llc2(_id integer primary key autoincrement,XPH char(10)," +
                "JID char(10),ChengT float)"
        ,"create table lxw1(_id integer primary key autoincrement,XPH char(10),JID char(10),XingX float,HengC float," +
                "ZongC float,HouY float,BanTPH float,JiQ float)"
        ,"create table lxw2(_id integer primary key autoincrement,XPH char(10),JID char(10),MoF float,WaoDZP float)"
        ,"create table tywd1(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "XingTQZ float,PingZ float,Cha float,ShuangFT float)"
        ,"create table tywd2(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "LaDW float,MoD float)"
        ,"create table wdbd1(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "XingXXT float,HengC float,ShuC float,HouY float,BanTPH float,DongZMF float)"
        ,"create table wdbd2(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "WaoDZP float,MingTBY float)"
        ,"create table zgw1(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "XingX float,HengC float,ZongC float,HouY float,BanTPH float,JiQ float)"
        ,"create table zgw2(_id integer primary key autoincrement,XPH char(10),JID char(10)," +
                "MoF float,WuDZP float)"
        };
        return createTableSQL;
    }
    //获取输入内容
    public String[][] switch_for_pro() {
        getInputText getinputtext = new getInputText();
        switch (p_tag) {
            case "fzby":
                if ("court1".equals(court_tag)) {
                    return getinputtext.fzby1_getText();
                } else {
                    return getinputtext.fzby2_getText();
                }
            case "jmc":
                if ("court1".equals(court_tag)) {
                    return getinputtext.jmc1_getText();
                } else {
                    return getinputtext.jmc2_getText();
                }
            case "llc":
                if ("court1".equals(court_tag)) {
                    return getinputtext.llc1_getText();
                } else {
                    return getinputtext.llc2_getText();
                }
            case "lxw":
                if ("court1".equals(court_tag)) {
                    return getinputtext.lxw1_getText();
                } else {
                    return getinputtext.lxw2_getText();
                }
            case "tywd":
                if ("court1".equals(court_tag)) {
                    return getinputtext.tywd1_getText();
                } else {
                    return getinputtext.tywd2_getText();
                }
            case "wdbd":
                if ("court1".equals(court_tag)) {
                    return getinputtext.wdbd1_getText();
                } else {
                    return getinputtext.wdbd2_getText();
                }
            case "zgw":
                if ("court1".equals(court_tag)) {
                    return getinputtext.zgw1_getText();
                } else {
                    return getinputtext.zgw2_getText();
                }
            default:
                break;
        }
        return null;
    }

    //获取所有专业下拉列表
    public void getSpinner() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < pro.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("profession", pro[i]);
            listItems.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(), listItems, R.layout.list_item,
                new String[]{"profession"}, new int[]{R.id.list_item_pro});
        spinner.setAdapter(simpleAdapter);
    }

    public void init() {
        fuzhuangby1_projectIDs=getResources().getStringArray(R.array.fuzhuangby1_projectIDs);
        jianmeic1_projectIDs=getResources().getStringArray(R.array.jianmeic1_projectIDs);
        lalac1_projectIDs=getResources().getStringArray(R.array.lalac1_projectIDs);
        liuxingw1_projectIDs=getResources().getStringArray(R.array.liuxingw1_projectIDs);
        tiyuwd1_projectIDs=getResources().getStringArray(R.array.tiyuwd1_projectIDs);
        wudaobd1_projectIDs=getResources().getStringArray(R.array.wudaobd1_projectIDs);
        zhongguow1_projectIDs=getResources().getStringArray(R.array.zhongguow1_projectIDs);
        fuzhuangby2_projectIDs=getResources().getStringArray(R.array.fuzhuangby2_projectIDs);
        jianmeic2_projectIDs=getResources().getStringArray(R.array.jianmeic2_projectIDs);
        lalac2_projectIDs=getResources().getStringArray(R.array.lalac2_projectIDs);
        liuxingw2_projectIDs=getResources().getStringArray(R.array.liuxingw2_projectIDs);
        tiyuwd2_projectIDs=getResources().getStringArray(R.array.tiyuwd2_projectIDs);
        wudaobd2_projectIDs=getResources().getStringArray(R.array.wudaobd2_projectIDs);
        zhongguow2_projectIDs=getResources().getStringArray(R.array.zhongguow2_projectIDs);
        totalSubmit = (Button) findViewById(R.id.total_submit);
        line1 = (Button) findViewById(R.id.line1);
        line2 = (Button) findViewById(R.id.line2);
        line3 = (Button) findViewById(R.id.line3);
        line4 = (Button) findViewById(R.id.line4);
        line5 = (Button) findViewById(R.id.line5);
        line6 = (Button) findViewById(R.id.line6);
        line7 = (Button) findViewById(R.id.line7);
        line8 = (Button) findViewById(R.id.line8);
        line9 = (Button) findViewById(R.id.line9);
        line10 = (Button) findViewById(R.id.line10);
        submit_button = new Button[]{line1, line2, line3, line4, line5, line6, line7, line8, line9, line10};
        ll_court = (LinearLayout) findViewById(R.id.LL_court);
        subGroup = (RadioGroup) findViewById(R.id.FM_court);
        FM_fzby1 = (FrameLayout) findViewById(R.id.Table_fzby1);
        FM_fzby2 = (FrameLayout) findViewById(R.id.Table_fzby2);
        FM_jmc1 = (FrameLayout) findViewById(R.id.Table_jmc1);
        FM_jmc2 = (FrameLayout) findViewById(R.id.Table_jmc2);
        FM_llc1 = (FrameLayout) findViewById(R.id.Table_llc1);
        FM_llc2 = (FrameLayout) findViewById(R.id.Table_llc2);
        FM_lxw1 = (FrameLayout) findViewById(R.id.Table_lxw1);
        FM_lxw2 = (FrameLayout) findViewById(R.id.Table_lxw2);
        FM_tywd1 = (FrameLayout) findViewById(R.id.Table_tywd1);
        FM_tywd2 = (FrameLayout) findViewById(R.id.Table_tywd2);
        FM_wdbd1 = (FrameLayout) findViewById(R.id.Table_wdbd1);
        FM_wdbd2 = (FrameLayout) findViewById(R.id.Table_wdbd2);
        FM_zgw1 = (FrameLayout) findViewById(R.id.Table_zgw1);
        FM_zgw2 = (FrameLayout) findViewById(R.id.Table_zgw2);
        spinner = (Spinner) findViewById(R.id.spinner_professoins);
        //服装表演
        fzby_1_00 = (EditText) findViewById(R.id.fuzhuangby_1_00);
        fzby_1_01 = (EditText) findViewById(R.id.fuzhuangby_1_01);
        fzby_1_10 = (EditText) findViewById(R.id.fuzhuangby_1_10);
        fzby_1_11 = (EditText) findViewById(R.id.fuzhuangby_1_11);
        fzby_1_20 = (EditText) findViewById(R.id.fuzhuangby_1_20);
        fzby_1_21 = (EditText) findViewById(R.id.fuzhuangby_1_21);
        fzby_1_30 = (EditText) findViewById(R.id.fuzhuangby_1_30);
        fzby_1_31 = (EditText) findViewById(R.id.fuzhuangby_1_31);
        fzby_1_40 = (EditText) findViewById(R.id.fuzhuangby_1_40);
        fzby_1_41 = (EditText) findViewById(R.id.fuzhuangby_1_41);
        fzby_1_50 = (EditText) findViewById(R.id.fuzhuangby_1_50);
        fzby_1_51 = (EditText) findViewById(R.id.fuzhuangby_1_51);
        fzby_1_60 = (EditText) findViewById(R.id.fuzhuangby_1_60);
        fzby_1_61 = (EditText) findViewById(R.id.fuzhuangby_1_61);
        fzby_1_70 = (EditText) findViewById(R.id.fuzhuangby_1_70);
        fzby_1_71 = (EditText) findViewById(R.id.fuzhuangby_1_71);
        fzby_1_80 = (EditText) findViewById(R.id.fuzhuangby_1_80);
        fzby_1_81 = (EditText) findViewById(R.id.fuzhuangby_1_81);
        fzby_1_90 = (EditText) findViewById(R.id.fuzhuangby_1_90);
        fzby_1_91 = (EditText) findViewById(R.id.fuzhuangby_1_91);
        fzby_2_00 = (EditText) findViewById(R.id.fuzhuangby_2_00);
        fzby_2_01 = (EditText) findViewById(R.id.fuzhuangby_2_01);
        fzby_2_10 = (EditText) findViewById(R.id.fuzhuangby_2_10);
        fzby_2_11 = (EditText) findViewById(R.id.fuzhuangby_2_11);
        fzby_2_20 = (EditText) findViewById(R.id.fuzhuangby_2_20);
        fzby_2_21 = (EditText) findViewById(R.id.fuzhuangby_2_21);
        fzby_2_30 = (EditText) findViewById(R.id.fuzhuangby_2_30);
        fzby_2_31 = (EditText) findViewById(R.id.fuzhuangby_2_31);
        fzby_2_40 = (EditText) findViewById(R.id.fuzhuangby_2_40);
        fzby_2_41 = (EditText) findViewById(R.id.fuzhuangby_2_41);
        fzby_2_50 = (EditText) findViewById(R.id.fuzhuangby_2_50);
        fzby_2_51 = (EditText) findViewById(R.id.fuzhuangby_2_51);
        fzby_2_60 = (EditText) findViewById(R.id.fuzhuangby_2_60);
        fzby_2_61 = (EditText) findViewById(R.id.fuzhuangby_2_61);
        fzby_2_70 = (EditText) findViewById(R.id.fuzhuangby_2_70);
        fzby_2_71 = (EditText) findViewById(R.id.fuzhuangby_2_71);
        fzby_2_80 = (EditText) findViewById(R.id.fuzhuangby_2_80);
        fzby_2_81 = (EditText) findViewById(R.id.fuzhuangby_2_81);
        fzby_2_90 = (EditText) findViewById(R.id.fuzhuangby_2_90);
        fzby_2_91 = (EditText) findViewById(R.id.fuzhuangby_2_91);
        //健美操
        jmc_1_00 = (EditText) findViewById(R.id.jmc_1_00);
        jmc_1_01 = (EditText) findViewById(R.id.jmc_1_01);
        jmc_1_02 = (EditText) findViewById(R.id.jmc_1_02);
        jmc_1_03 = (EditText) findViewById(R.id.jmc_1_03);
        jmc_1_10 = (EditText) findViewById(R.id.jmc_1_10);
        jmc_1_11 = (EditText) findViewById(R.id.jmc_1_11);
        jmc_1_12 = (EditText) findViewById(R.id.jmc_1_12);
        jmc_1_13 = (EditText) findViewById(R.id.jmc_1_13);
        jmc_1_20 = (EditText) findViewById(R.id.jmc_1_20);
        jmc_1_21 = (EditText) findViewById(R.id.jmc_1_21);
        jmc_1_22 = (EditText) findViewById(R.id.jmc_1_22);
        jmc_1_23 = (EditText) findViewById(R.id.jmc_1_23);
        jmc_1_30 = (EditText) findViewById(R.id.jmc_1_30);
        jmc_1_31 = (EditText) findViewById(R.id.jmc_1_31);
        jmc_1_32 = (EditText) findViewById(R.id.jmc_1_32);
        jmc_1_33 = (EditText) findViewById(R.id.jmc_1_33);
        jmc_1_40 = (EditText) findViewById(R.id.jmc_1_40);
        jmc_1_41 = (EditText) findViewById(R.id.jmc_1_41);
        jmc_1_42 = (EditText) findViewById(R.id.jmc_1_42);
        jmc_1_43 = (EditText) findViewById(R.id.jmc_1_43);
        jmc_1_50 = (EditText) findViewById(R.id.jmc_1_50);
        jmc_1_51 = (EditText) findViewById(R.id.jmc_1_51);
        jmc_1_52 = (EditText) findViewById(R.id.jmc_1_52);
        jmc_1_53 = (EditText) findViewById(R.id.jmc_1_53);
        jmc_1_60 = (EditText) findViewById(R.id.jmc_1_60);
        jmc_1_61 = (EditText) findViewById(R.id.jmc_1_61);
        jmc_1_62 = (EditText) findViewById(R.id.jmc_1_62);
        jmc_1_63 = (EditText) findViewById(R.id.jmc_1_63);
        jmc_1_70 = (EditText) findViewById(R.id.jmc_1_70);
        jmc_1_71 = (EditText) findViewById(R.id.jmc_1_71);
        jmc_1_72 = (EditText) findViewById(R.id.jmc_1_72);
        jmc_1_73 = (EditText) findViewById(R.id.jmc_1_73);
        jmc_1_80 = (EditText) findViewById(R.id.jmc_1_80);
        jmc_1_81 = (EditText) findViewById(R.id.jmc_1_81);
        jmc_1_82 = (EditText) findViewById(R.id.jmc_1_82);
        jmc_1_83 = (EditText) findViewById(R.id.jmc_1_83);
        jmc_1_90 = (EditText) findViewById(R.id.jmc_1_90);
        jmc_1_91 = (EditText) findViewById(R.id.jmc_1_91);
        jmc_1_92 = (EditText) findViewById(R.id.jmc_1_92);
        jmc_1_93 = (EditText) findViewById(R.id.jmc_1_93);
        jmc_2_00 = (EditText) findViewById(R.id.jmc_2_00);
        jmc_2_10 = (EditText) findViewById(R.id.jmc_2_10);
        jmc_2_20 = (EditText) findViewById(R.id.jmc_2_20);
        jmc_2_30 = (EditText) findViewById(R.id.jmc_2_30);
        jmc_2_40 = (EditText) findViewById(R.id.jmc_2_40);
        jmc_2_50 = (EditText) findViewById(R.id.jmc_2_50);
        jmc_2_60 = (EditText) findViewById(R.id.jmc_2_60);
        jmc_2_70 = (EditText) findViewById(R.id.jmc_2_70);
        jmc_2_80 = (EditText) findViewById(R.id.jmc_2_80);
        jmc_2_90 = (EditText) findViewById(R.id.jmc_2_90);
        //啦啦操
        llc_1_00 = (EditText) findViewById(R.id.llc_1_00);
        llc_1_01 = (EditText) findViewById(R.id.llc_1_01);
        llc_1_10 = (EditText) findViewById(R.id.llc_1_10);
        llc_1_11 = (EditText) findViewById(R.id.llc_1_11);
        llc_1_20 = (EditText) findViewById(R.id.llc_1_20);
        llc_1_21 = (EditText) findViewById(R.id.llc_1_21);
        llc_1_30 = (EditText) findViewById(R.id.llc_1_30);
        llc_1_31 = (EditText) findViewById(R.id.llc_1_31);
        llc_1_40 = (EditText) findViewById(R.id.llc_1_40);
        llc_1_41 = (EditText) findViewById(R.id.llc_1_41);
        llc_1_50 = (EditText) findViewById(R.id.llc_1_50);
        llc_1_51 = (EditText) findViewById(R.id.llc_1_51);
        llc_1_60 = (EditText) findViewById(R.id.llc_1_60);
        llc_1_61 = (EditText) findViewById(R.id.llc_1_61);
        llc_1_70 = (EditText) findViewById(R.id.llc_1_70);
        llc_1_71 = (EditText) findViewById(R.id.llc_1_71);
        llc_1_80 = (EditText) findViewById(R.id.llc_1_80);
        llc_1_81 = (EditText) findViewById(R.id.llc_1_81);
        llc_1_90 = (EditText) findViewById(R.id.llc_1_90);
        llc_1_91 = (EditText) findViewById(R.id.llc_1_91);
        llc_2_00 = (EditText) findViewById(R.id.llc_2_00);
        llc_2_10 = (EditText) findViewById(R.id.llc_2_10);
        llc_2_20 = (EditText) findViewById(R.id.llc_2_20);
        llc_2_30 = (EditText) findViewById(R.id.llc_2_30);
        llc_2_40 = (EditText) findViewById(R.id.llc_2_40);
        llc_2_50 = (EditText) findViewById(R.id.llc_2_50);
        llc_2_60 = (EditText) findViewById(R.id.llc_2_60);
        llc_2_70 = (EditText) findViewById(R.id.llc_2_70);
        llc_2_80 = (EditText) findViewById(R.id.llc_2_80);
        llc_2_90 = (EditText) findViewById(R.id.llc_2_90);
        //流行舞
        lxw_1_00 = (EditText) findViewById(R.id.lxw_1_00);
        lxw_1_01 = (EditText) findViewById(R.id.lxw_1_01);
        lxw_1_02 = (EditText) findViewById(R.id.lxw_1_02);
        lxw_1_03 = (EditText) findViewById(R.id.lxw_1_03);
        lxw_1_04 = (EditText) findViewById(R.id.lxw_1_04);
        lxw_1_05 = (EditText) findViewById(R.id.lxw_1_05);
        lxw_1_10 = (EditText) findViewById(R.id.lxw_1_10);
        lxw_1_11 = (EditText) findViewById(R.id.lxw_1_11);
        lxw_1_12 = (EditText) findViewById(R.id.lxw_1_12);
        lxw_1_13 = (EditText) findViewById(R.id.lxw_1_13);
        lxw_1_14 = (EditText) findViewById(R.id.lxw_1_14);
        lxw_1_15 = (EditText) findViewById(R.id.lxw_1_15);
        lxw_1_20 = (EditText) findViewById(R.id.lxw_1_20);
        lxw_1_21 = (EditText) findViewById(R.id.lxw_1_21);
        lxw_1_22 = (EditText) findViewById(R.id.lxw_1_22);
        lxw_1_23 = (EditText) findViewById(R.id.lxw_1_23);
        lxw_1_24 = (EditText) findViewById(R.id.lxw_1_24);
        lxw_1_25 = (EditText) findViewById(R.id.lxw_1_25);
        lxw_1_30 = (EditText) findViewById(R.id.lxw_1_30);
        lxw_1_31 = (EditText) findViewById(R.id.lxw_1_31);
        lxw_1_32 = (EditText) findViewById(R.id.lxw_1_32);
        lxw_1_33 = (EditText) findViewById(R.id.lxw_1_33);
        lxw_1_34 = (EditText) findViewById(R.id.lxw_1_34);
        lxw_1_35 = (EditText) findViewById(R.id.lxw_1_35);
        lxw_1_40 = (EditText) findViewById(R.id.lxw_1_40);
        lxw_1_41 = (EditText) findViewById(R.id.lxw_1_41);
        lxw_1_42 = (EditText) findViewById(R.id.lxw_1_42);
        lxw_1_43 = (EditText) findViewById(R.id.lxw_1_43);
        lxw_1_44 = (EditText) findViewById(R.id.lxw_1_44);
        lxw_1_45 = (EditText) findViewById(R.id.lxw_1_45);
        lxw_1_50 = (EditText) findViewById(R.id.lxw_1_50);
        lxw_1_51 = (EditText) findViewById(R.id.lxw_1_51);
        lxw_1_52 = (EditText) findViewById(R.id.lxw_1_52);
        lxw_1_53 = (EditText) findViewById(R.id.lxw_1_53);
        lxw_1_54 = (EditText) findViewById(R.id.lxw_1_54);
        lxw_1_55 = (EditText) findViewById(R.id.lxw_1_55);
        lxw_1_60 = (EditText) findViewById(R.id.lxw_1_60);
        lxw_1_61 = (EditText) findViewById(R.id.lxw_1_61);
        lxw_1_62 = (EditText) findViewById(R.id.lxw_1_62);
        lxw_1_63 = (EditText) findViewById(R.id.lxw_1_63);
        lxw_1_64 = (EditText) findViewById(R.id.lxw_1_64);
        lxw_1_65 = (EditText) findViewById(R.id.lxw_1_65);
        lxw_1_70 = (EditText) findViewById(R.id.lxw_1_70);
        lxw_1_71 = (EditText) findViewById(R.id.lxw_1_71);
        lxw_1_72 = (EditText) findViewById(R.id.lxw_1_72);
        lxw_1_73 = (EditText) findViewById(R.id.lxw_1_73);
        lxw_1_74 = (EditText) findViewById(R.id.lxw_1_74);
        lxw_1_75 = (EditText) findViewById(R.id.lxw_1_75);
        lxw_1_80 = (EditText) findViewById(R.id.lxw_1_80);
        lxw_1_81 = (EditText) findViewById(R.id.lxw_1_81);
        lxw_1_82 = (EditText) findViewById(R.id.lxw_1_82);
        lxw_1_83 = (EditText) findViewById(R.id.lxw_1_83);
        lxw_1_84 = (EditText) findViewById(R.id.lxw_1_84);
        lxw_1_85 = (EditText) findViewById(R.id.lxw_1_85);
        lxw_1_90 = (EditText) findViewById(R.id.lxw_1_90);
        lxw_1_91 = (EditText) findViewById(R.id.lxw_1_91);
        lxw_1_92 = (EditText) findViewById(R.id.lxw_1_92);
        lxw_1_93 = (EditText) findViewById(R.id.lxw_1_93);
        lxw_1_94 = (EditText) findViewById(R.id.lxw_1_94);
        lxw_1_95 = (EditText) findViewById(R.id.lxw_1_95);

        lxw_2_00 = (EditText) findViewById(R.id.lxw_2_00);
        lxw_2_01 = (EditText) findViewById(R.id.lxw_2_01);
        lxw_2_10 = (EditText) findViewById(R.id.lxw_2_10);
        lxw_2_11 = (EditText) findViewById(R.id.lxw_2_11);
        lxw_2_20 = (EditText) findViewById(R.id.lxw_2_20);
        lxw_2_21 = (EditText) findViewById(R.id.lxw_2_21);
        lxw_2_30 = (EditText) findViewById(R.id.lxw_2_30);
        lxw_2_31 = (EditText) findViewById(R.id.lxw_2_31);
        lxw_2_40 = (EditText) findViewById(R.id.lxw_2_40);
        lxw_2_41 = (EditText) findViewById(R.id.lxw_2_41);
        lxw_2_50 = (EditText) findViewById(R.id.lxw_2_50);
        lxw_2_51 = (EditText) findViewById(R.id.lxw_2_51);
        lxw_2_60 = (EditText) findViewById(R.id.lxw_2_60);
        lxw_2_61 = (EditText) findViewById(R.id.lxw_2_61);
        lxw_2_70 = (EditText) findViewById(R.id.lxw_2_70);
        lxw_2_71 = (EditText) findViewById(R.id.lxw_2_71);
        lxw_2_80 = (EditText) findViewById(R.id.lxw_2_80);
        lxw_2_81 = (EditText) findViewById(R.id.lxw_2_81);
        lxw_2_90 = (EditText) findViewById(R.id.lxw_2_90);
        lxw_2_91 = (EditText) findViewById(R.id.lxw_2_91);
        //体育舞蹈
        tywd_1_00 = (EditText) findViewById(R.id.tywd_1_00);
        tywd_1_01 = (EditText) findViewById(R.id.tywd_1_01);
        tywd_1_02 = (EditText) findViewById(R.id.tywd_1_02);
        tywd_1_03 = (EditText) findViewById(R.id.tywd_1_03);
        tywd_1_10 = (EditText) findViewById(R.id.tywd_1_10);
        tywd_1_11 = (EditText) findViewById(R.id.tywd_1_11);
        tywd_1_12 = (EditText) findViewById(R.id.tywd_1_12);
        tywd_1_13 = (EditText) findViewById(R.id.tywd_1_13);
        tywd_1_20 = (EditText) findViewById(R.id.tywd_1_20);
        tywd_1_21 = (EditText) findViewById(R.id.tywd_1_21);
        tywd_1_22 = (EditText) findViewById(R.id.tywd_1_22);
        tywd_1_23 = (EditText) findViewById(R.id.tywd_1_23);
        tywd_1_30 = (EditText) findViewById(R.id.tywd_1_30);
        tywd_1_31 = (EditText) findViewById(R.id.tywd_1_31);
        tywd_1_32 = (EditText) findViewById(R.id.tywd_1_32);
        tywd_1_33 = (EditText) findViewById(R.id.tywd_1_33);
        tywd_1_40 = (EditText) findViewById(R.id.tywd_1_40);
        tywd_1_41 = (EditText) findViewById(R.id.tywd_1_41);
        tywd_1_42 = (EditText) findViewById(R.id.tywd_1_42);
        tywd_1_43 = (EditText) findViewById(R.id.tywd_1_43);
        tywd_1_50 = (EditText) findViewById(R.id.tywd_1_50);
        tywd_1_51 = (EditText) findViewById(R.id.tywd_1_51);
        tywd_1_52 = (EditText) findViewById(R.id.tywd_1_52);
        tywd_1_53 = (EditText) findViewById(R.id.tywd_1_53);
        tywd_1_60 = (EditText) findViewById(R.id.tywd_1_60);
        tywd_1_61 = (EditText) findViewById(R.id.tywd_1_61);
        tywd_1_62 = (EditText) findViewById(R.id.tywd_1_62);
        tywd_1_63 = (EditText) findViewById(R.id.tywd_1_63);
        tywd_1_70 = (EditText) findViewById(R.id.tywd_1_70);
        tywd_1_71 = (EditText) findViewById(R.id.tywd_1_71);
        tywd_1_72 = (EditText) findViewById(R.id.tywd_1_72);
        tywd_1_73 = (EditText) findViewById(R.id.tywd_1_73);
        tywd_1_80 = (EditText) findViewById(R.id.tywd_1_80);
        tywd_1_81 = (EditText) findViewById(R.id.tywd_1_81);
        tywd_1_82 = (EditText) findViewById(R.id.tywd_1_82);
        tywd_1_83 = (EditText) findViewById(R.id.tywd_1_83);
        tywd_1_90 = (EditText) findViewById(R.id.tywd_1_90);
        tywd_1_91 = (EditText) findViewById(R.id.tywd_1_91);
        tywd_1_92 = (EditText) findViewById(R.id.tywd_1_92);
        tywd_1_93 = (EditText) findViewById(R.id.tywd_1_93);

        tywd_2_00 = (EditText) findViewById(R.id.tywd_2_00);
        tywd_2_01 = (EditText) findViewById(R.id.tywd_2_01);
        tywd_2_10 = (EditText) findViewById(R.id.tywd_2_10);
        tywd_2_11 = (EditText) findViewById(R.id.tywd_2_11);
        tywd_2_20 = (EditText) findViewById(R.id.tywd_2_20);
        tywd_2_21 = (EditText) findViewById(R.id.tywd_2_21);
        tywd_2_30 = (EditText) findViewById(R.id.tywd_2_30);
        tywd_2_31 = (EditText) findViewById(R.id.tywd_2_31);
        tywd_2_40 = (EditText) findViewById(R.id.tywd_2_40);
        tywd_2_41 = (EditText) findViewById(R.id.tywd_2_41);
        tywd_2_50 = (EditText) findViewById(R.id.tywd_2_50);
        tywd_2_51 = (EditText) findViewById(R.id.tywd_2_51);
        tywd_2_60 = (EditText) findViewById(R.id.tywd_2_60);
        tywd_2_61 = (EditText) findViewById(R.id.tywd_2_61);
        tywd_2_70 = (EditText) findViewById(R.id.tywd_2_70);
        tywd_2_71 = (EditText) findViewById(R.id.tywd_2_71);
        tywd_2_80 = (EditText) findViewById(R.id.tywd_2_80);
        tywd_2_81 = (EditText) findViewById(R.id.tywd_2_81);
        tywd_2_90 = (EditText) findViewById(R.id.tywd_2_90);
        tywd_2_91 = (EditText) findViewById(R.id.tywd_2_91);
        //舞蹈编导
        wdbd_1_00 = (EditText) findViewById(R.id.wdbd_1_00);
        wdbd_1_01 = (EditText) findViewById(R.id.wdbd_1_01);
        wdbd_1_02 = (EditText) findViewById(R.id.wdbd_1_02);
        wdbd_1_03 = (EditText) findViewById(R.id.wdbd_1_03);
        wdbd_1_04 = (EditText) findViewById(R.id.wdbd_1_04);
        wdbd_1_05 = (EditText) findViewById(R.id.wdbd_1_05);
        wdbd_1_10 = (EditText) findViewById(R.id.wdbd_1_10);
        wdbd_1_11 = (EditText) findViewById(R.id.wdbd_1_11);
        wdbd_1_12 = (EditText) findViewById(R.id.wdbd_1_12);
        wdbd_1_13 = (EditText) findViewById(R.id.wdbd_1_13);
        wdbd_1_14 = (EditText) findViewById(R.id.wdbd_1_14);
        wdbd_1_15 = (EditText) findViewById(R.id.wdbd_1_15);
        wdbd_1_20 = (EditText) findViewById(R.id.wdbd_1_20);
        wdbd_1_21 = (EditText) findViewById(R.id.wdbd_1_21);
        wdbd_1_22 = (EditText) findViewById(R.id.wdbd_1_22);
        wdbd_1_23 = (EditText) findViewById(R.id.wdbd_1_23);
        wdbd_1_24 = (EditText) findViewById(R.id.wdbd_1_24);
        wdbd_1_25 = (EditText) findViewById(R.id.wdbd_1_25);
        wdbd_1_30 = (EditText) findViewById(R.id.wdbd_1_30);
        wdbd_1_31 = (EditText) findViewById(R.id.wdbd_1_31);
        wdbd_1_32 = (EditText) findViewById(R.id.wdbd_1_32);
        wdbd_1_33 = (EditText) findViewById(R.id.wdbd_1_33);
        wdbd_1_34 = (EditText) findViewById(R.id.wdbd_1_34);
        wdbd_1_35 = (EditText) findViewById(R.id.wdbd_1_35);
        wdbd_1_40 = (EditText) findViewById(R.id.wdbd_1_40);
        wdbd_1_41 = (EditText) findViewById(R.id.wdbd_1_41);
        wdbd_1_42 = (EditText) findViewById(R.id.wdbd_1_42);
        wdbd_1_43 = (EditText) findViewById(R.id.wdbd_1_43);
        wdbd_1_44 = (EditText) findViewById(R.id.wdbd_1_44);
        wdbd_1_45 = (EditText) findViewById(R.id.wdbd_1_45);
        wdbd_1_50 = (EditText) findViewById(R.id.wdbd_1_50);
        wdbd_1_51 = (EditText) findViewById(R.id.wdbd_1_51);
        wdbd_1_52 = (EditText) findViewById(R.id.wdbd_1_52);
        wdbd_1_53 = (EditText) findViewById(R.id.wdbd_1_53);
        wdbd_1_54 = (EditText) findViewById(R.id.wdbd_1_54);
        wdbd_1_55 = (EditText) findViewById(R.id.wdbd_1_55);
        wdbd_1_60 = (EditText) findViewById(R.id.wdbd_1_60);
        wdbd_1_61 = (EditText) findViewById(R.id.wdbd_1_61);
        wdbd_1_62 = (EditText) findViewById(R.id.wdbd_1_62);
        wdbd_1_63 = (EditText) findViewById(R.id.wdbd_1_63);
        wdbd_1_64 = (EditText) findViewById(R.id.wdbd_1_64);
        wdbd_1_65 = (EditText) findViewById(R.id.wdbd_1_65);
        wdbd_1_70 = (EditText) findViewById(R.id.wdbd_1_70);
        wdbd_1_71 = (EditText) findViewById(R.id.wdbd_1_71);
        wdbd_1_72 = (EditText) findViewById(R.id.wdbd_1_72);
        wdbd_1_73 = (EditText) findViewById(R.id.wdbd_1_73);
        wdbd_1_74 = (EditText) findViewById(R.id.wdbd_1_74);
        wdbd_1_75 = (EditText) findViewById(R.id.wdbd_1_75);
        wdbd_1_80 = (EditText) findViewById(R.id.wdbd_1_80);
        wdbd_1_81 = (EditText) findViewById(R.id.wdbd_1_81);
        wdbd_1_82 = (EditText) findViewById(R.id.wdbd_1_82);
        wdbd_1_83 = (EditText) findViewById(R.id.wdbd_1_83);
        wdbd_1_84 = (EditText) findViewById(R.id.wdbd_1_84);
        wdbd_1_85 = (EditText) findViewById(R.id.wdbd_1_85);
        wdbd_1_90 = (EditText) findViewById(R.id.wdbd_1_90);
        wdbd_1_91 = (EditText) findViewById(R.id.wdbd_1_91);
        wdbd_1_92 = (EditText) findViewById(R.id.wdbd_1_92);
        wdbd_1_93 = (EditText) findViewById(R.id.wdbd_1_93);
        wdbd_1_94 = (EditText) findViewById(R.id.wdbd_1_94);
        wdbd_1_95 = (EditText) findViewById(R.id.wdbd_1_95);

        wdbd_2_00 = (EditText) findViewById(R.id.wdbd_2_00);
        wdbd_2_01 = (EditText) findViewById(R.id.wdbd_2_01);
        wdbd_2_10 = (EditText) findViewById(R.id.wdbd_2_10);
        wdbd_2_11 = (EditText) findViewById(R.id.wdbd_2_11);
        wdbd_2_20 = (EditText) findViewById(R.id.wdbd_2_20);
        wdbd_2_21 = (EditText) findViewById(R.id.wdbd_2_21);
        wdbd_2_30 = (EditText) findViewById(R.id.wdbd_2_30);
        wdbd_2_31 = (EditText) findViewById(R.id.wdbd_2_31);
        wdbd_2_40 = (EditText) findViewById(R.id.wdbd_2_40);
        wdbd_2_41 = (EditText) findViewById(R.id.wdbd_2_41);
        wdbd_2_50 = (EditText) findViewById(R.id.wdbd_2_50);
        wdbd_2_51 = (EditText) findViewById(R.id.wdbd_2_51);
        wdbd_2_60 = (EditText) findViewById(R.id.wdbd_2_60);
        wdbd_2_61 = (EditText) findViewById(R.id.wdbd_2_61);
        wdbd_2_70 = (EditText) findViewById(R.id.wdbd_2_70);
        wdbd_2_71 = (EditText) findViewById(R.id.wdbd_2_71);
        wdbd_2_80 = (EditText) findViewById(R.id.wdbd_2_80);
        wdbd_2_81 = (EditText) findViewById(R.id.wdbd_2_81);
        wdbd_2_90 = (EditText) findViewById(R.id.wdbd_2_90);
        wdbd_2_91 = (EditText) findViewById(R.id.wdbd_2_91);
        //中国舞
        zgw_1_00 = (EditText) findViewById(R.id.zgw_1_00);
        zgw_1_01 = (EditText) findViewById(R.id.zgw_1_01);
        zgw_1_02 = (EditText) findViewById(R.id.zgw_1_02);
        zgw_1_03 = (EditText) findViewById(R.id.zgw_1_03);
        zgw_1_04 = (EditText) findViewById(R.id.zgw_1_04);
        zgw_1_05 = (EditText) findViewById(R.id.zgw_1_05);
        zgw_1_10 = (EditText) findViewById(R.id.zgw_1_10);
        zgw_1_11 = (EditText) findViewById(R.id.zgw_1_11);
        zgw_1_12 = (EditText) findViewById(R.id.zgw_1_12);
        zgw_1_13 = (EditText) findViewById(R.id.zgw_1_13);
        zgw_1_14 = (EditText) findViewById(R.id.zgw_1_14);
        zgw_1_15 = (EditText) findViewById(R.id.zgw_1_15);
        zgw_1_20 = (EditText) findViewById(R.id.zgw_1_20);
        zgw_1_21 = (EditText) findViewById(R.id.zgw_1_21);
        zgw_1_22 = (EditText) findViewById(R.id.zgw_1_22);
        zgw_1_23 = (EditText) findViewById(R.id.zgw_1_23);
        zgw_1_24 = (EditText) findViewById(R.id.zgw_1_24);
        zgw_1_25 = (EditText) findViewById(R.id.zgw_1_25);
        zgw_1_30 = (EditText) findViewById(R.id.zgw_1_30);
        zgw_1_31 = (EditText) findViewById(R.id.zgw_1_31);
        zgw_1_32 = (EditText) findViewById(R.id.zgw_1_32);
        zgw_1_33 = (EditText) findViewById(R.id.zgw_1_33);
        zgw_1_34 = (EditText) findViewById(R.id.zgw_1_34);
        zgw_1_35 = (EditText) findViewById(R.id.zgw_1_35);
        zgw_1_40 = (EditText) findViewById(R.id.zgw_1_40);
        zgw_1_41 = (EditText) findViewById(R.id.zgw_1_41);
        zgw_1_42 = (EditText) findViewById(R.id.zgw_1_42);
        zgw_1_43 = (EditText) findViewById(R.id.zgw_1_43);
        zgw_1_44 = (EditText) findViewById(R.id.zgw_1_44);
        zgw_1_45 = (EditText) findViewById(R.id.zgw_1_45);
        zgw_1_50 = (EditText) findViewById(R.id.zgw_1_50);
        zgw_1_51 = (EditText) findViewById(R.id.zgw_1_51);
        zgw_1_52 = (EditText) findViewById(R.id.zgw_1_52);
        zgw_1_53 = (EditText) findViewById(R.id.zgw_1_53);
        zgw_1_54 = (EditText) findViewById(R.id.zgw_1_54);
        zgw_1_55 = (EditText) findViewById(R.id.zgw_1_55);
        zgw_1_60 = (EditText) findViewById(R.id.zgw_1_60);
        zgw_1_61 = (EditText) findViewById(R.id.zgw_1_61);
        zgw_1_62 = (EditText) findViewById(R.id.zgw_1_62);
        zgw_1_63 = (EditText) findViewById(R.id.zgw_1_63);
        zgw_1_64 = (EditText) findViewById(R.id.zgw_1_64);
        zgw_1_65 = (EditText) findViewById(R.id.zgw_1_65);
        zgw_1_70 = (EditText) findViewById(R.id.zgw_1_70);
        zgw_1_71 = (EditText) findViewById(R.id.zgw_1_71);
        zgw_1_72 = (EditText) findViewById(R.id.zgw_1_72);
        zgw_1_73 = (EditText) findViewById(R.id.zgw_1_73);
        zgw_1_74 = (EditText) findViewById(R.id.zgw_1_74);
        zgw_1_75 = (EditText) findViewById(R.id.zgw_1_75);
        zgw_1_80 = (EditText) findViewById(R.id.zgw_1_80);
        zgw_1_81 = (EditText) findViewById(R.id.zgw_1_81);
        zgw_1_82 = (EditText) findViewById(R.id.zgw_1_82);
        zgw_1_83 = (EditText) findViewById(R.id.zgw_1_83);
        zgw_1_84 = (EditText) findViewById(R.id.zgw_1_84);
        zgw_1_85 = (EditText) findViewById(R.id.zgw_1_85);
        zgw_1_90 = (EditText) findViewById(R.id.zgw_1_90);
        zgw_1_91 = (EditText) findViewById(R.id.zgw_1_91);
        zgw_1_92 = (EditText) findViewById(R.id.zgw_1_92);
        zgw_1_93 = (EditText) findViewById(R.id.zgw_1_93);
        zgw_1_94 = (EditText) findViewById(R.id.zgw_1_94);
        zgw_1_95 = (EditText) findViewById(R.id.zgw_1_95);

        zgw_2_00 = (EditText) findViewById(R.id.zgw_2_00);
        zgw_2_01 = (EditText) findViewById(R.id.zgw_2_01);
        zgw_2_10 = (EditText) findViewById(R.id.zgw_2_10);
        zgw_2_11 = (EditText) findViewById(R.id.zgw_2_11);
        zgw_2_20 = (EditText) findViewById(R.id.zgw_2_20);
        zgw_2_21 = (EditText) findViewById(R.id.zgw_2_21);
        zgw_2_30 = (EditText) findViewById(R.id.zgw_2_30);
        zgw_2_31 = (EditText) findViewById(R.id.zgw_2_31);
        zgw_2_40 = (EditText) findViewById(R.id.zgw_2_40);
        zgw_2_41 = (EditText) findViewById(R.id.zgw_2_41);
        zgw_2_50 = (EditText) findViewById(R.id.zgw_2_50);
        zgw_2_51 = (EditText) findViewById(R.id.zgw_2_51);
        zgw_2_60 = (EditText) findViewById(R.id.zgw_2_60);
        zgw_2_61 = (EditText) findViewById(R.id.zgw_2_61);
        zgw_2_70 = (EditText) findViewById(R.id.zgw_2_70);
        zgw_2_71 = (EditText) findViewById(R.id.zgw_2_71);
        zgw_2_80 = (EditText) findViewById(R.id.zgw_2_80);
        zgw_2_81 = (EditText) findViewById(R.id.zgw_2_81);
        zgw_2_90 = (EditText) findViewById(R.id.zgw_2_90);
        zgw_2_91 = (EditText) findViewById(R.id.zgw_2_91);
        //胸牌号
        fzby1_x1 = (TextView) findViewById(R.id.fzby1_x1);
        fzby1_x2 = (TextView) findViewById(R.id.fzby1_x2);
        fzby1_x3 = (TextView) findViewById(R.id.fzby1_x3);
        fzby1_x4 = (TextView) findViewById(R.id.fzby1_x4);
        fzby1_x5 = (TextView) findViewById(R.id.fzby1_x5);
        fzby1_x6 = (TextView) findViewById(R.id.fzby1_x6);
        fzby1_x7 = (TextView) findViewById(R.id.fzby1_x7);
        fzby1_x8 = (TextView) findViewById(R.id.fzby1_x8);
        fzby1_x9 = (TextView) findViewById(R.id.fzby1_x9);
        fzby1_x10 = (TextView) findViewById(R.id.fzby1_x10);
        fzby2_x1 = (TextView) findViewById(R.id.fzby2_x1);
        fzby2_x2 = (TextView) findViewById(R.id.fzby2_x2);
        fzby2_x3 = (TextView) findViewById(R.id.fzby2_x3);
        fzby2_x4 = (TextView) findViewById(R.id.fzby2_x4);
        fzby2_x5 = (TextView) findViewById(R.id.fzby2_x5);
        fzby2_x6 = (TextView) findViewById(R.id.fzby2_x6);
        fzby2_x7 = (TextView) findViewById(R.id.fzby2_x7);
        fzby2_x8 = (TextView) findViewById(R.id.fzby2_x8);
        fzby2_x9 = (TextView) findViewById(R.id.fzby2_x9);
        fzby2_x10 = (TextView) findViewById(R.id.fzby2_x10);
        jmc1_x1 = (TextView) findViewById(R.id.jmc1_x1);
        jmc1_x2 = (TextView) findViewById(R.id.jmc1_x2);
        jmc1_x3 = (TextView) findViewById(R.id.jmc1_x3);
        jmc1_x4 = (TextView) findViewById(R.id.jmc1_x4);
        jmc1_x5 = (TextView) findViewById(R.id.jmc1_x5);
        jmc1_x6 = (TextView) findViewById(R.id.jmc1_x6);
        jmc1_x7 = (TextView) findViewById(R.id.jmc1_x7);
        jmc1_x8 = (TextView) findViewById(R.id.jmc1_x8);
        jmc1_x9 = (TextView) findViewById(R.id.jmc1_x9);
        jmc1_x10 = (TextView) findViewById(R.id.jmc1_x10);
        jmc2_x1 = (TextView) findViewById(R.id.jmc2_x1);
        jmc2_x2 = (TextView) findViewById(R.id.jmc2_x2);
        jmc2_x3 = (TextView) findViewById(R.id.jmc2_x3);
        jmc2_x4 = (TextView) findViewById(R.id.jmc2_x4);
        jmc2_x5 = (TextView) findViewById(R.id.jmc2_x5);
        jmc2_x6 = (TextView) findViewById(R.id.jmc2_x6);
        jmc2_x7 = (TextView) findViewById(R.id.jmc2_x7);
        jmc2_x8 = (TextView) findViewById(R.id.jmc2_x8);
        jmc2_x9 = (TextView) findViewById(R.id.jmc2_x9);
        jmc2_x10 = (TextView) findViewById(R.id.jmc2_x10);
        llc1_x1 = (TextView) findViewById(R.id.llc1_x1);
        llc1_x2 = (TextView) findViewById(R.id.llc1_x2);
        llc1_x3 = (TextView) findViewById(R.id.llc1_x3);
        llc1_x4 = (TextView) findViewById(R.id.llc1_x4);
        llc1_x5 = (TextView) findViewById(R.id.llc1_x5);
        llc1_x6 = (TextView) findViewById(R.id.llc1_x6);
        llc1_x7 = (TextView) findViewById(R.id.llc1_x7);
        llc1_x8 = (TextView) findViewById(R.id.llc1_x8);
        llc1_x9 = (TextView) findViewById(R.id.llc1_x9);
        llc1_x10 = (TextView) findViewById(R.id.llc1_x10);
        llc2_x1 = (TextView) findViewById(R.id.llc2_x1);
        llc2_x2 = (TextView) findViewById(R.id.llc2_x2);
        llc2_x3 = (TextView) findViewById(R.id.llc2_x3);
        llc2_x4 = (TextView) findViewById(R.id.llc2_x4);
        llc2_x5 = (TextView) findViewById(R.id.llc2_x5);
        llc2_x6 = (TextView) findViewById(R.id.llc2_x6);
        llc2_x7 = (TextView) findViewById(R.id.llc2_x7);
        llc2_x8 = (TextView) findViewById(R.id.llc2_x8);
        llc2_x9 = (TextView) findViewById(R.id.llc2_x9);
        llc2_x10 = (TextView) findViewById(R.id.llc2_x10);
        lxw1_x1 = (TextView) findViewById(R.id.lxw1_x1);
        lxw1_x2 = (TextView) findViewById(R.id.lxw1_x2);
        lxw1_x3 = (TextView) findViewById(R.id.lxw1_x3);
        lxw1_x4 = (TextView) findViewById(R.id.lxw1_x4);
        lxw1_x5 = (TextView) findViewById(R.id.lxw1_x5);
        lxw1_x6 = (TextView) findViewById(R.id.lxw1_x6);
        lxw1_x7 = (TextView) findViewById(R.id.lxw1_x7);
        lxw1_x8 = (TextView) findViewById(R.id.lxw1_x8);
        lxw1_x9 = (TextView) findViewById(R.id.lxw1_x9);
        lxw1_x10 = (TextView) findViewById(R.id.lxw1_x10);
        lxw2_x1 = (TextView) findViewById(R.id.lxw2_x1);
        lxw2_x2 = (TextView) findViewById(R.id.lxw2_x2);
        lxw2_x3 = (TextView) findViewById(R.id.lxw2_x3);
        lxw2_x4 = (TextView) findViewById(R.id.lxw2_x4);
        lxw2_x5 = (TextView) findViewById(R.id.lxw2_x5);
        lxw2_x6 = (TextView) findViewById(R.id.lxw2_x6);
        lxw2_x7 = (TextView) findViewById(R.id.lxw2_x7);
        lxw2_x8 = (TextView) findViewById(R.id.lxw2_x8);
        lxw2_x9 = (TextView) findViewById(R.id.lxw2_x9);
        lxw2_x10 = (TextView) findViewById(R.id.lxw2_x10);
        tywd1_x1 = (TextView) findViewById(R.id.tywd1_x1);
        tywd1_x2 = (TextView) findViewById(R.id.tywd1_x2);
        tywd1_x3 = (TextView) findViewById(R.id.tywd1_x3);
        tywd1_x4 = (TextView) findViewById(R.id.tywd1_x4);
        tywd1_x5 = (TextView) findViewById(R.id.tywd1_x5);
        tywd1_x6 = (TextView) findViewById(R.id.tywd1_x6);
        tywd1_x7 = (TextView) findViewById(R.id.tywd1_x7);
        tywd1_x8 = (TextView) findViewById(R.id.tywd1_x8);
        tywd1_x9 = (TextView) findViewById(R.id.tywd1_x9);
        tywd1_x10 = (TextView) findViewById(R.id.tywd1_x10);
        tywd2_x1 = (TextView) findViewById(R.id.tywd2_x1);
        tywd2_x2 = (TextView) findViewById(R.id.tywd2_x2);
        tywd2_x3 = (TextView) findViewById(R.id.tywd2_x3);
        tywd2_x4 = (TextView) findViewById(R.id.tywd2_x4);
        tywd2_x5 = (TextView) findViewById(R.id.tywd2_x5);
        tywd2_x6 = (TextView) findViewById(R.id.tywd2_x6);
        tywd2_x7 = (TextView) findViewById(R.id.tywd2_x7);
        tywd2_x8 = (TextView) findViewById(R.id.tywd2_x8);
        tywd2_x9 = (TextView) findViewById(R.id.tywd2_x9);
        tywd2_x10 = (TextView) findViewById(R.id.tywd2_x10);
        wdbd1_x1 = (TextView) findViewById(R.id.wdbd1_x1);
        wdbd1_x2 = (TextView) findViewById(R.id.wdbd1_x2);
        wdbd1_x3 = (TextView) findViewById(R.id.wdbd1_x3);
        wdbd1_x4 = (TextView) findViewById(R.id.wdbd1_x4);
        wdbd1_x5 = (TextView) findViewById(R.id.wdbd1_x5);
        wdbd1_x6 = (TextView) findViewById(R.id.wdbd1_x6);
        wdbd1_x7 = (TextView) findViewById(R.id.wdbd1_x7);
        wdbd1_x8 = (TextView) findViewById(R.id.wdbd1_x8);
        wdbd1_x9 = (TextView) findViewById(R.id.wdbd1_x9);
        wdbd1_x10 = (TextView) findViewById(R.id.wdbd1_x10);
        wdbd2_x1 = (TextView) findViewById(R.id.wdbd2_x1);
        wdbd2_x2 = (TextView) findViewById(R.id.wdbd2_x2);
        wdbd2_x3 = (TextView) findViewById(R.id.wdbd2_x3);
        wdbd2_x4 = (TextView) findViewById(R.id.wdbd2_x4);
        wdbd2_x5 = (TextView) findViewById(R.id.wdbd2_x5);
        wdbd2_x6 = (TextView) findViewById(R.id.wdbd2_x6);
        wdbd2_x7 = (TextView) findViewById(R.id.wdbd2_x7);
        wdbd2_x8 = (TextView) findViewById(R.id.wdbd2_x8);
        wdbd2_x9 = (TextView) findViewById(R.id.wdbd2_x9);
        wdbd2_x10 = (TextView) findViewById(R.id.wdbd2_x10);
        zgw1_x1 = (TextView) findViewById(R.id.zgw1_x1);
        zgw1_x2 = (TextView) findViewById(R.id.zgw1_x2);
        zgw1_x3 = (TextView) findViewById(R.id.zgw1_x3);
        zgw1_x4 = (TextView) findViewById(R.id.zgw1_x4);
        zgw1_x5 = (TextView) findViewById(R.id.zgw1_x5);
        zgw1_x6 = (TextView) findViewById(R.id.zgw1_x6);
        zgw1_x7 = (TextView) findViewById(R.id.zgw1_x7);
        zgw1_x8 = (TextView) findViewById(R.id.zgw1_x8);
        zgw1_x9 = (TextView) findViewById(R.id.zgw1_x9);
        zgw1_x10 = (TextView) findViewById(R.id.zgw1_x10);
        zgw2_x1 = (TextView) findViewById(R.id.zgw2_x1);
        zgw2_x2 = (TextView) findViewById(R.id.zgw2_x2);
        zgw2_x3 = (TextView) findViewById(R.id.zgw2_x3);
        zgw2_x4 = (TextView) findViewById(R.id.zgw2_x4);
        zgw2_x5 = (TextView) findViewById(R.id.zgw2_x5);
        zgw2_x6 = (TextView) findViewById(R.id.zgw2_x6);
        zgw2_x7 = (TextView) findViewById(R.id.zgw2_x7);
        zgw2_x8 = (TextView) findViewById(R.id.zgw2_x8);
        zgw2_x9 = (TextView) findViewById(R.id.zgw2_x9);
        zgw2_x10 = (TextView) findViewById(R.id.zgw2_x10);
        fzby1_xph = new TextView[]{fzby1_x1, fzby1_x2, fzby1_x3, fzby1_x4, fzby1_x5, fzby1_x6, fzby1_x7, fzby1_x8, fzby1_x9, fzby1_x10};
        fzby2_xph = new TextView[]{fzby2_x1, fzby2_x2, fzby2_x3, fzby2_x4, fzby2_x5, fzby2_x6, fzby2_x7, fzby2_x8, fzby2_x9, fzby2_x10};
        jmc1_xph = new TextView[]{jmc1_x1, jmc1_x2, jmc1_x3, jmc1_x4, jmc1_x5, jmc1_x6, jmc1_x7, jmc1_x8, jmc1_x9, jmc1_x10};
        jmc2_xph = new TextView[]{jmc2_x1, jmc2_x2, jmc2_x3, jmc2_x4, jmc2_x5, jmc2_x6, jmc2_x7, jmc2_x8, jmc2_x9, jmc2_x10};
        llc1_xph = new TextView[]{llc1_x1, llc1_x2, llc1_x3, llc1_x4, llc1_x5, llc1_x6, llc1_x7, llc1_x8, llc1_x9, llc1_x10};
        llc2_xph = new TextView[]{llc2_x1, llc2_x2, llc2_x3, llc2_x4, llc2_x5, llc2_x6, llc2_x7, llc2_x8, llc2_x9, llc2_x10};
        lxw1_xph = new TextView[]{lxw1_x1, lxw1_x2, lxw1_x3, lxw1_x4, lxw1_x5, lxw1_x6, lxw1_x7, lxw1_x8, lxw1_x9, lxw1_x10};
        lxw2_xph = new TextView[]{lxw2_x1, lxw2_x2, lxw2_x3, lxw2_x4, lxw2_x5, lxw2_x6, lxw2_x7, lxw2_x8, lxw2_x9, lxw2_x10};
        tywd1_xph = new TextView[]{tywd1_x1, tywd1_x2, tywd1_x3, tywd1_x4, tywd1_x5, tywd1_x6, tywd1_x7, tywd1_x8, tywd1_x9, tywd1_x10};
        tywd2_xph = new TextView[]{tywd2_x1, tywd2_x2, tywd2_x3, tywd2_x4, tywd2_x5, tywd2_x6, tywd2_x7, tywd2_x8, tywd2_x9, tywd2_x10};
        wdbd1_xph = new TextView[]{wdbd1_x1, wdbd1_x2, wdbd1_x3, wdbd1_x4, wdbd1_x5, wdbd1_x6, wdbd1_x7, wdbd1_x8, wdbd1_x9, wdbd1_x10};
        wdbd2_xph = new TextView[]{wdbd2_x1, wdbd2_x2, wdbd2_x3, wdbd2_x4, wdbd2_x5, wdbd2_x6, wdbd2_x7, wdbd2_x8, wdbd2_x9, wdbd2_x10};
        zgw1_xph = new TextView[]{zgw1_x1, zgw1_x2, zgw1_x3, zgw1_x4, zgw1_x5, zgw1_x6, zgw1_x7, zgw1_x8, zgw1_x9, zgw1_x10};
        zgw2_xph = new TextView[]{zgw2_x1, zgw2_x2, zgw2_x3, zgw2_x4, zgw2_x5, zgw2_x6, zgw2_x7, zgw2_x8, zgw2_x9, zgw2_x10};
    }
    //服装表演专业第一组
    public void fzby1() {
        FM_fzby1.setVisibility(View.VISIBLE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
    }

    //健美操第一组
    public void jmc1() {
        FM_jmc1.setVisibility(View.VISIBLE);
        FM_fzby1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_fzby2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
    }

    //啦啦操第一组
    public void llc1() {
        FM_llc1.setVisibility(View.VISIBLE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
    }

    //流行舞第一组
    public void lxw1() {
        FM_lxw1.setVisibility(View.VISIBLE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);

    }

    //体育舞蹈第一组
    public void tywd1() {
        FM_tywd1.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);

    }

    //舞蹈表演第一组
    public void wdbd1() {
        FM_wdbd1.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);
    }

    //中国舞第一组
    public void zgw1() {
        FM_zgw1.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
    }

    //服装表演第二组
    public void fzby2() {
        FM_fzby2.setVisibility(View.VISIBLE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);

    }

    //健美操第二组
    public void jmc2() {
        FM_jmc2.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);

    }

    //啦啦操第二组
    public void llc2() {
        FM_llc2.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);

    }

    //流行舞第二组
    public void lxw2() {
        FM_lxw2.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);

    }

    //体育舞蹈第二组
    public void tywd2() {
        FM_tywd2.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);

    }

    //舞蹈表演第二组
    public void wdbd2() {
        FM_wdbd2.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_zgw2.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);
    }

    //中国舞第二组
    public void zgw2() {
        FM_zgw2.setVisibility(View.VISIBLE);
        FM_fzby2.setVisibility(View.GONE);
        FM_jmc2.setVisibility(View.GONE);
        FM_llc2.setVisibility(View.GONE);
        FM_lxw2.setVisibility(View.GONE);
        FM_tywd2.setVisibility(View.GONE);
        FM_wdbd2.setVisibility(View.GONE);
        FM_zgw1.setVisibility(View.GONE);
        FM_fzby1.setVisibility(View.GONE);
        FM_jmc1.setVisibility(View.GONE);
        FM_llc1.setVisibility(View.GONE);
        FM_lxw1.setVisibility(View.GONE);
        FM_tywd1.setVisibility(View.GONE);
        FM_wdbd1.setVisibility(View.GONE);
    }

    //返回服装表演1的sql语句
    public String [] fzby1_InputDBTask(String[][] stringTemp) {
        try {
            int param=2;
            String sql[]=new String[param];
            String []totalSQL=new String[param*10];
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a]="INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + fuzhuangby1_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回服装表演2的sql语句
    public String [] fzby2_InputDBTask(String[][] stringTemp) {
        String []sql=new String[2];
        int param=2;
        String [] totalSQL=new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + fuzhuangby2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a]="INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + fuzhuangby2_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回健美操1的sql语句
    public String []jmc1_InputDBTask(String[][] stringTemp) {
        int param=4;
        String []sql=new String[param];
        String [] totalSQL=new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + jianmeic1_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回健美操2的sql语句
    public String [] jmc2_InputDBTask(String[][] stringTemp) {
        int param=1;
        String[] sql = new String[param];
        String [] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + jianmeic2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + jianmeic2_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回啦啦操1的sql语句
    public String [] llc1_InputDBTask(String[][] stringTemp) {
        int param=2;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + lalac1_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回啦啦操2的sql语句
    public String[] llc2_InputDBTask(String[][] stringTemp) {
        int param=1;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + lalac2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + lalac2_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回流行舞1的sql语句
    public String [] lxw1_InputDBTask(String[][] stringTemp) {
        int param=6;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                 case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + liuxingw1_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回流行舞2的sql语句
    public String [] lxw2_InputDBTask(String[][] stringTemp) {
        int param=2;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + liuxingw2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + liuxingw2_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回体育舞蹈1的sql语句
    public String [] tywd1_InputDBTask(String[][] stringTemp) {
        int param=4;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + tiyuwd1_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回体育舞蹈2的sql语句
    public String [] tywd2_InputDBTask(String[][] stringTemp) {
        int param=2;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + tiyuwd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + tiyuwd2_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回舞蹈编导1的sql语句
    public String [] wdbd1_InputDBTask(String[][] stringTemp) {
        int param=6;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + wudaobd1_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回舞蹈编导2的sql语句
    public String [] wdbd2_InputDBTask(String[][] stringTemp) {
        int param=2;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + wudaobd2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + wudaobd2_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回中国舞1的sql语句
    public String []zgw1_InputDBTask(String[][] stringTemp) {
        int param=6;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow1_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + zhongguow1_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //返回中国舞2的sql语句
    public String [] zgw2_InputDBTask(String[][] stringTemp) {
        int param = 2;
        String[] sql = new String[param];
        String[] totalSQL = new String[param*10];
        try {
            switch (submit_tag) {
                case "line1":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line2":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line3":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line4":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line5":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line6":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line7":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line8":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line9":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "line10":
                    for (int i=0;i<param;i++){
                        sql[i] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[button_tag][0] + "," +
                                "" + judgeIds + ","  + zhongguow2_projectIDs[i]+","+ stringTemp[button_tag][i+1] + ")";
                    }
                    return sql;
                case "lineTotal":
                    for (int i=0,a=0;i<10;i++){
                        for (int j=0;j<param;j++){
                            totalSQL[a] = "INSERT INTO yikao(xiongPaiHao,judgeID,projectID,mark)VALUES(" + stringTemp[i][0] + "," +
                                    "" + judgeIds + ","  + zhongguow2_projectIDs[j]+","+ stringTemp[i][j+1] + ")";
                            a++;
                        }
                    }
                    return totalSQL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //清空EditText方法
    public void clearText_fzby1() {
        fzby_1_00.setText("");
        fzby_1_01.setText("");
        fzby_1_10.setText("");
        fzby_1_11.setText("");
        fzby_1_20.setText("");
        fzby_1_21.setText("");
        fzby_1_30.setText("");
        fzby_1_31.setText("");
        fzby_1_40.setText("");
        fzby_1_41.setText("");
        fzby_1_50.setText("");
        fzby_1_51.setText("");
        fzby_1_60.setText("");
        fzby_1_61.setText("");
        fzby_1_70.setText("");
        fzby_1_71.setText("");
        fzby_1_80.setText("");
        fzby_1_81.setText("");
        fzby_1_90.setText("");
        fzby_1_91.setText("");
    }

    public void clearText_fzby2() {
        fzby_2_00.setText("");
        fzby_2_01.setText("");
        fzby_2_10.setText("");
        fzby_2_11.setText("");
        fzby_2_20.setText("");
        fzby_2_21.setText("");
        fzby_2_30.setText("");
        fzby_2_31.setText("");
        fzby_2_40.setText("");
        fzby_2_41.setText("");
        fzby_2_50.setText("");
        fzby_2_51.setText("");
        fzby_2_60.setText("");
        fzby_2_61.setText("");
        fzby_2_70.setText("");
        fzby_2_71.setText("");
        fzby_2_80.setText("");
        fzby_2_81.setText("");
        fzby_2_90.setText("");
        fzby_2_91.setText("");
    }

    public void clearText_jmc1() {
        jmc_1_00.setText("");
        jmc_1_01.setText("");
        jmc_1_02.setText("");
        jmc_1_03.setText("");
        jmc_1_10.setText("");
        jmc_1_11.setText("");
        jmc_1_12.setText("");
        jmc_1_13.setText("");
        jmc_1_20.setText("");
        jmc_1_21.setText("");
        jmc_1_22.setText("");
        jmc_1_23.setText("");
        jmc_1_30.setText("");
        jmc_1_31.setText("");
        jmc_1_32.setText("");
        jmc_1_33.setText("");
        jmc_1_40.setText("");
        jmc_1_41.setText("");
        jmc_1_42.setText("");
        jmc_1_43.setText("");
        jmc_1_50.setText("");
        jmc_1_51.setText("");
        jmc_1_52.setText("");
        jmc_1_53.setText("");
        jmc_1_60.setText("");
        jmc_1_61.setText("");
        jmc_1_62.setText("");
        jmc_1_63.setText("");
        jmc_1_70.setText("");
        jmc_1_71.setText("");
        jmc_1_72.setText("");
        jmc_1_73.setText("");
        jmc_1_80.setText("");
        jmc_1_81.setText("");
        jmc_1_82.setText("");
        jmc_1_83.setText("");
        jmc_1_90.setText("");
    }

    public void clearText_jmc2() {
        jmc_2_00.setText("");
        jmc_2_10.setText("");
        jmc_2_20.setText("");
        jmc_2_30.setText("");
        jmc_2_40.setText("");
        jmc_2_50.setText("");
        jmc_2_60.setText("");
        jmc_2_70.setText("");
        jmc_2_80.setText("");
        jmc_2_90.setText("");
    }

    public void clearText_llc1() {
        llc_1_00.setText("");
        llc_1_01.setText("");
        llc_1_10.setText("");
        llc_1_11.setText("");
        llc_1_20.setText("");
        llc_1_21.setText("");
        llc_1_30.setText("");
        llc_1_31.setText("");
        llc_1_40.setText("");
        llc_1_41.setText("");
        llc_1_50.setText("");
        llc_1_51.setText("");
        llc_1_60.setText("");
        llc_1_61.setText("");
        llc_1_70.setText("");
        llc_1_71.setText("");
        llc_1_80.setText("");
        llc_1_81.setText("");
        llc_1_90.setText("");
        llc_1_91.setText("");
    }

    public void clearText_llc2() {
        llc_2_00.setText("");
        llc_2_10.setText("");
        llc_2_20.setText("");
        llc_2_30.setText("");
        llc_2_40.setText("");
        llc_2_50.setText("");
        llc_2_60.setText("");
        llc_2_70.setText("");
        llc_2_80.setText("");
        llc_2_90.setText("");
    }

    public void clearText_lxw1() {
        lxw_1_00.setText("");
        lxw_1_01.setText("");
        lxw_1_02.setText("");
        lxw_1_03.setText("");
        lxw_1_04.setText("");
        lxw_1_05.setText("");
        lxw_1_10.setText("");
        lxw_1_11.setText("");
        lxw_1_12.setText("");
        lxw_1_13.setText("");
        lxw_1_14.setText("");
        lxw_1_15.setText("");
        lxw_1_20.setText("");
        lxw_1_21.setText("");
        lxw_1_22.setText("");
        lxw_1_23.setText("");
        lxw_1_24.setText("");
        lxw_1_25.setText("");
        lxw_1_30.setText("");
        lxw_1_31.setText("");
        lxw_1_32.setText("");
        lxw_1_33.setText("");
        lxw_1_34.setText("");
        lxw_1_35.setText("");
        lxw_1_40.setText("");
        lxw_1_41.setText("");
        lxw_1_42.setText("");
        lxw_1_43.setText("");
        lxw_1_44.setText("");
        lxw_1_45.setText("");
        lxw_1_50.setText("");
        lxw_1_51.setText("");
        lxw_1_52.setText("");
        lxw_1_53.setText("");
        lxw_1_54.setText("");
        lxw_1_55.setText("");
        lxw_1_60.setText("");
        lxw_1_61.setText("");
        lxw_1_62.setText("");
        lxw_1_63.setText("");
        lxw_1_64.setText("");
        lxw_1_65.setText("");
        lxw_1_70.setText("");
        lxw_1_71.setText("");
        lxw_1_72.setText("");
        lxw_1_73.setText("");
        lxw_1_74.setText("");
        lxw_1_75.setText("");
        lxw_1_80.setText("");
        lxw_1_81.setText("");
        lxw_1_82.setText("");
        lxw_1_83.setText("");
        lxw_1_84.setText("");
        lxw_1_85.setText("");
        lxw_1_90.setText("");
        lxw_1_91.setText("");
        lxw_1_92.setText("");
        lxw_1_93.setText("");
        lxw_1_94.setText("");
        lxw_1_95.setText("");
    }

    public void clearText_lxw2() {
        lxw_2_00.setText("");
        lxw_2_01.setText("");
        lxw_2_10.setText("");
        lxw_2_11.setText("");
        lxw_2_20.setText("");
        lxw_2_21.setText("");
        lxw_2_30.setText("");
        lxw_2_31.setText("");
        lxw_2_40.setText("");
        lxw_2_41.setText("");
        lxw_2_50.setText("");
        lxw_2_51.setText("");
        lxw_2_60.setText("");
        lxw_2_61.setText("");
        lxw_2_70.setText("");
        lxw_2_71.setText("");
        lxw_2_80.setText("");
        lxw_2_81.setText("");
        lxw_2_90.setText("");
        lxw_2_91.setText("");
    }

    public void clearText_tywd1() {
        tywd_1_00.setText("");
        tywd_1_01.setText("");
        tywd_1_02.setText("");
        tywd_1_03.setText("");
        tywd_1_10.setText("");
        tywd_1_11.setText("");
        tywd_1_12.setText("");
        tywd_1_13.setText("");
        tywd_1_20.setText("");
        tywd_1_21.setText("");
        tywd_1_22.setText("");
        tywd_1_23.setText("");
        tywd_1_30.setText("");
        tywd_1_31.setText("");
        tywd_1_32.setText("");
        tywd_1_33.setText("");
        tywd_1_40.setText("");
        tywd_1_41.setText("");
        tywd_1_42.setText("");
        tywd_1_43.setText("");
        tywd_1_50.setText("");
        tywd_1_51.setText("");
        tywd_1_52.setText("");
        tywd_1_53.setText("");
        tywd_1_60.setText("");
        tywd_1_61.setText("");
        tywd_1_62.setText("");
        tywd_1_63.setText("");
        tywd_1_70.setText("");
        tywd_1_71.setText("");
        tywd_1_72.setText("");
        tywd_1_73.setText("");
        tywd_1_80.setText("");
        tywd_1_81.setText("");
        tywd_1_82.setText("");
        tywd_1_83.setText("");
        tywd_1_90.setText("");
        tywd_1_91.setText("");
        tywd_1_92.setText("");
        tywd_1_93.setText("");
    }

    public void clearText_tywd2() {
        tywd_2_00.setText("");
        tywd_2_01.setText("");
        tywd_2_10.setText("");
        tywd_2_11.setText("");
        tywd_2_20.setText("");
        tywd_2_21.setText("");
        tywd_2_30.setText("");
        tywd_2_31.setText("");
        tywd_2_40.setText("");
        tywd_2_41.setText("");
        tywd_2_50.setText("");
        tywd_2_51.setText("");
        tywd_2_60.setText("");
        tywd_2_61.setText("");
        tywd_2_70.setText("");
        tywd_2_71.setText("");
        tywd_2_80.setText("");
        tywd_2_81.setText("");
        tywd_2_90.setText("");
        tywd_2_91.setText("");
    }

    public void clearText_wdbd1() {
        wdbd_1_00.setText("");
        wdbd_1_01.setText("");
        wdbd_1_02.setText("");
        wdbd_1_03.setText("");
        wdbd_1_04.setText("");
        wdbd_1_05.setText("");
        wdbd_1_10.setText("");
        wdbd_1_11.setText("");
        wdbd_1_12.setText("");
        wdbd_1_13.setText("");
        wdbd_1_14.setText("");
        wdbd_1_15.setText("");
        wdbd_1_20.setText("");
        wdbd_1_21.setText("");
        wdbd_1_22.setText("");
        wdbd_1_23.setText("");
        wdbd_1_24.setText("");
        wdbd_1_25.setText("");
        wdbd_1_30.setText("");
        wdbd_1_31.setText("");
        wdbd_1_32.setText("");
        wdbd_1_33.setText("");
        wdbd_1_34.setText("");
        wdbd_1_35.setText("");
        wdbd_1_40.setText("");
        wdbd_1_41.setText("");
        wdbd_1_42.setText("");
        wdbd_1_43.setText("");
        wdbd_1_44.setText("");
        wdbd_1_45.setText("");
        wdbd_1_50.setText("");
        wdbd_1_51.setText("");
        wdbd_1_52.setText("");
        wdbd_1_53.setText("");
        wdbd_1_54.setText("");
        wdbd_1_55.setText("");
        wdbd_1_60.setText("");
        wdbd_1_61.setText("");
        wdbd_1_62.setText("");
        wdbd_1_63.setText("");
        wdbd_1_64.setText("");
        wdbd_1_65.setText("");
        wdbd_1_70.setText("");
        wdbd_1_71.setText("");
        wdbd_1_72.setText("");
        wdbd_1_73.setText("");
        wdbd_1_74.setText("");
        wdbd_1_75.setText("");
        wdbd_1_80.setText("");
        wdbd_1_81.setText("");
        wdbd_1_82.setText("");
        wdbd_1_83.setText("");
        wdbd_1_84.setText("");
        wdbd_1_85.setText("");
        wdbd_1_90.setText("");
        wdbd_1_91.setText("");
        wdbd_1_92.setText("");
        wdbd_1_93.setText("");
        wdbd_1_94.setText("");
        wdbd_1_95.setText("");
    }

    public void clearText_wdbd2() {
        wdbd_2_00.setText("");
        wdbd_2_01.setText("");
        wdbd_2_10.setText("");
        wdbd_2_11.setText("");
        wdbd_2_20.setText("");
        wdbd_2_21.setText("");
        wdbd_2_30.setText("");
        wdbd_2_31.setText("");
        wdbd_2_40.setText("");
        wdbd_2_41.setText("");
        wdbd_2_50.setText("");
        wdbd_2_51.setText("");
        wdbd_2_60.setText("");
        wdbd_2_61.setText("");
        wdbd_2_70.setText("");
        wdbd_2_71.setText("");
        wdbd_2_80.setText("");
        wdbd_2_81.setText("");
        wdbd_2_90.setText("");
        wdbd_2_91.setText("");
    }

    public void clearText_zgw1() {
        zgw_1_00.setText("");
        zgw_1_01.setText("");
        zgw_1_02.setText("");
        zgw_1_03.setText("");
        zgw_1_04.setText("");
        zgw_1_05.setText("");
        zgw_1_10.setText("");
        zgw_1_11.setText("");
        zgw_1_12.setText("");
        zgw_1_13.setText("");
        zgw_1_14.setText("");
        zgw_1_15.setText("");
        zgw_1_20.setText("");
        zgw_1_21.setText("");
        zgw_1_22.setText("");
        zgw_1_23.setText("");
        zgw_1_24.setText("");
        zgw_1_25.setText("");
        zgw_1_30.setText("");
        zgw_1_31.setText("");
        zgw_1_32.setText("");
        zgw_1_33.setText("");
        zgw_1_34.setText("");
        zgw_1_35.setText("");
        zgw_1_40.setText("");
        zgw_1_41.setText("");
        zgw_1_42.setText("");
        zgw_1_43.setText("");
        zgw_1_44.setText("");
        zgw_1_45.setText("");
        zgw_1_50.setText("");
        zgw_1_51.setText("");
        zgw_1_52.setText("");
        zgw_1_53.setText("");
        zgw_1_54.setText("");
        zgw_1_55.setText("");
        zgw_1_60.setText("");
        zgw_1_61.setText("");
        zgw_1_62.setText("");
        zgw_1_63.setText("");
        zgw_1_64.setText("");
        zgw_1_65.setText("");
        zgw_1_70.setText("");
        zgw_1_71.setText("");
        zgw_1_72.setText("");
        zgw_1_73.setText("");
        zgw_1_74.setText("");
        zgw_1_75.setText("");
        zgw_1_80.setText("");
        zgw_1_81.setText("");
        zgw_1_82.setText("");
        zgw_1_83.setText("");
        zgw_1_84.setText("");
        zgw_1_85.setText("");
        zgw_1_90.setText("");
        zgw_1_91.setText("");
        zgw_1_92.setText("");
        zgw_1_93.setText("");
        zgw_1_94.setText("");
        zgw_1_95.setText("");
    }

    public void clearText_zgw2() {
        zgw_2_00.setText("");
        zgw_2_01.setText("");
        zgw_2_10.setText("");
        zgw_2_11.setText("");
        zgw_2_20.setText("");
        zgw_2_21.setText("");
        zgw_2_30.setText("");
        zgw_2_31.setText("");
        zgw_2_40.setText("");
        zgw_2_41.setText("");
        zgw_2_50.setText("");
        zgw_2_51.setText("");
        zgw_2_60.setText("");
        zgw_2_61.setText("");
        zgw_2_70.setText("");
        zgw_2_71.setText("");
        zgw_2_80.setText("");
        zgw_2_81.setText("");
        zgw_2_90.setText("");
        zgw_2_91.setText("");
    }

    //新建一个内部类，用来获取裁判员给每个专业的的打分，并用二维字符串数组来暂时存放
    class getInputText {
        private String fzby1_input_string[][];
        private String fzby2_input_string[][];
        private String jmc1_input_string[][];
        private String jmc2_input_string[][];
        private String llc1_input_string[][];
        private String llc2_input_string[][];
        private String lxw1_input_string[][];
        private String lxw2_input_string[][];
        private String tywd1_input_string[][];
        private String tywd2_input_string[][];
        private String wdbd1_input_string[][];
        private String wdbd2_input_string[][];
        private String zgw1_input_string[][];
        private String zgw2_input_string[][];

        public String[][] fzby1_getText() {
//            TextView []editText=new TextView[]{
//                    fzby1_x1, fzby_1_00, fzby_1_01, fzby1_x2, fzby_1_10, fzby_1_11, fzby1_x3, fzby_1_20, fzby_1_21,
//                    fzby1_x4, fzby_1_30, fzby_1_31, fzby1_x5, fzby_1_40, fzby_1_41, fzby1_x6, fzby_1_50, fzby_1_51,
//                    fzby1_x7, fzby_1_60, fzby_1_61, fzby1_x8, fzby_1_70, fzby_1_71, fzby1_x9, fzby_1_80, fzby_1_81,
//                    fzby1_x10, fzby_1_90, fzby_1_91};
//            int xiongpaihlength=10;
//            int fzbylength=3;
//            int id=0;
//            for (int i=0;i<xiongpaihlength;i++){
//                for (int j=0;j<fzbylength;j++){
//                    fzby1_input_string[i][j]=editText[id].getText().toString();
//                    id++;
//                }
//            }
//            return fzby1_input_string;
            fzby1_input_string = new String[][]{
                    {fzby1_x1.getText().toString(), fzby_1_00.getText().toString(), fzby_1_01.getText().toString()},
                    {fzby1_x2.getText().toString(), fzby_1_10.getText().toString(), fzby_1_11.getText().toString()},
                    {fzby1_x3.getText().toString(), fzby_1_20.getText().toString(), fzby_1_21.getText().toString()},
                    {fzby1_x4.getText().toString(), fzby_1_30.getText().toString(), fzby_1_31.getText().toString()},
                    {fzby1_x5.getText().toString(), fzby_1_40.getText().toString(), fzby_1_41.getText().toString()},
                    {fzby1_x6.getText().toString(), fzby_1_50.getText().toString(), fzby_1_51.getText().toString()},
                    {fzby1_x7.getText().toString(), fzby_1_60.getText().toString(), fzby_1_61.getText().toString()},
                    {fzby1_x8.getText().toString(), fzby_1_70.getText().toString(), fzby_1_71.getText().toString()},
                    {fzby1_x9.getText().toString(), fzby_1_80.getText().toString(), fzby_1_81.getText().toString()},
                    {fzby1_x10.getText().toString(), fzby_1_90.getText().toString(), fzby_1_91.getText().toString()},
            };
            return fzby1_input_string;
        }

        public String[][] fzby2_getText() {
            fzby2_input_string = new String[][]{
                    {fzby2_x1.getText().toString(), fzby_2_00.getText().toString(), fzby_2_01.getText().toString()},
                    {fzby2_x2.getText().toString(), fzby_2_10.getText().toString(), fzby_2_11.getText().toString()},
                    {fzby2_x3.getText().toString(), fzby_2_20.getText().toString(), fzby_2_21.getText().toString()},
                    {fzby2_x4.getText().toString(), fzby_2_30.getText().toString(), fzby_2_31.getText().toString()},
                    {fzby2_x5.getText().toString(), fzby_2_40.getText().toString(), fzby_2_41.getText().toString()},
                    {fzby2_x6.getText().toString(), fzby_2_50.getText().toString(), fzby_2_51.getText().toString()},
                    {fzby2_x7.getText().toString(), fzby_2_60.getText().toString(), fzby_2_61.getText().toString()},
                    {fzby2_x8.getText().toString(), fzby_2_70.getText().toString(), fzby_2_71.getText().toString()},
                    {fzby2_x9.getText().toString(), fzby_2_80.getText().toString(), fzby_2_81.getText().toString()},
                    {fzby2_x10.getText().toString(), fzby_2_90.getText().toString(), fzby_2_91.getText().toString()},
            };
            return fzby2_input_string;
        }

        public String[][] jmc1_getText() {
            jmc1_input_string = new String[][]{
                    {jmc1_x1.getText().toString(), jmc_1_00.getText().toString(), jmc_1_01.getText().toString(), jmc_1_02.getText().toString(), jmc_1_03.getText().toString(),},
                    {jmc1_x2.getText().toString(), jmc_1_10.getText().toString(), jmc_1_11.getText().toString(), jmc_1_12.getText().toString(), jmc_1_13.getText().toString(),},
                    {jmc1_x3.getText().toString(), jmc_1_20.getText().toString(), jmc_1_21.getText().toString(), jmc_1_22.getText().toString(), jmc_1_23.getText().toString(),},
                    {jmc1_x4.getText().toString(), jmc_1_30.getText().toString(), jmc_1_31.getText().toString(), jmc_1_32.getText().toString(), jmc_1_33.getText().toString(),},
                    {jmc1_x5.getText().toString(), jmc_1_40.getText().toString(), jmc_1_41.getText().toString(), jmc_1_42.getText().toString(), jmc_1_43.getText().toString(),},
                    {jmc1_x6.getText().toString(), jmc_1_50.getText().toString(), jmc_1_51.getText().toString(), jmc_1_52.getText().toString(), jmc_1_53.getText().toString(),},
                    {jmc1_x7.getText().toString(), jmc_1_60.getText().toString(), jmc_1_61.getText().toString(), jmc_1_62.getText().toString(), jmc_1_63.getText().toString(),},
                    {jmc1_x8.getText().toString(), jmc_1_70.getText().toString(), jmc_1_71.getText().toString(), jmc_1_72.getText().toString(), jmc_1_73.getText().toString(),},
                    {jmc1_x9.getText().toString(), jmc_1_80.getText().toString(), jmc_1_81.getText().toString(), jmc_1_82.getText().toString(), jmc_1_83.getText().toString(),},
                    {jmc1_x10.getText().toString(), jmc_1_90.getText().toString(), jmc_1_91.getText().toString(), jmc_1_92.getText().toString(), jmc_1_93.getText().toString(),},
            };
            return jmc1_input_string;
        }

        public String[][] jmc2_getText() {
            jmc2_input_string = new String[][]{
                    {jmc2_x1.getText().toString(), jmc_2_00.getText().toString()},
                    {jmc2_x2.getText().toString(), jmc_2_10.getText().toString()},
                    {jmc2_x3.getText().toString(), jmc_2_20.getText().toString()},
                    {jmc2_x4.getText().toString(), jmc_2_30.getText().toString()},
                    {jmc2_x5.getText().toString(), jmc_2_40.getText().toString()},
                    {jmc2_x6.getText().toString(), jmc_2_50.getText().toString()},
                    {jmc2_x7.getText().toString(), jmc_2_60.getText().toString()},
                    {jmc2_x8.getText().toString(), jmc_2_70.getText().toString()},
                    {jmc2_x9.getText().toString(), jmc_2_80.getText().toString()},
                    {jmc2_x10.getText().toString(), jmc_2_90.getText().toString()},
            };
            return jmc2_input_string;
        }

        public String[][] llc1_getText() {
            llc1_input_string = new String[][]{
                    {llc1_x1.getText().toString(), llc_1_00.getText().toString(), llc_1_01.getText().toString()},
                    {llc1_x2.getText().toString(), llc_1_10.getText().toString(), llc_1_11.getText().toString()},
                    {llc1_x3.getText().toString(), llc_1_20.getText().toString(), llc_1_21.getText().toString()},
                    {llc1_x4.getText().toString(), llc_1_30.getText().toString(), llc_1_31.getText().toString()},
                    {llc1_x5.getText().toString(), llc_1_40.getText().toString(), llc_1_41.getText().toString()},
                    {llc1_x6.getText().toString(), llc_1_50.getText().toString(), llc_1_51.getText().toString()},
                    {llc1_x7.getText().toString(), llc_1_60.getText().toString(), llc_1_61.getText().toString()},
                    {llc1_x8.getText().toString(), llc_1_70.getText().toString(), llc_1_71.getText().toString()},
                    {llc1_x9.getText().toString(), llc_1_80.getText().toString(), llc_1_81.getText().toString()},
                    {llc1_x10.getText().toString(), llc_1_90.getText().toString(), llc_1_91.getText().toString()},
            };
            return llc1_input_string;
        }

        public String[][] llc2_getText() {
            llc2_input_string = new String[][]{
                    {llc2_x1.getText().toString(), llc_2_00.getText().toString()},
                    {llc2_x2.getText().toString(), llc_2_10.getText().toString()},
                    {llc2_x3.getText().toString(), llc_2_20.getText().toString()},
                    {llc2_x4.getText().toString(), llc_2_30.getText().toString()},
                    {llc2_x5.getText().toString(), llc_2_40.getText().toString()},
                    {llc2_x6.getText().toString(), llc_2_50.getText().toString()},
                    {llc2_x7.getText().toString(), llc_2_60.getText().toString()},
                    {llc2_x8.getText().toString(), llc_2_70.getText().toString()},
                    {llc2_x9.getText().toString(), llc_2_80.getText().toString()},
                    {llc2_x10.getText().toString(), llc_2_90.getText().toString()},
            };
            return llc2_input_string;
        }

        public String[][] lxw1_getText() {
            lxw1_input_string = new String[][]{
                    {lxw1_x1.getText().toString(), lxw_1_00.getText().toString(), lxw_1_01.getText().toString(), lxw_1_02.getText().toString(), lxw_1_03.getText().toString(), lxw_1_04.getText().toString(), lxw_1_05.getText().toString()},
                    {lxw1_x2.getText().toString(), lxw_1_10.getText().toString(), lxw_1_11.getText().toString(), lxw_1_12.getText().toString(), lxw_1_13.getText().toString(), lxw_1_14.getText().toString(), lxw_1_15.getText().toString()},
                    {lxw1_x3.getText().toString(), lxw_1_20.getText().toString(), lxw_1_21.getText().toString(), lxw_1_22.getText().toString(), lxw_1_23.getText().toString(), lxw_1_24.getText().toString(), lxw_1_25.getText().toString()},
                    {lxw1_x4.getText().toString(), lxw_1_30.getText().toString(), lxw_1_31.getText().toString(), lxw_1_32.getText().toString(), lxw_1_33.getText().toString(), lxw_1_34.getText().toString(), lxw_1_35.getText().toString()},
                    {lxw1_x5.getText().toString(), lxw_1_40.getText().toString(), lxw_1_41.getText().toString(), lxw_1_42.getText().toString(), lxw_1_43.getText().toString(), lxw_1_44.getText().toString(), lxw_1_45.getText().toString()},
                    {lxw1_x6.getText().toString(), lxw_1_50.getText().toString(), lxw_1_51.getText().toString(), lxw_1_52.getText().toString(), lxw_1_53.getText().toString(), lxw_1_54.getText().toString(), lxw_1_55.getText().toString()},
                    {lxw1_x7.getText().toString(), lxw_1_60.getText().toString(), lxw_1_61.getText().toString(), lxw_1_62.getText().toString(), lxw_1_63.getText().toString(), lxw_1_64.getText().toString(), lxw_1_65.getText().toString()},
                    {lxw1_x8.getText().toString(), lxw_1_70.getText().toString(), lxw_1_71.getText().toString(), lxw_1_72.getText().toString(), lxw_1_73.getText().toString(), lxw_1_74.getText().toString(), lxw_1_75.getText().toString()},
                    {lxw1_x9.getText().toString(), lxw_1_80.getText().toString(), lxw_1_81.getText().toString(), lxw_1_82.getText().toString(), lxw_1_83.getText().toString(), lxw_1_84.getText().toString(), lxw_1_85.getText().toString()},
                    {lxw1_x10.getText().toString(), lxw_1_90.getText().toString(), lxw_1_91.getText().toString(), lxw_1_92.getText().toString(), lxw_1_93.getText().toString(), lxw_1_94.getText().toString(), lxw_1_95.getText().toString()},
            };
            return lxw1_input_string;
        }

        public String[][] lxw2_getText() {
            lxw2_input_string = new String[][]{
                    {lxw2_x1.getText().toString(), lxw_2_00.getText().toString(), lxw_2_01.getText().toString()},
                    {lxw2_x2.getText().toString(), lxw_2_10.getText().toString(), lxw_2_11.getText().toString()},
                    {lxw2_x3.getText().toString(), lxw_2_20.getText().toString(), lxw_2_21.getText().toString()},
                    {lxw2_x4.getText().toString(), lxw_2_30.getText().toString(), lxw_2_31.getText().toString()},
                    {lxw2_x5.getText().toString(), lxw_2_40.getText().toString(), lxw_2_41.getText().toString()},
                    {lxw2_x6.getText().toString(), lxw_2_50.getText().toString(), lxw_2_51.getText().toString()},
                    {lxw2_x7.getText().toString(), lxw_2_60.getText().toString(), lxw_2_61.getText().toString()},
                    {lxw2_x8.getText().toString(), lxw_2_70.getText().toString(), lxw_2_71.getText().toString()},
                    {lxw2_x9.getText().toString(), lxw_2_80.getText().toString(), lxw_2_81.getText().toString()},
                    {lxw2_x10.getText().toString(), lxw_2_90.getText().toString(), lxw_2_91.getText().toString()},
            };
            return lxw2_input_string;
        }

        public String[][] tywd1_getText() {
            tywd1_input_string = new String[][]{
                    {tywd1_x1.getText().toString(), tywd_1_00.getText().toString(), tywd_1_01.getText().toString(), tywd_1_02.getText().toString(), tywd_1_03.getText().toString()},
                    {tywd1_x2.getText().toString(), tywd_1_10.getText().toString(), tywd_1_11.getText().toString(), tywd_1_12.getText().toString(), tywd_1_13.getText().toString()},
                    {tywd1_x3.getText().toString(), tywd_1_20.getText().toString(), tywd_1_21.getText().toString(), tywd_1_22.getText().toString(), tywd_1_23.getText().toString()},
                    {tywd1_x4.getText().toString(), tywd_1_30.getText().toString(), tywd_1_31.getText().toString(), tywd_1_32.getText().toString(), tywd_1_33.getText().toString()},
                    {tywd1_x5.getText().toString(), tywd_1_40.getText().toString(), tywd_1_41.getText().toString(), tywd_1_42.getText().toString(), tywd_1_43.getText().toString()},
                    {tywd1_x6.getText().toString(), tywd_1_50.getText().toString(), tywd_1_51.getText().toString(), tywd_1_52.getText().toString(), tywd_1_53.getText().toString()},
                    {tywd1_x7.getText().toString(), tywd_1_60.getText().toString(), tywd_1_61.getText().toString(), tywd_1_62.getText().toString(), tywd_1_63.getText().toString()},
                    {tywd1_x8.getText().toString(), tywd_1_70.getText().toString(), tywd_1_71.getText().toString(), tywd_1_72.getText().toString(), tywd_1_73.getText().toString()},
                    {tywd1_x9.getText().toString(), tywd_1_80.getText().toString(), tywd_1_81.getText().toString(), tywd_1_82.getText().toString(), tywd_1_83.getText().toString()},
                    {tywd1_x10.getText().toString(), tywd_1_90.getText().toString(), tywd_1_91.getText().toString(), tywd_1_92.getText().toString(), tywd_1_93.getText().toString()},
            };
            return tywd1_input_string;
        }

        public String[][] tywd2_getText() {
            tywd2_input_string = new String[][]{
                    {tywd2_x1.getText().toString(), tywd_2_00.getText().toString(), tywd_2_01.getText().toString()},
                    {tywd2_x2.getText().toString(), tywd_2_10.getText().toString(), tywd_2_11.getText().toString()},
                    {tywd2_x3.getText().toString(), tywd_2_20.getText().toString(), tywd_2_21.getText().toString()},
                    {tywd2_x4.getText().toString(), tywd_2_30.getText().toString(), tywd_2_31.getText().toString()},
                    {tywd2_x5.getText().toString(), tywd_2_40.getText().toString(), tywd_2_41.getText().toString()},
                    {tywd2_x6.getText().toString(), tywd_2_50.getText().toString(), tywd_2_51.getText().toString()},
                    {tywd2_x7.getText().toString(), tywd_2_60.getText().toString(), tywd_2_61.getText().toString()},
                    {tywd2_x8.getText().toString(), tywd_2_70.getText().toString(), tywd_2_71.getText().toString()},
                    {tywd2_x9.getText().toString(), tywd_2_80.getText().toString(), tywd_2_81.getText().toString()},
                    {tywd2_x10.getText().toString(), tywd_2_90.getText().toString(), tywd_2_91.getText().toString()},
            };
            return tywd2_input_string;
        }

        public String[][] wdbd1_getText() {
            wdbd1_input_string = new String[][]{
                    {wdbd1_x1.getText().toString(), wdbd_1_00.getText().toString(), wdbd_1_01.getText().toString(), wdbd_1_02.getText().toString(), wdbd_1_03.getText().toString(), wdbd_1_04.getText().toString(), wdbd_1_05.getText().toString(),},
                    {wdbd1_x2.getText().toString(), wdbd_1_10.getText().toString(), wdbd_1_11.getText().toString(), wdbd_1_12.getText().toString(), wdbd_1_13.getText().toString(), wdbd_1_14.getText().toString(), wdbd_1_15.getText().toString(),},
                    {wdbd1_x3.getText().toString(), wdbd_1_20.getText().toString(), wdbd_1_21.getText().toString(), wdbd_1_22.getText().toString(), wdbd_1_23.getText().toString(), wdbd_1_24.getText().toString(), wdbd_1_25.getText().toString(),},
                    {wdbd1_x4.getText().toString(), wdbd_1_30.getText().toString(), wdbd_1_31.getText().toString(), wdbd_1_32.getText().toString(), wdbd_1_33.getText().toString(), wdbd_1_34.getText().toString(), wdbd_1_35.getText().toString(),},
                    {wdbd1_x5.getText().toString(), wdbd_1_40.getText().toString(), wdbd_1_41.getText().toString(), wdbd_1_42.getText().toString(), wdbd_1_43.getText().toString(), wdbd_1_44.getText().toString(), wdbd_1_45.getText().toString(),},
                    {wdbd1_x6.getText().toString(), wdbd_1_50.getText().toString(), wdbd_1_51.getText().toString(), wdbd_1_52.getText().toString(), wdbd_1_53.getText().toString(), wdbd_1_54.getText().toString(), wdbd_1_55.getText().toString(),},
                    {wdbd1_x7.getText().toString(), wdbd_1_60.getText().toString(), wdbd_1_61.getText().toString(), wdbd_1_62.getText().toString(), wdbd_1_63.getText().toString(), wdbd_1_64.getText().toString(), wdbd_1_65.getText().toString(),},
                    {wdbd1_x8.getText().toString(), wdbd_1_70.getText().toString(), wdbd_1_71.getText().toString(), wdbd_1_72.getText().toString(), wdbd_1_73.getText().toString(), wdbd_1_74.getText().toString(), wdbd_1_75.getText().toString(),},
                    {wdbd1_x9.getText().toString(), wdbd_1_80.getText().toString(), wdbd_1_81.getText().toString(), wdbd_1_82.getText().toString(), wdbd_1_83.getText().toString(), wdbd_1_84.getText().toString(), wdbd_1_85.getText().toString(),},
                    {wdbd1_x10.getText().toString(), wdbd_1_90.getText().toString(), wdbd_1_91.getText().toString(), wdbd_1_92.getText().toString(), wdbd_1_93.getText().toString(), wdbd_1_94.getText().toString(), wdbd_1_95.getText().toString(),},
            };
            return wdbd1_input_string;
        }

        public String[][] wdbd2_getText() {
            wdbd2_input_string = new String[][]{
                    {wdbd2_x1.getText().toString(), wdbd_2_00.getText().toString(), wdbd_2_01.getText().toString()},
                    {wdbd2_x2.getText().toString(), wdbd_2_10.getText().toString(), wdbd_2_11.getText().toString()},
                    {wdbd2_x3.getText().toString(), wdbd_2_20.getText().toString(), wdbd_2_21.getText().toString()},
                    {wdbd2_x4.getText().toString(), wdbd_2_30.getText().toString(), wdbd_2_31.getText().toString()},
                    {wdbd2_x5.getText().toString(), wdbd_2_40.getText().toString(), wdbd_2_41.getText().toString()},
                    {wdbd2_x6.getText().toString(), wdbd_2_50.getText().toString(), wdbd_2_51.getText().toString()},
                    {wdbd2_x7.getText().toString(), wdbd_2_60.getText().toString(), wdbd_2_61.getText().toString()},
                    {wdbd2_x8.getText().toString(), wdbd_2_70.getText().toString(), wdbd_2_71.getText().toString()},
                    {wdbd2_x9.getText().toString(), wdbd_2_80.getText().toString(), wdbd_2_81.getText().toString()},
                    {wdbd2_x10.getText().toString(), wdbd_2_90.getText().toString(), wdbd_2_91.getText().toString()},
            };
            return wdbd2_input_string;
        }

        public String[][] zgw1_getText() {
            zgw1_input_string = new String[][]{
                    {zgw1_x1.getText().toString(), zgw_1_00.getText().toString(), zgw_1_01.getText().toString(), zgw_1_02.getText().toString(), zgw_1_03.getText().toString(), zgw_1_04.getText().toString(), zgw_1_05.getText().toString(),},
                    {zgw1_x2.getText().toString(), zgw_1_10.getText().toString(), zgw_1_11.getText().toString(), zgw_1_12.getText().toString(), zgw_1_13.getText().toString(), zgw_1_14.getText().toString(), zgw_1_15.getText().toString(),},
                    {zgw1_x3.getText().toString(), zgw_1_20.getText().toString(), zgw_1_21.getText().toString(), zgw_1_22.getText().toString(), zgw_1_23.getText().toString(), zgw_1_24.getText().toString(), zgw_1_25.getText().toString(),},
                    {zgw1_x4.getText().toString(), zgw_1_30.getText().toString(), zgw_1_31.getText().toString(), zgw_1_32.getText().toString(), zgw_1_33.getText().toString(), zgw_1_34.getText().toString(), zgw_1_35.getText().toString(),},
                    {zgw1_x5.getText().toString(), zgw_1_40.getText().toString(), zgw_1_41.getText().toString(), zgw_1_42.getText().toString(), zgw_1_43.getText().toString(), zgw_1_44.getText().toString(), zgw_1_45.getText().toString(),},
                    {zgw1_x6.getText().toString(), zgw_1_50.getText().toString(), zgw_1_51.getText().toString(), zgw_1_52.getText().toString(), zgw_1_53.getText().toString(), zgw_1_54.getText().toString(), zgw_1_55.getText().toString(),},
                    {zgw1_x7.getText().toString(), zgw_1_60.getText().toString(), zgw_1_61.getText().toString(), zgw_1_62.getText().toString(), zgw_1_63.getText().toString(), zgw_1_64.getText().toString(), zgw_1_65.getText().toString(),},
                    {zgw1_x8.getText().toString(), zgw_1_70.getText().toString(), zgw_1_71.getText().toString(), zgw_1_72.getText().toString(), zgw_1_73.getText().toString(), zgw_1_74.getText().toString(), zgw_1_75.getText().toString(),},
                    {zgw1_x9.getText().toString(), zgw_1_80.getText().toString(), zgw_1_81.getText().toString(), zgw_1_82.getText().toString(), zgw_1_83.getText().toString(), zgw_1_84.getText().toString(), zgw_1_85.getText().toString(),},
                    {zgw1_x10.getText().toString(), zgw_1_90.getText().toString(), zgw_1_91.getText().toString(), zgw_1_92.getText().toString(), zgw_1_93.getText().toString(), zgw_1_94.getText().toString(), zgw_1_95.getText().toString(),},
            };
            return zgw1_input_string;
        }

        public String[][] zgw2_getText() {
            zgw2_input_string = new String[][]{
                    {zgw2_x1.getText().toString(), zgw_2_00.getText().toString(), zgw_2_01.getText().toString()},
                    {zgw2_x2.getText().toString(), zgw_2_10.getText().toString(), zgw_2_11.getText().toString()},
                    {zgw2_x3.getText().toString(), zgw_2_20.getText().toString(), zgw_2_21.getText().toString()},
                    {zgw2_x4.getText().toString(), zgw_2_30.getText().toString(), zgw_2_31.getText().toString()},
                    {zgw2_x5.getText().toString(), zgw_2_40.getText().toString(), zgw_2_41.getText().toString()},
                    {zgw2_x6.getText().toString(), zgw_2_50.getText().toString(), zgw_2_51.getText().toString()},
                    {zgw2_x7.getText().toString(), zgw_2_60.getText().toString(), zgw_2_61.getText().toString()},
                    {zgw2_x8.getText().toString(), zgw_2_70.getText().toString(), zgw_2_71.getText().toString()},
                    {zgw2_x9.getText().toString(), zgw_2_80.getText().toString(), zgw_2_81.getText().toString()},
                    {zgw2_x10.getText().toString(), zgw_2_90.getText().toString(), zgw_2_91.getText().toString()},
            };
            return zgw2_input_string;
        }
    }
}
