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

public class Library extends AppCompatActivity {

    TextView tv1;


    RecyclerView recyclerView;

    RequestQueue requestQueue;

    ArrayList<LibreryModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        requestQueue= Volley.newRequestQueue(this);

        recyclerView= (RecyclerView) findViewById(R.id.lib_rv);

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest("http://203.124.96.117:8063/Service1.asmx/Library", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++)
                {
                    LibreryModel model=new LibreryModel();

                    try {
                        JSONObject object= (JSONObject) response.get(i);

                        String no=object.getString("AccessionNo");
                        String bokktitle=object.getString("Title");
                        String bokksubtitle=object.getString("Subtitle");
                        String bkedition=object.getString("BookEdition");
                        String datissue=object.getString("IssDate");
                        String datreturn=object.getString("RetDate");
                        String datdue=object.getString("DueDate");

                        model.setAcsnno(no);
                        model.setTitle(bokktitle);
                        model.setSubtitle(bokksubtitle);
                        model.setBookedition(bkedition);
                        model.setIssuedat(datissue);
                        model.setReturndat(datreturn);
                        model.setDuedat(datdue);

                        arrayList.add(model);

                        LibraryAdapter obj=new LibraryAdapter(Library.this,R.layout.card_lib,arrayList);

                        recyclerView.setAdapter(obj);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Library.this, "" +error, Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonArrayRequest);


       //// LibreryModel model=new LibreryModel();
       // model.setAcsnno("7");
       // model.setTitle("Great fairy story Alice in wonderland");
       // model.setSubtitle("ABC");
      //  model.setBookedition("   ");
       // model.setIssuedat("26/08/2016");
      //  model.setReturndat("04/11/2016");
      //  model.setDuedat("01/12/2016");
       // arrayList.add(model);

      //  LibreryModel model1=new LibreryModel();
      //  model1.setAcsnno("1112");
       // model1.setTitle("Harry potter");
      //  model1.setSubtitle("Harry Potter 1");
     //   model1.setBookedition("2007");
      //  model1.setIssuedat("03/02/2017");
      //  model1.setReturndat("   ");
       // model1.setDuedat("10/02/2017");
      //  arrayList.add(model1);


        //LibraryAdapter obj=new LibraryAdapter(this,R.layout.card_lib,arrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(obj);


        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        tv1= (TextView) findViewById(R.id.profile_tv);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv1.setText("Library");
    }
}
