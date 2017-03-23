package com.example.admin.schoolappondemand;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyProfile extends AppCompatActivity {

    TextView tv1,uname,ad_no,cls_nm,cls_teacher,mob,father,mother,address,emel;

    NetworkImageView networkImageView;

    RequestQueue requestQueue;

    String name;

    private ImageLoader mImageLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);



        requestQueue= Volley.newRequestQueue(this);

        networkImageView= (NetworkImageView) findViewById(R.id.imageView);

        mImageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });

        networkImageView.setImageUrl("http://schoolappondemand.com/image/StudentImages/index%20c.jpg",mImageLoader);

        final ProgressDialog progressDialog = new ProgressDialog(MyProfile.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        tv1= (TextView) findViewById(R.id.profile_tv);
        uname= (TextView) findViewById(R.id.profile_tv_name);
        ad_no= (TextView) findViewById(R.id.profile_ad_no);
        cls_nm= (TextView) findViewById(R.id.profile_tv_cls);
        cls_teacher= (TextView) findViewById(R.id.profile_tv_teacher);
        mob= (TextView) findViewById(R.id.tv_profile_mob);
        father= (TextView) findViewById(R.id.profile_father);
        mother= (TextView) findViewById(R.id.profile_mother);
        address= (TextView) findViewById(R.id.profile_address);
        emel= (TextView) findViewById(R.id.tv_profile_email);

        JsonArrayRequest arrayRequest=new JsonArrayRequest("http://203.124.96.117:8063/Service1.asmx/StudentDetails", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                progressDialog.dismiss();

                for(int i=0;i<jsonArray.length();i++)
                {
                    try {
                        JSONObject object= (JSONObject) jsonArray.get(892);

                         name =object.getString("Name");
                        String className=object.getString("ClassName");
                        String admission=object.getString("AdmissionNo");
                        String  teacher=object.getString("EmpName");
                        String mobl=object.getString("FatMob");
                        String fthr=object.getString("Father");
                        String mthr=object.getString("Mother");
                        String add=object.getString("GrAddr");
                        String eml=object.getString("FatEmail");

                        uname.setText(name);
                        tv1.setText(name);
                        ad_no.setText(admission);
                        cls_nm.setText(className);
                        cls_teacher.setText(teacher);
                        mob.setText(mobl);
                        father.setText(fthr);
                        mother.setText(mthr);
                        address.setText(add);
                        emel.setText(eml);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MyProfile.this, "" + volleyError, Toast.LENGTH_SHORT).show();

            }

        });
            requestQueue.add(arrayRequest);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.imagecircle);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        toolbar.setNavigationIcon(R.drawable.back_btn);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();

            }
        });
    }
}
