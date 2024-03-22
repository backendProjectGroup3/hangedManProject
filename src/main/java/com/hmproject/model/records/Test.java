package com.hmproject.model.records;

import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();

        long time = end - start;

        Date date = new Date(time);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(start);
        cal.setTimeInMillis(end);
        System.out.println("start : " + cal.toString() + ", end : " + cal.toString());
        System.out.println("start : " + start);
        System.out.println("end : " + end);
        System.out.println("time : " + time);
    }
}
