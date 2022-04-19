package com.dimas519;

import com.dimas519.Model.DBModel;
import com.dimas519.Model.Kuliah;
import com.dimas519.Model.User;
import com.dimas519.Tools.Sleep;
import com.dimas519.Tools.Waktu;
import com.dimas519.Website.WebsiteStupor;
import com.dimas519.lib.DriverSetting;

import org.openqa.selenium.WebDriver;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;



//args 0 for usernameStupor
//args 1 for passwordStupor

//args 2 for pred browser


//args 3 for port
//args 4 for username db
//args 5 for password db
//args 6 for db name
//args 7 for table name


public class AutoAbsenMain {
    public static void main(String[] args){

        //init init
        User user=new User(args[0],args[1]);
        DBModel dbModel= new DBModel(args[3],args[4],args[5],args[6],args[7]);

        Database db=new Database(dbModel);
        WebDriver driver=DriverSetting.setup("");

        Kuliah next;

        while (true){
            int hari=Waktu.getDate();
            String jamSekarang= Waktu.getTimeNow();

            //ambilMatkulBerikutnya
            next=db.getNextTime(hari,jamSekarang);
            Long timeBerikutnya=next.getJam();

            Long jamSekarangFormat = Waktu.getTime(jamSekarang);
            Long durasiWait = timeBerikutnya - jamSekarangFormat;

            Sleep.Sleep(durasiWait);

            //debug
            System.out.println(next.getMata_Kuliah()+" "+LocalDate.now()+" "+LocalTime.now());
            System.out.println();

            if(next.getisLecture()){
//                WebsiteStupor stupor=new WebsiteStupor(driver);
//                stupor.doAbsen(user);
            }else{

            }
            System.out.println(LocalTime.MAX);









        }
//
//
//
//
//
//




    }
}
