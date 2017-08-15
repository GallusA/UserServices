package com.userservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class secondActivity extends AppCompatActivity {

    MyBoundService myBoundService;
    ServiceRecycle myServiceRecycle;
    boolean isBound = false;
    boolean isBoundRecycler = false;
    TextView tv1, tv2, tvrandom;
    int random = -1;
    private  static final  String TAG = "SecondActivity";

  //  ArrayList<randomStuff> n = new ArrayList();
   TextView textView, textView2;
    //   int x  =45;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        textView = (TextView) findViewById(R.id.textView) ;
        textView2 = (TextView) findViewById(R.id.textView2);

        Intent i = getIntent();
       textView.setText(i.getStringExtra("data"));

      Intent e= getIntent();
        textView2.setText(e.getStringExtra("data1"));








    }



}
