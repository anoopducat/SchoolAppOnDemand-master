package com.example.admin.schoolappondemand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(){

            public void run(){

                try {
                    Thread.sleep(2000);
                    Intent intent =new Intent(Splash.this,MainActivity.class);
                    startActivity(intent);
                    Splash.super.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            }.start();
        }

    }

