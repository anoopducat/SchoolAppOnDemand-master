package com.example.admin.schoolappondemand;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Transport extends AppCompatActivity {

    TextView tv1;
    ImageButton imbtn1,imbtn2,imbtn3;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
         imbtn1= (ImageButton) findViewById(R.id.iv_btn_bs);
        imbtn2= (ImageButton) findViewById(R.id.driver);
        imbtn3= (ImageButton) findViewById(R.id.incharger);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        tv1= (TextView) findViewById(R.id.profile_tv);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        toolbar.setNavigationIcon(R.drawable.back_btn);
       toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onBackPressed();
           }
       });

        tv1.setText("Transport");

    imbtn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            BusDetail b =new BusDetail();
            ft.replace(R.id.liner_for_detail,b,"a");
            ft.addToBackStack("a");
            ft.commit();
        }
    });

        imbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                DriverDetail d =new DriverDetail();
                ft.replace(R.id.liner_for_detail,d,"d");
                ft.addToBackStack("d");
                ft.commit();
            }
        });

        imbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Incharger i =new Incharger();
                ft.replace(R.id.liner_for_detail,i,"i");
                ft.addToBackStack("i");
                ft.commit();
            }
        });
    }
}
