package com.example.admin.schoolappondemand;

import android.graphics.Color;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 3/23/2017.
 */

public class LeaveDecorator implements DayViewDecorator {

    private final Calendar calendar = Calendar.getInstance();

    private CalendarDay date;


    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay == Calendar.WEDNESDAY;
    }

    @Override
    public void decorate(DayViewFacade view) {

        view.addSpan(new ForegroundColorSpan(Color.GRAY));

    }

    public void setDate(Date date) {
        this.date = CalendarDay.from(date);
    }
}
