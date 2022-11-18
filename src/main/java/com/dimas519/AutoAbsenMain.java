package com.dimas519;

import com.dimas519.Model.DBModel;
import com.dimas519.Model.Kuliah;
import com.dimas519.Model.User;
import com.dimas519.Tools.*;
import com.dimas519.Website.WebsiteLecturePortal;
import com.dimas519.Website.WebsiteStupor;
import com.dimas519.Website.WebsiteUnpar;
import com.dimas519.lib.DriverSetting;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;

import java.time.LocalTime;



//args 0 for usernameStupor
//args 1 for passwordStupor

//args 2 for pred browser

//args 3 for port
//args 4 for username db
//args 5 for password db
//args 6 for db name

//args 7 for screenshot directory
//args 8 for logging text

//args 9 for icon

//args 10 for headless true or false

public class AutoAbsenMain  implements MainInterface {
    public static void main(String[] args){
        AutoAbsenMain mainClass=new AutoAbsenMain();
        mainClass.mainMethod(args);
    }

    private WebDriver driver;
    private void mainMethod(String[] args){
        //init init
        Tray tray=new Tray(args[7],args[8],args[9],this);
        User userMahasiswa=new User(args[0],args[1]);
        DBModel dbModel= new DBModel(args[3],args[4],args[5],args[6]);
        Database db=new Database(dbModel);

        this.driver=DriverSetting.setup(args[2],args[10]);
        WebsiteUnpar web;
        Kuliah next;

        int i;

        Tray.printInfo("Modul AutoAbsen started");
        while (true){
            int hari=Waktu.getNumDate();
            String jamSekarang= Waktu.getTimeNow();

            //ambilMatkulBerikutnya
            next=db.getNextTime(hari,jamSekarang);
            Long timeBerikutnya=next.getJam();
            if(next.getIsLecture()){
                web=new WebsiteLecturePortal(this.driver,null);
            }else{
                web=new WebsiteStupor(this.driver,userMahasiswa);
            }

            jamSekarang= Waktu.getTimeNow();
            Long jamSekarangFormat = Waktu.getTime(jamSekarang);
            Long durasiWait = (timeBerikutnya - jamSekarangFormat)+5;


            Sleep.Sleep(durasiWait);
            //debug
            Tray.printNone(next.getMata_Kuliah()+" "+LocalDate.now()+" "+LocalTime.now());
            //loop keatas lagi
            if(timeBerikutnya!=Waktu.MIDNIGHT) {
                //absen
                boolean absen = false;//belum absen
                i = 1;
                while (!absen) {
                    absen = web.doAbsen(next);
                    System.out.println("try :"+i+" absen status:"+absen);
                    if (i < 101) {
                        if (absen) {
                            Sleep.Sleep(2L);
                            ScreenShot.getScreenShoot(driver, next, args[7]);
                        } else {
                            Tray.printWarning(next.getMata_Kuliah() + " failed " + i);
                            i++;
                        }
                    } else {
                        Tray.printError("ERROR ABSEN, ABSEN MANUAL");
                        break;
                    }
                    Sleep.Sleep(2L);
                }
                Sleep.Sleep(2L);
            }
        }
    }



    @Override
    public void close() {
        try {
            this.driver.close();
            System.exit(0);
            Tray.printInfo("Exit");
        }catch (Exception e){
            Tray.printError("failed close");
        }
    }
}
