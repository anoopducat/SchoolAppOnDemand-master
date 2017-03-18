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

public class StudentAssignment extends AppCompatActivity {

    TextView tv1;
    RecyclerView recyclerView;
    ArrayList<Student> Al=new ArrayList<>();
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_assignment);
        requestQueue= Volley.newRequestQueue(this);

        recyclerView= (RecyclerView) findViewById(R.id.rv1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest("http://203.124.96.117:8063/Service1.asmx/Assignment", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                for(int i=0;i<jsonArray.length();i++){
                    Student s1=new Student();

                    try {
                        JSONObject object= (JSONObject) jsonArray.get(i);

                        String id=object.getString("tblAssignmentId");
                        String name=object.getString("AssignmantId");
                        String sclass=object.getString("ClassName");
                        String sct=object.getString("SectionName");
                        String sub=object.getString("SubName");
                        String chap=object.getString("ChapterNo");
                        String lss=object.getString("Lesson");

                        s1.setId(id);
                        s1.setName(name);
                        s1.setNclass(sclass);
                        s1.setSection(sct);
                        s1.setSubject(sub);
                        s1.setChapter(chap);
                        s1.setLesson(lss);

                        Al.add(s1);

                        MyAdapter obj =new MyAdapter(StudentAssignment.this,R.layout.card,Al);


                        recyclerView.setAdapter(obj);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(StudentAssignment.this, "" + volleyError, Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(jsonArrayRequest);







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

        tv1.setText("Assignment");
    }
}
