package com.nmb.bancassurance.payments.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings({"unused"})
public final class DateFormatter {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String DATE_TIME_FORMAT_WITHOUT_MILLIS = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private DateFormatter() {}

    public static String formatToDate(Date date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    public static String formatToDateTime(Date date) {
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(date);
    }

    public static String formatToDateTimeWithoutMillis(Date date) {
        return new SimpleDateFormat(DATE_TIME_FORMAT_WITHOUT_MILLIS).format(date);
    }

    public static Date parseDate(String dateString){
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
