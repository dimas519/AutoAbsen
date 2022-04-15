package com.dimas519;

import com.dimas519.Model.User;
import com.dimas519.lib.DriverSetting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//args 0 for username
//args 1 for password

//args pref 2 for browser use



// args 0 for windows
// args 1 for mac os
// args 2 for linux


public class AutoAbsenMain {
    public static void main(String[] args){
        OperatingSystem os=new OperatingSystem();
        User user=new User(args[0],args[1]);
        WebDriver driver= DriverSetting.setup(args[2]);

        Website absenProses=new Website(driver);

        absenProses.doAbsen(user);






    }
}
