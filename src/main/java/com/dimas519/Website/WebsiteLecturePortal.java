package com.dimas519.Website;

import com.dimas519.Model.Kuliah;
import com.dimas519.Model.User;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebsiteLecturePortal implements WebsiteUnpar {
    private User user;
    private final String url="https://lectureportal.unpar.ac.id/";
    private WebDriver driver;
    public WebsiteLecturePortal(WebDriver driver,User user){
        this.user=user;
        this.driver=driver;
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Override
    public boolean doAbsen(Kuliah matakuliah) {
        return false;
    }
}
