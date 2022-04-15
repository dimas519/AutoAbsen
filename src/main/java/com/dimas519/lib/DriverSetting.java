package com.dimas519.lib;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class DriverSetting {
    public static WebDriver setup(String something){
        switch (something){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsC =new ChromeOptions();
               // optionsC.addArguments("headless");
                ChromeDriver driverC=new ChromeDriver(optionsC);
                return driverC;
            case "Firefox" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions  optionsF =new FirefoxOptions();
              //  optionsF.addArguments("headless");
                FirefoxDriver driverF=new FirefoxDriver(optionsF);
                return driverF;
            case "Edge" :
                WebDriverManager.edgedriver().setup();
                EdgeOptions optionsE =new EdgeOptions();
               // optionsE.addArguments("headless");
                EdgeDriver driverE=new EdgeDriver(optionsE);
                return driverE;
            case "Safari" :
                WebDriverManager.safaridriver().setup();
                SafariOptions optionsS=new SafariOptions();

                SafariDriver driverS=new SafariDriver(optionsS);
                return driverS;
            default:
                return null;
        }
    }
}
