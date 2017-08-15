package com.userservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivityTag";

    MyBoundService myBoundService;
    Boolean   isBound;
    int d =-5;
    int n;
    int size;
    int[][] arr = new int[size][n];
    int someValue=0;
    Button button, Play, Stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           Play =(Button) findViewById(R.id.buttonPlay);
           Stop = (Button) findViewById(R.id.buttonStop);

        Log.d(TAG, "onCreate: ");

        Play.setOnClickListener(this);
        Stop.setOnClickListener(this);

    }


     public  void  onClick(View v){
        if(v == Play){
            startService(new Intent(this, MediaPlayerService.class));
        }else if(v == Stop){
            stopService(new Intent(this, MediaPlayerService.class));

        }
    }

    public  void  startServices(View view){
        Intent normalIntent = new Intent(this, MyNormalservice.class);
        Intent intIntent = new Intent(this, MyIntentService.class);

        Intent boundIntent = new  Intent(this, MyBoundService.class);
        Intent boundIntent2 = new Intent(this, MyBoundService.class);

        Intent intent3 =  new Intent(this, MediaPlayerService.class);
        switch(view.getId()) {

            case R.id.btnStartNormalService:
                normalIntent.putExtra("data", "This is a normal service");
                startService(normalIntent);

                startService(intent3);
                break;
            case R.id.btnStopNormalService:
                stopService(normalIntent);
                stopService(intent3);
                break;
            case R.id.btnStartIntentServices:
                intIntent.putExtra("data", "this is an intent service");
                intIntent.setAction("getRepo");
                startService(intIntent);
                break;
            case R.id.btnBindservice:
                //     intIntent.putExtra("data", "this is an intent service");
                //           intIntent.setAction("getProfile");
                //         startService(intIntent);
                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);
         //       bindService(boundIntent2, serviceConnection, Context.BIND_AUTO_CREATE);


                break;
            case R.id.btnUnBindservice:
             /*    if(isBound){
                    unbindService(serviceConnection);
                    isbound = false;
                    }
                    break;
              */
                 unbindService(serviceConnection);
                break;
            case R.id.gotosecondActivity:
                Intent intent2 = new Intent(this, secondActivity.class);
                intent2.putExtra("data", ""+d);
                startActivity(intent2);
               
                break;

        }
    }
  ServiceConnection serviceConnection = new ServiceConnection() {
      @Override
      public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
          MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
          myBoundService = myBinder.getService();
       //   Log.d(TAG, "onServiceConnected:" + myBoundService.getRandomData());
          d=myBoundService.getRandomData();
          Log.d(TAG, "onServiceConnected: "+ d);
        //  isBound = true:
      }

      @Override
      public void onServiceDisconnected(ComponentName componentName) {
         //isBound = false

      }
  };


    public MyBoundService getMyBoundService() {
        return myBoundService;

    }


}
