package com.example.admin.schoolappondemand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class News extends AppCompatActivity {
    TextView tv1;

    RecyclerView recyclerView;
    ArrayList<NewsModel> Al=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView= (RecyclerView) findViewById(R.id.rv_nws);

        NewsModel newsModel=new NewsModel();
        newsModel.setNwimg(R.drawable.news);
        newsModel.setNwsheading("QUIZ ON ELECTI.....");
        newsModel.setNwsdt("24 Jan 2017");

        newsModel.setNws("After a poor show in the just-concluded assembly elections, BSP chief Mayawati and AAP leader Arvind Kejriwal alleged tampering of EVMs and sought a probe.");
        Al.add(newsModel);
        Al.add(newsModel);
        Al.add(newsModel);
        Al.add(newsModel);
        Al.add(newsModel);

        SchoolNewsAdapter obj=new SchoolNewsAdapter(this,R.layout.card_school_news,Al);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(obj);


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

        tv1.setText("News");
    }
}
