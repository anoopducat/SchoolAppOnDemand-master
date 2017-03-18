package com.example.admin.schoolappondemand;

        import android.content.Intent;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

       // setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        //getSupportActionBar().setDisplayShowTitleEnabled(false);
// Get access to the custom title view
        //TextView mTitle = (TextView) toolbar.findViewById(R.id.tlbr_tv);
        //mTitle.setText("SchoolApp");


        btn1= (Button) findViewById(R.id.b);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ProfilePage.class);
                startActivity(i);
            }
        });


    }
}
