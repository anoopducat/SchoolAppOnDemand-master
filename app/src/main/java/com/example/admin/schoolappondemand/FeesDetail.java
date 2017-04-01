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

public class FeesDetail extends AppCompatActivity {

    RecyclerView recyclerView;

    TextView tv1,totl,ddu,ppad;

    RequestQueue requestQueue;

    ArrayList<FeeDetailModel> arrayList=new ArrayList<>();

    String url ="http://203.124.96.117:8063/Service1.asmx/FeeCompleteDetails";
    //String url1="http://203.124.96.117:8063/Service1.asmx/FeeDetails";

    ArrayList<FeeDetailModel> Al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_detail);

        requestQueue= Volley.newRequestQueue(this);

        recyclerView= (RecyclerView) findViewById(R.id.rv_feedetail);




        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0;i<response.length();i++)
                {
                    FeeDetailModel model=new FeeDetailModel();

                    try {
                        JSONObject object= (JSONObject) response.get(i);

                        String feerecept=object.getString("ReceiptNo");
                        String feepeydet=object.getString("FeePayDate");
                        String feetotal=object.getString("TotalFee");
                        String feefine=object.getString("Fine");
                        String feecon=object.getString("Concession");
                        String feehostal=object.getString("HostelCharges");
                        String feenet=object.getString("NetTotal");
                        String feepaid=object.getString("Paid");
                        String feebal=object.getString("Balance");
                        String feepem=object.getString("PaymentType");


                        model.setRecept(feerecept);
                        model.setFedepe(feepeydet);
                        model.setTofe(feetotal);
                        model.setFine(feefine);
                        model.setConsesn(feecon);
                        model.setHostalcha(feehostal);
                        model.setNetfe(feenet);
                        model.setPefe(feepaid);
                        model.setBlfe(feebal);
                        model.setPementtype(feepem);

                        arrayList.add(model);

                        FeeDetailAdapter obj=new FeeDetailAdapter(FeesDetail.this,R.layout.fee_card,arrayList);

                        recyclerView.setAdapter(obj);





                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(FeesDetail.this, "" + error, Toast.LENGTH_SHORT).show();

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

        tv1.setText("Fee Detail");






        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    }
}
