package com.example.admin.schoolappondemand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Circular extends AppCompatActivity {

    TextView tv1;

    RecyclerView recyclerView;

    RequestQueue requestQueue;

    ArrayList<CircularModel> Al=new ArrayList<>();

    String url ="http://203.124.96.117:8063/Service1.asmx/Circulars";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);

        recyclerView= (RecyclerView) findViewById(R.id.rv_crclr);
        requestQueue= Volley.newRequestQueue(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++)
                {
                    CircularModel model=new CircularModel();

                    try {
                        JSONObject object= (JSONObject) response.get(i);


                        String crdet=object.getString("CreatedDate");
                        String adnm=object.getString("EmpName");
                        String crdes=object.getString("Message");

                        model.setDtname(crdet);
                        model.setNem(adnm);
                        model.setDescription(crdes);

                        Al.add(model);

                        CircularAdapter obj=new CircularAdapter(Circular.this,R.layout.circular_card,Al);

                        recyclerView.setAdapter(obj);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Circular.this, "" + error, Toast.LENGTH_SHORT).show();


            }
        });

        requestQueue.add(jsonArrayRequest);


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

        tv1.setText("Circular");
    }
}
