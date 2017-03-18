package com.example.admin.schoolappondemand;

import android.graphics.Color;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by admin on 3/3/2017.
 */

public class OneDayDecorator implements DayViewDecorator {

    private CalendarDay date;

    public OneDayDecorator(int colorGreen, HashSet<CalendarDay> setDays) {
        date = CalendarDay.today();
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
