package com.example.admin.schoolappondemand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;

public class TimeTable extends AppCompatActivity {

    TextView tv1;

    RecyclerView recyclerView;

    ArrayList<TimeTableModel> arrayList=new ArrayList<>();

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        requestQueue= Volley.newRequestQueue(this);

        recyclerView= (RecyclerView) findViewById(R.id.rv_timetable);



        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest("url", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++){
                   // TimeTableModel tmdl=new TimeTableModel();

                    try {
                        JSONObject object= (JSONObject) response.get(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(TimeTable.this, "" + error, Toast.LENGTH_SHORT).show();

            }
        });
         requestQueue.add(jsonArrayRequest);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        tv1= (TextView) findViewById(R.id.profile_tv);

        TimeTableModel tmdl=new TimeTableModel();
        tmdl.setTtday("Monday");
        tmdl.setTtperiod("1");
        tmdl.setTtsubct("Art and Craft-Manmeet Kaur [EMP0005]");
        arrayList.add(tmdl);

        TimeTableModel tmdl1=new TimeTableModel();
        tmdl1.setTtday("Friday");
        tmdl1.setTtperiod("2");
        tmdl1.setTtsubct("Hindi-Manmeet Kaur [EMP0005]");
        arrayList.add(tmdl1);

        TimeTableModel tmdl2=new TimeTableModel();
        tmdl2.setTtday("Saturday");
        tmdl2.setTtperiod("3");
        tmdl2.setTtsubct("Hindi-Manmeet Kaur [EMP0005]");
        arrayList.add(tmdl2);

        TimeTableModel tmdl3=new TimeTableModel();
        tmdl3.setTtday("Tuesday");
        tmdl3.setTtperiod("4");
        tmdl3.setTtsubct("Hindi-Manmeet Kaur [EMP0005]");
        arrayList.add(tmdl3);


        TimeTableModel tmdl4=new TimeTableModel();
        tmdl4.setTtday("WednesDay");
        tmdl4.setTtperiod("5");
        tmdl4.setTtsubct("Hindi-Manmeet Kaur [EMP0005]");
        arrayList.add(tmdl4);

        TimeTableModel tmdl5=new TimeTableModel();
        tmdl5.setTtday("Thursday");
        tmdl5.setTtperiod("6");
        tmdl5.setTtsubct("");
        arrayList.add(tmdl5);
        arrayList.add(tmdl5);
        arrayList.add(tmdl5);
        arrayList.add(tmdl5);
        arrayList.add(tmdl5);
        arrayList.add(tmdl5);

        TimeTableAdapter obj=new TimeTableAdapter(this,R.layout.card_time_table,arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(obj);

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

        tv1.setText("Time Table");
    }
}
