package com.dimas519.Tools;

import java.time.LocalDate;
import java.time.LocalTime;



public class Waktu {
    public static final long MIDNIGHT=LocalTime.MAX.toSecondOfDay();

    public static int getDate(){
        int hari= LocalDate.now().getDayOfWeek().getValue();
        return hari;
    }

    public static long getTime(String x){
        LocalTime time=LocalTime.parse(x);
        long detik=time.toSecondOfDay();
        return detik;
    }

    public static String getTimeNow(){
        LocalTime jam=LocalTime.now();
        String res=jam.toString().substring(0,8);
        return res;
    }





}
