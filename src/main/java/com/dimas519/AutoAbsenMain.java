package com.dimas519;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoAbsenMain {
    public static void main(String[] args){
        OperatingSystem os=new OperatingSystem();


        switch (os.getOS()){
            case WINDOWS -> System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        }

        ChromeOptions options =new ChromeOptions();
        ChromeDriver driver=new ChromeDriver(options);

//
//        System.out.println("test");
    }
}
