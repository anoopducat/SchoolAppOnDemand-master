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

public class FeesDetail extends AppCompatActivity {

    RecyclerView recyclerView;

    TextView tv1,totl,ddu,ppad;

    RequestQueue requestQueue;

    ArrayList<FeeDetailModel> Al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_detail);

        requestQueue= Volley.newRequestQueue(this);


        totl= (TextView) findViewById(R.id.tv_fdetail_ttl);
        ddu= (TextView) findViewById(R.id.tv_fdetail_due);
        ppad= (TextView) findViewById(R.id.tv_fdetail_paid);


        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest("http://203.124.96.117:8063/Service1.asmx/Fee", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                for(int i=0;i<jsonArray.length();i++)
                {
                    try {
                        JSONObject object= (JSONObject) jsonArray.get(67);

                        String total =object.getString("TotalFee");
                        String fdue=object.getString("Balance");
                        String ntotal=object.getString("NetTotal");

                        totl.setText(total);
                        ddu.setText(fdue);
                        ppad.setText(ntotal);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(FeesDetail.this, "" + volleyError, Toast.LENGTH_SHORT).show();

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

        recyclerView= (RecyclerView) findViewById(R.id.rv_feedetail);



        FeeDetailModel feeDetailModel=new FeeDetailModel();
        feeDetailModel.setFeetype("Skating");
        feeDetailModel.setFeetotal("1050");
        feeDetailModel.setFeepaid("500");
        feeDetailModel.setFeedue("400");
        feeDetailModel.setFeedate("04/02/2017");
        Al.add(feeDetailModel);

        FeeDetailModel feeDetailModel1=new FeeDetailModel();
        feeDetailModel1.setFeetype("Tution Fee");
        feeDetailModel1.setFeetotal("700");
        feeDetailModel1.setFeepaid("500");
        feeDetailModel1.setFeedue("400");
        feeDetailModel1.setFeedate("05/02/2017");
        Al.add(feeDetailModel1);

        FeeDetailModel feeDetailModel2=new FeeDetailModel();
        feeDetailModel2.setFeetype("Annual Charges");
        feeDetailModel2.setFeetotal("1000");
        feeDetailModel2.setFeepaid("500");
        feeDetailModel2.setFeedue("400");
        feeDetailModel2.setFeedate("04/03/2017");
        Al.add(feeDetailModel2);

        FeeDetailModel feeDetailModel3=new FeeDetailModel();
        feeDetailModel3.setFeetype("Online Web/MultimediaFee");
        feeDetailModel3.setFeetotal("500");
        feeDetailModel3.setFeepaid("500");
        feeDetailModel3.setFeedue("0");
        feeDetailModel3.setFeedate("08/02/2017");
        Al.add(feeDetailModel3);

        FeeDetailModel feeDetailModel4=new FeeDetailModel();
        feeDetailModel4.setFeetype("Other Misc");
        feeDetailModel4.setFeetotal("3000");
        feeDetailModel4.setFeepaid("2500");
        feeDetailModel4.setFeedue("500");
        feeDetailModel4.setFeedate("11/02/2017");
        Al.add(feeDetailModel4);

        FeeDetailModel feeDetailModel5=new FeeDetailModel();
        feeDetailModel5.setFeetype("Student WelFare");
        feeDetailModel5.setFeetotal("1150");
        feeDetailModel5.setFeepaid("1500");
        feeDetailModel5.setFeedue("1500");
        feeDetailModel5.setFeedate("04/03/2017");
        Al.add(feeDetailModel5);

        FeeDetailModel feeDetailModel6=new FeeDetailModel();
        feeDetailModel6.setFeetype("SchoolarShip Fee");
        feeDetailModel6.setFeetotal("500");
        feeDetailModel6.setFeepaid("400");
        feeDetailModel6.setFeedue("100");
        feeDetailModel6.setFeedate("04/02/2017");
        Al.add(feeDetailModel6);

        FeeDetailAdapter obj=new FeeDetailAdapter(this,R.layout.fee_card,Al);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView.setAdapter(obj);

    }
}
