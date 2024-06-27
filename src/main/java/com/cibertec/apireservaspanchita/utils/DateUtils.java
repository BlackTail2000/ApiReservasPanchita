package com.cibertec.apireservaspanchita.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static Date convertStringToDate(String fec) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = dateFormat.parse(fec);
        } catch(ParseException e) {
            System.out.println(e.getMessage());
        }
        return date;
    }
}
