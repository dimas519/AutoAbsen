package com.dimas519.Website;

import com.dimas519.Model.User;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebsiteStupor extends SSO {
    private final static String url="https://studentportal.unpar.ac.id/";
    private  WebDriver driver;

    public WebsiteStupor(WebDriver driver){
        this.driver=driver;
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public boolean doAbsen(User user){
        try {
            this.driver.get(this.url);
            super.login(this.driver,user);
            this.driver.get(this.url+"jadwal");





        }catch (Exception e){
            System.out.println("TimeOut");
            return true; //suruh ulang
        }finally {
            this.driver.close();
        }
        return false;
    }






}
