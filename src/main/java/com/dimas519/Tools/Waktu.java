package com.dimas519.Tools;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.NtpV3Packet;
import org.apache.commons.net.ntp.TimeInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Waktu {
    public static final long MIDNIGHT=LocalTime.MAX.toSecondOfDay();

    public static int getNumDate(){
        int hari= getLocalDate().getDayOfWeek().getValue();
        return hari;
    }

    public static long getTime(String x){
        LocalTime time=LocalTime.parse(x);
        long detik=time.toSecondOfDay();
        return detik;
    }

    public static String getTimeNow(){
        LocalTime jam=getLocalTime();
        String res=jam.toString().substring(0,8);
        return res;
    }

    public static String getDate(){
        LocalDate waktu= getLocalDate();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d-MM-uuu");
        String res=waktu.format(formatters);
        return res;
    }

    private static long getEpochTime(){
        NTPUDPClient timeClient = new NTPUDPClient();
        String TIME_SERVER = "pool.ntp.org";
        InetAddress inetAddress =null;
        TimeInfo timeInfo = null;
        try {
            inetAddress=InetAddress.getByName(TIME_SERVER);
            timeClient.open();
            timeClient.setDefaultTimeout(60000);
            timeInfo = timeClient.getTime(inetAddress);
        } catch (IOException e) {
            Tray.printError("NTP FAILED",e);
        }finally {
            if(timeClient.isOpen()) {
                timeClient.close();
            }
        }
        NtpV3Packet message = timeInfo.getMessage();


        return message.getTransmitTimeStamp().getTime();
    }

    private static LocalDate getLocalDate(){
        return Instant.ofEpochMilli(getEpochTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static LocalTime getLocalTime(){
        return LocalTime.from(Instant.ofEpochMilli(getEpochTime()).atOffset(ZoneOffset.ofHours(7)));
    }

    public static String convertNormalTime(long second){
        long hour=second/3600;
        second%=3600;
        long minutes=second/60;
        second%=60;

        String result=hour+" jam "+minutes+" menit "+second+" detik";
        return result;

    }

}
