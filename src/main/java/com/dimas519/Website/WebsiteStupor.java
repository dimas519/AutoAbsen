package com.dimas519.Website;

import com.dimas519.Model.User;

import org.openqa.selenium.WebDriver;

public class WebsiteStupor extends SSO {
    private final static String url="https://studentportal.unpar.ac.id/";
    private  WebDriver driver;

    public WebsiteStupor(WebDriver driver){
        this.driver=driver;
    }

    public boolean doAbsen(User user){
        this.driver.get(this.url);
        super.login(this.driver,user);
        this.driver.get(this.url+"jadwal");


        return true;
    }






}
