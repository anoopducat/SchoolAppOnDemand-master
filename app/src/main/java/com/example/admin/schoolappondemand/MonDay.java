package com.example.admin.schoolappondemand;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by admin on 3/8/2017.
 */

public class MonDay implements DayViewDecorator {

    private final Calendar calendar = Calendar.getInstance();

    private CalendarDay date;



    public MonDay(int colorBlue, HashSet<CalendarDay> setDays) {
    }


    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay == Calendar.SUNDAY;

    }

    @Override
    public void decorate(DayViewFacade view) {

        view.addSpan(new ForegroundColorSpan(Color.MAGENTA));

    }

    public void setDate(Date date) {
        this.date = CalendarDay.from(date);
    }
}
