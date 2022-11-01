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
    public static WebDriver setup(String something, String headless){
        boolean  headlessBool=Boolean.parseBoolean(headless);

        switch (something){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsC =new ChromeOptions();
                if(headlessBool) optionsC.addArguments("headless","--window-size=1920,1080");
                optionsC.addArguments("--start-maximized");
                ChromeDriver driverC=new ChromeDriver(optionsC);
                return driverC;
            case "Firefox" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions  optionsF =new FirefoxOptions();
                if(headlessBool) optionsF.addArguments("headless");
                FirefoxDriver driverF=new FirefoxDriver(optionsF);
                driverF.manage().window().maximize();
                return driverF;
            case "Edge" :
                WebDriverManager.edgedriver().setup();
                EdgeOptions optionsE =new EdgeOptions();
                if(headlessBool) optionsE.addArguments("headless");
                optionsE.addArguments("--start-maximized");
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
