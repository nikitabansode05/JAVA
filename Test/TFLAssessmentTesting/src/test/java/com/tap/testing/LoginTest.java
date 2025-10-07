package com.tap.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest{
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts=new ChromeOptions();
        driver=new ChromeDriver(opts);
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest(){
        driver.get("http://127.0.0.1:5500/Home.html");
        driver.findElement(By.linkText("Login")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("loginJWT.html"));

        WebElement mail=driver.findElement(By.id("email"));
        WebElement pass=driver.findElement(By.id("password"));

        mail.sendKeys("nikita.bansode@example.com");
        Assert.assertEquals("nikita.bansode@example.com",mail.getAttribute("value"));
        pass.sendKeys("12345");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("/Student/student.html"));
    }
}