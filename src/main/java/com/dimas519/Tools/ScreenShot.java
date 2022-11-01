package com.dimas519.Tools;

import com.dimas519.Model.Kuliah;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public static void getScreenShoot(WebDriver driver, Kuliah kuliah,String ssFolder){
        try {
            String namaFile=ssFolder+"\\"+kuliah.getMata_Kuliah()+"-"+Waktu.getDate();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(namaFile+".jpg"));
        } catch (IOException e) {
            Tray.printError("Error Screen-Shot:"+e.getMessage());
        }
    }
}
