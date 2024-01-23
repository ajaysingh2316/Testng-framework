package com.metlife.testsuits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver driver;
    @Test

    public void invalidlogin() {

        driver.findElement(By.id("authUser")).sendKeys("admin");
        driver.findElement(By.id("clearPass")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.className("login-failure")).getText();


        Assert.assertEquals(error, "Invalid username or password");



    }

    @Test(enabled = true)
    public void validlogin() {


        driver.findElement(By.id("authUser")).sendKeys("admin");
        driver.findElement(By.id("clearPass")).sendKeys("pass1s");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.className("login-failure")).getText();


        Assert.assertEquals(error, "Invalid username or password");


    }
@BeforeMethod

    public void setup(){
        driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get("http://demo.openemr.io/b/openemr/interface/login/login.php?site=default");



}
@AfterMethod
    public void teardown(){
        driver.quit();
}
}
