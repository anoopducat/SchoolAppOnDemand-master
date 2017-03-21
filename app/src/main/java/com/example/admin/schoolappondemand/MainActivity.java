package com.example.admin.schoolappondemand;

        import android.content.Intent;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonArrayRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
Button btn1;

    EditText e1,e2;

    RequestQueue requestQueue;

    String unm="1001";
    String pasd="ankit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue= Volley.newRequestQueue(this);


       // Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

       // setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        //getSupportActionBar().setDisplayShowTitleEnabled(false);
// Get access to the custom title view
        //TextView mTitle = (TextView) toolbar.findViewById(R.id.tlbr_tv);
        //mTitle.setText("SchoolApp");


        e1= (EditText) findViewById(R.id.et_uname);
        e2= (EditText) findViewById(R.id.editText2);

        btn1= (Button) findViewById(R.id.b);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=e1.getText().toString();
                String pass=e2.getText().toString();




                if(name.length()==0 && pass.length()==0)
                {
                    e1.setError("Name cannot be Blank");
                    e2.setError("PassWord can not be Blank");
                }
                else {
                    Intent i=new Intent(MainActivity.this,ProfilePage.class);
                    startActivity(i);

                }


            }
        });


    }
}
