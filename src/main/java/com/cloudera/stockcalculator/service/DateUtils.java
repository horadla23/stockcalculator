package com.cloudera.stockcalculator.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    private DateUtils() {}

    public static String getDateString(Date date) {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static Date subtractDate(Date original) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(original);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
}
