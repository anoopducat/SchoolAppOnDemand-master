package com.example.admin.schoolappondemand;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.LruCache;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<ProfileModel> al=new ArrayList<>();
    GridView gridView;
    TextView nm,cls;

    RequestQueue requestQueue;
    FrameLayout frameLayout;

    private ImageLoader mImageLoader;

    CircleImageView circleImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);


        requestQueue= Volley.newRequestQueue(this);


       circleImageView= (CircleImageView) findViewById(R.id.cimageView);

        Picasso.with(this).load("http://schoolappondemand.com/image/StudentImages/index%20c.jpg").noFade().into(circleImageView);



        nm= (TextView) findViewById(R.id.title_name);
        cls= (TextView) findViewById(R.id.title_class);


        JsonArrayRequest jsn=new JsonArrayRequest("http://203.124.96.117:8063/Service1.asmx/StudentDetails", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                for(int i=0;i<jsonArray.length();i++)
                {
                    try {
                        JSONObject object= (JSONObject) jsonArray.get(892);

                        String name =object.getString("Name");
                        String className=object.getString("ClassName");

                        nm.setText(name);
                        cls.setText(className);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(ProfilePage.this, "" + volleyError, Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsn);

        gridView= (GridView) findViewById(R.id.gv1);
        gridView.setVerticalSpacing(5);
        gridView.setHorizontalSpacing(5);
        frameLayout =(FrameLayout)findViewById(R.id.mainRLayout);

        ProfileModel pf1=new ProfileModel();
        pf1.setName("My Profile");
        pf1.setImage(R.drawable.d1);
        al.add(pf1);


        ProfileModel pf2=new ProfileModel();
        pf2.setName("Attendence");
        pf2.setImage(R.drawable.d2);
        al.add(pf2);

        ProfileModel pf3=new ProfileModel();
        pf3.setName("Home Work");
        pf3.setImage(R.drawable.d3);
        al.add(pf3);

        ProfileModel pf4=new ProfileModel();
        pf4.setName("Fee");
        pf4.setImage(R.drawable.d7);
        al.add(pf4);

        ProfileModel pf5=new ProfileModel();
        pf5.setName("Calender");
        pf5.setImage(R.drawable.d6);
        al.add(pf5);

        ProfileModel pf6=new ProfileModel();
        pf6.setName("Time Table");
        pf6.setImage(R.drawable.d6);
        al.add(pf6);


        ProfileModel pf7=new ProfileModel();
        pf7.setName("Library");
        pf7.setImage(R.drawable.d8);
        al.add(pf7);

        ProfileModel pf8=new ProfileModel();
        pf8.setName("Transport");
        pf8.setImage(R.drawable.d12);
        al.add(pf8);

        ProfileModel pf9=new ProfileModel();
        pf9.setName("Result");
        pf9.setImage(R.drawable.d14);
        al.add(pf9);

        ProfileModel pf10=new ProfileModel();
        pf10.setName("Hostal");
        pf10.setImage(R.drawable.d18);
        al.add(pf10);

        ProfileModel pf11=new ProfileModel();
        pf11.setName("Health Care");
        pf11.setImage(R.drawable.d19);
        al.add(pf11);

        ProfileModel pf12=new ProfileModel();
        pf12.setName("Apply Leave");
        pf12.setImage(R.drawable.d2);
        al.add(pf12);

        ProfileModel pf13=new ProfileModel();
        pf13.setName("Vehicle Tracking");
        pf13.setImage(R.drawable.d3);
        al.add(pf13);


        ProfileModel pf14=new ProfileModel();
        pf14.setName("News");
        pf14.setImage(R.drawable.d11);
        al.add(pf14);

        ProfileModel pf15=new ProfileModel();
        pf15.setName("Communication");
        pf15.setImage(R.drawable.d10);
        al.add(pf15);

        ProfileModel pf16=new ProfileModel();;
        pf16.setName("Circular");
        pf16.setImage(R.drawable.d4);
        al.add(pf16);

        ProfileModel pf17=new ProfileModel();
        pf17.setName("BirthDay");
        pf17.setImage(R.drawable.d16);
        al.add(pf17);

        ProfileModel pf18=new ProfileModel();
        pf18.setName("Download");
        pf18.setImage(R.drawable.d17);
        al.add(pf18);


        ProfileModel pf19=new ProfileModel();
        pf19.setName("Gallery");
        pf19.setImage(R.drawable.d9);
        al.add(pf19);

        ProfileModel pf20=new ProfileModel();
        pf20.setName("Achievement");
        pf20.setImage(R.drawable.d15);
        al.add(pf20);

        ProfileModel pf21=new ProfileModel();
        pf21.setName("WWW");
        pf21.setImage(R.drawable.d20);
        al.add(pf21);



        ProfileAdapter pa=new ProfileAdapter(this,R.layout.grid,al);
        gridView.setAdapter(pa);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0:

                        Intent intent=new Intent(ProfilePage.this,MyProfile.class);
                        startActivity(intent);
//                        transaction.replace(R.id.mainRLayout,new Profile(),"HIII");
//                        transaction.commit();
                        // fragmentToLaunch = new Profile();
                        //  isTransaction = true;
                        break;
                    case 1:
                        Intent i=new Intent(ProfilePage.this,Attendence.class);
                        startActivity(i);

//                        transaction.replace(R.id.mainRLayout,new Attendence(),"Hlo");
//                        transaction.commit();
                        //fragmentToLaunch = new Attendence();
                        // isTransaction = true;
                        break;
                    case 2:
                        Intent i1=new Intent(ProfilePage.this,HomeWork.class);
                        startActivity(i1);
                        // fragmentToLaunch=new HomeWork();
                        // isTransaction = true;
                        break;
                    case 3:
                        Intent i2=new Intent(ProfilePage.this,Fee.class);
                        startActivity(i2);
                        // fragmentToLaunch=new Fee();
                        // isTransaction = true;
                        break;

                    case 4:

                        Intent i3=new Intent(ProfilePage.this,Calender.class);
                        startActivity(i3);
                        //  fragmentToLaunch=new Calender();
                        //  isTransaction = true;
                        break;

                    case 5:
                        Intent i4=new Intent(ProfilePage.this,TimeTable.class);
                        startActivity(i4);
                        // fragmentToLaunch=new TimeTable();
                        // isTransaction = true;
                        break;

                    case 6:
                        Intent i5=new Intent(ProfilePage.this,Library.class);
                        startActivity(i5);
                        //fragmentToLaunch=new Library();
                        //isTransaction = true;
                        break;

                    case 7:
                        Intent i6=new Intent(ProfilePage.this,Transport.class);
                        startActivity(i6);
                        // fragmentToLaunch=new Transport();
                        // isTransaction = true;
                        break;

                    case 8:

                        Intent i7=new Intent(ProfilePage.this,ExamResult.class);
                        startActivity(i7);
                        //fragmentToLaunch=new ExamResult();
                        //isTransaction = true;
                        break;

                    case 9:

                        Intent i8=new Intent(ProfilePage.this,Hostal.class);
                        startActivity(i8);
                        //fragmentToLaunch=new Hostal();
                        //isTransaction = true;
                        break;

                    case 10:

                        Intent i9=new Intent(ProfilePage.this,HealthCare.class);
                        startActivity(i9);
                        //  fragmentToLaunch=new HealthCare();
                        // isTransaction = true;
                        break;

                    case 11:

                        Intent i10=new Intent(ProfilePage.this,ApplyLeave.class);
                        startActivity(i10);
                        // fragmentToLaunch=new ApplyLeave();
                        // isTransaction = true;
                        break;

                    case 12:

                        Intent i11=new Intent(ProfilePage.this,VehicleTracking.class);
                        startActivity(i11);
                        //fragmentToLaunch=new VehicleTraining();
                        // isTransaction = true;
                        break;

                    case 13:
                        Intent i12=new Intent(ProfilePage.this,News.class);
                        startActivity(i12);

                        //fragmentToLaunch=new Neaws();
                        //isTransaction = true;
                        break;

                    case 14:

                        Intent i13=new Intent(ProfilePage.this,Communication.class);
                        startActivity(i13);
                        //fragmentToLaunch=new Communication();
                        // isTransaction = true;
                        break;

                    case 15:
                        Intent i14=new Intent(ProfilePage.this,Circular.class);
                        startActivity(i14);

                        //fragmentToLaunch=new Circular();
                        //isTransaction = true;
                        break;

                    case 16:

                        Intent i15=new Intent(ProfilePage.this,Birthday.class);
                        startActivity(i15);
                        // fragmentToLaunch=new BirthDay();
                        //isTransaction = true;
                        break;

                    case 17:
                        Intent i16=new Intent(ProfilePage.this,Download.class);
                        startActivity(i16);

                        // fragmentToLaunch=new Download();
                        //isTransaction = true;
                        break;

                    case 18:
                        Intent i17=new Intent(ProfilePage.this,Gallery.class);
                        startActivity(i17);

                        // fragmentToLaunch=new Gallery();
                        // isTransaction = true;
                        break;

                    case 19:

                        Intent i18=new Intent(ProfilePage.this,Achievement.class);
                        startActivity(i18);
                        //fragmentToLaunch=new Achievement();
                        // isTransaction = true;
                        break;


                    case 20:
                        Intent i19=new Intent(ProfilePage.this,MySchoolWeb.class);
                        startActivity(i19);
                        // fragmentToLaunch=new Assignment();
                        // isTransaction = true;
                        break;



                }


            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
