package com.dimas519.Website;

import com.dimas519.Model.Kuliah;
import com.dimas519.Model.User;

import com.dimas519.Tools.Sleep;
import com.dimas519.Tools.Tray;
import com.dimas519.Tools.Waktu;
import org.openqa.selenium.*;
import java.time.Duration;
import java.util.List;

public class WebsiteStupor   implements WebsiteUnpar {
    private User user;
    private final String url="https://studentportal.unpar.ac.id/";

    private  WebDriver driver;
    public WebsiteStupor(WebDriver driver,User user){
        this.user=user;
        this.driver=driver;
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        this.driver.get(this.url+"jadwal/");
        this.doLogin();

    }

    public boolean doLogin(){
        this.driver.get(this.url);
        try{
            SSO.login(driver,this.user);
            return false;
        }catch (Exception e){
            return true;
        }
    }



    @Override
    public boolean doAbsen(Kuliah matakuliah){
        try{
            this.driver.get(this.url+"jadwal/");
            String currUrl=this.driver.getCurrentUrl();

            if(currUrl.equalsIgnoreCase(this.url+"jadwal") || currUrl.equalsIgnoreCase(this.url+"jadwal/") ){
                return this.absensi(matakuliah);
            }else{
                SSO.login(this.driver,this.user);
                return this.absensi(matakuliah);
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }



    private boolean absensi(Kuliah jadwal){
        boolean suksesAbsen =false;
        int i=0;
        while (!suksesAbsen && i <100) {
            WebElement jamIde = this.driver.findElement(By.id("theTime"));
            Tray.printInfo("Time in Stupor : "+jamIde.getText()+" VS COMP TIME"+ Waktu.getTimeNow());
            String kuliah = jadwal.getMata_Kuliah();
            WebElement tableJadwal = this.driver.findElement(By.className("table"));
            WebElement tdMatkul = tableJadwal.findElement(By.xpath("//td[contains(.,'" + kuliah + "')]"));
            WebElement rowMatkul = tdMatkul.findElement(By.xpath("./.."));
            WebElement btnAbsen = rowMatkul.findElement(By.className("btn-danger"));


            if(!btnAbsen.isEnabled()){
                Tray.printInfo(jadwal.getMata_Kuliah()+ " already done before or invalid jadwal");
                return true;
            }else{
                btnAbsen.click();
                Sleep.Sleep(3l);
                List<WebElement> swals = this.driver.findElements(By.className("swal-modal"));
                if (!swals.isEmpty()) {
                    for (WebElement x : swals) {
                        System.out.println("swal modal size"+swals.size());
                        List<WebElement> swalsPresensi=x.findElements(By.className("swal-title"));
                        System.out.println("swal title size"+swalsPresensi.size());
                        for(WebElement y:swalsPresensi){
                            if (y.getText().equalsIgnoreCase("Info Presensi Perkuliahan")){
                                WebElement btnConfirm = x.findElement(By.className("swal-button--confirm"));
                                btnConfirm.click();
                                Tray.printInfo(jadwal.getMata_Kuliah()+" Done");
                                suksesAbsen=true;
                                return suksesAbsen;
                            }else if( !x.getText().equalsIgnoreCase("Mahasiswa sudah melakukan absensi sebelumnya")){
                                Tray.printInfo(jadwal.getMata_Kuliah()+ "already done before");
                                suksesAbsen=true;
                                return suksesAbsen;
                            }
                        }
                        if(suksesAbsen){
                            break;
                        }

                    }
                }
            }



            i++;
        }
        return suksesAbsen;
    }






}
