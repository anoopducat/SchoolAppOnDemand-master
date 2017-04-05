package com.example.admin.schoolappondemand;

import android.content.Context;
import android.graphics.Color;
import android.text.style.ForegroundColorSpan;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by admin on 4/5/2017.
 */

public class MyJsonDet  implements DayViewDecorator {

    private CalendarDay date;
    private final HashSet<CalendarDay> dates;



    public MyJsonDet(CalendarDay date, HashSet<CalendarDay> dates) {
        this.date = date;
        this.dates = dates;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {


        return date != null && day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {

        view.addSpan(new ForegroundColorSpan(Color.RED));

    }
    public void setDate(Date date) {
        this.date = CalendarDay.from(date);
    }
}
