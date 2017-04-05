package com.example.admin.schoolappondemand;


import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.format.DayFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

public class Attendence extends AppCompatActivity {

    TextView tv1;
    MaterialCalendarView materialCalendarView;
    Calendar cal1,cal2;

    String url ="http://203.124.96.117:8063/Service1.asmx/Attendance";
    RequestQueue requestQueue;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestQueue= Volley.newRequestQueue(this);

         cal1 = Calendar.getInstance();
        cal1.set(2017, 1, 3);
         cal2 = Calendar.getInstance();
        cal2.set(2017, 2, 3);

        HashSet<CalendarDay> setDays = getCalendarDaysSet(cal1, cal2);
        //int myColor = R.color.red;
       // mCalendarView.addDecorator(new BookingDecorator(myColor, setDays));

        setContentView(R.layout.activity_attendence);

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

        tv1.setText("Attendence");

        materialCalendarView= (MaterialCalendarView) findViewById(R.id.calendarView);
        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(CalendarDay.from(1900, 1, 1))
                .setMaximumDate(CalendarDay.from(2100, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();



        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Toast.makeText(Attendence.this, "" + date, Toast.LENGTH_SHORT).show();
            }
        });


        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {



                for(int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject object= (JSONObject) response.get(0);
                        String det=object.getString("Att_date");

                        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd//mm//yyyy", Locale.US);
                       // Date date=simpleDateFormat.parse(det);

                        Toast.makeText(Attendence.this, det, Toast.LENGTH_SHORT).show();

                       // Date date = s.parse(str);


                        //Date date=simpleDateFormat.parse(det);
                        //materialCalendarView.setDayFormatter((DayFormatter) simpleDateFormat);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Attendence.this, "" +error, Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(jsonArrayRequest);





        materialCalendarView.addDecorator(new MonDay(R.color.colorIndi,setDays));
        materialCalendarView.addDecorator(new OneDayDecorator(R.color.colorGreen,setDays));
        materialCalendarView.addDecorator(new LeaveDecorator());
        materialCalendarView.addDecorator(new PresentStudent());

        

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private HashSet<CalendarDay> getCalendarDaysSet(Calendar cal1, Calendar cal2) {
        HashSet<CalendarDay> setDays = new HashSet<>();
        while (cal1.getTime().before(cal2.getTime())) {
            CalendarDay calDay = CalendarDay.from(2017,03,1);
            setDays.add(calDay);
            cal1.add(Calendar.DATE, 1);
        }

        return setDays;
    }
}
