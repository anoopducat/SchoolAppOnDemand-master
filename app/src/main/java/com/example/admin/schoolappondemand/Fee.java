package com.example.admin.schoolappondemand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Fee extends AppCompatActivity {

    TextView tv1,tf,tl,du,ntl;

    Button btn;

    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee);

        btn= (Button) findViewById(R.id.fee_btn);

        requestQueue= Volley.newRequestQueue(this);

        du= (TextView) findViewById(R.id.due_fee);
        ntl= (TextView) findViewById(R.id.nt_ttl);

        JsonArrayRequest jsn=new JsonArrayRequest("http://203.124.96.117:8063/Service1.asmx/Fee", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                for(int i=0;i<jsonArray.length();i++)
                {
                    try {
                        JSONObject object= (JSONObject) jsonArray.get(i);

                        String total =object.getString("TotalFee");
                        String fdue=object.getString("Balance");
                        String ntotal=object.getString("NetTotal");



                        tf.setText(total);
                        tl.setText(total);
                        du.setText(fdue);
                        ntl.setText(ntotal);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(jsn);


        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        tv1= (TextView) findViewById(R.id.profile_tv);

        tf= (TextView) findViewById(R.id.tv_tt);
        tl= (TextView) findViewById(R.id.total);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        tv1.setText("Fees");

        toolbar.setNavigationIcon(R.drawable.back_btn);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Fee.this,FeesDetail.class);
                startActivity(intent);
            }
        });



    }
}
