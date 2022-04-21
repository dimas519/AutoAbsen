package com.dimas519.Website;

import com.dimas519.Model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class SSO {
    public void login(WebDriver driver, User user) throws InterruptedException {
        Random random=new Random();


        Thread.sleep(random.nextLong(500,3000));
        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(random.nextLong(500,3000));
        WebElement usernameForm=driver.findElement(By.id("username"));
        usernameForm.sendKeys(user.getEmail());

        Thread.sleep(random.nextLong(500,3000));
        WebElement nextLogin=driver.findElement(By.id("next_login"));
        nextLogin.click();

        Thread.sleep(random.nextLong(500,3000));
        WebElement password =driver.findElement(By.id("password"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(user.getPassword());

        Thread.sleep(random.nextLong(500,3000));
        WebElement login=driver.findElement(By.id("fm1"));
        login.submit();
    }
}
