package com.example.vratika.e_library;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 10000;//ms//10secs


    @Override
    //initialization code and restoring prev state
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //SPLASH SCREEN CODE
        new Handler().postDelayed(new Runnable(){ //handler processes runnable objs
            @Override
            public void run(){
                Intent homeIntent = new Intent(MainActivity.this,login_page.class);//splashes to the login page.
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
        //splash code ends


    }
}
