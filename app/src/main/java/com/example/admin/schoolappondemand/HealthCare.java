package com.example.admin.schoolappondemand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HealthCare extends AppCompatActivity {

    TextView tv1,soi,dt,dnm,rmk;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        requestQueue= Volley.newRequestQueue(this);

        tv1= (TextView) findViewById(R.id.profile_tv);

        soi= (TextView) findViewById(R.id.sopd);
        dt= (TextView) findViewById(R.id.tv_trtdt);
        dnm= (TextView) findViewById(R.id.tv_dt_nm);
        rmk= (TextView) findViewById(R.id.tv_rmrk);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest("http://203.124.96.117:8063/Service1.asmx/OPD", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                for(int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject object= (JSONObject) jsonArray.get(i);

                        String sod=object.getString("SopdId");
                        String trdt=object.getString("TreatmentDate");
                        String dtn=object.getString("DoctorName");
                        String rm=object.getString("Remaks");


                        soi.setText(sod);
                        dt.setText(trdt);
                        dnm.setText(dtn);
                        rmk.setText(rm);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(HealthCare.this, ""  + volleyError, Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonArrayRequest);

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

        tv1.setText("Health Care");
    }
}
