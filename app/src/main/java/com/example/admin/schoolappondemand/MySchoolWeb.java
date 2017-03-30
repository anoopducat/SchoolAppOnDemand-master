package com.example.admin.schoolappondemand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MySchoolWeb extends AppCompatActivity {

    WebView webView;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_school_web);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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

        tv1.setText("WWW");

        webView= (WebView) findViewById(R.id.webv);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());


       // webView.loadUrl("https://www.hrsoftwaresolution.com/schoolappondemand")
        // ;

        webView.setWebChromeClient(new WebChromeClient());

        webView.loadData("<iframe src=\"https://www.hrsoftwaresolution.com/schoolappondemand\" width=\"100%\" height=\"400%\"></iframe>", "text/html",
                "utf-8");

    }
}
