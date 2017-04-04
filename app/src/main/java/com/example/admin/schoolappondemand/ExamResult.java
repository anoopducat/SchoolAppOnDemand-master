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

public class ExamResult extends AppCompatActivity {

    TextView tv1;

    RequestQueue requestQueue;

    RecyclerView recyclerView;

    ArrayList<ResultModel> arrayList=new ArrayList<>();

    String url ="http://203.124.96.117:8063/Service1.asmx/Result";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ezxam_result);

        recyclerView= (RecyclerView) findViewById(R.id.rslt_rv);
        requestQueue= Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++)
                {
                    ResultModel model=new ResultModel();

                    try {
                        JSONObject object= (JSONObject) response.get(i);

                        String grp=object.getString("SubjectGroupName");
                        String resub=object.getString("SubName");
                        String obtnd=object.getString("ObtainedMarks");
                        String fll=object.getString("MaxMarks");

                        model.setGrpnm(grp);
                        model.setSubnem(resub);
                        model.setObtnd(obtnd);
                        model.setFll(fll);

                        arrayList.add(model);

                        ResultAdapter obj=new ResultAdapter(ExamResult.this,R.layout.result_card,arrayList);

                        recyclerView.setAdapter(obj);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ExamResult.this, "" +error, Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonArrayRequest);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        tv1= (TextView) findViewById(R.id.profile_tv);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv1.setText("Result");
    }
}
