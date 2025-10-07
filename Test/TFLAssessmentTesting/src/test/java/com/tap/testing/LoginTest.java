package com.tap.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        try{
        driver.get("http://127.0.0.1:5500/Home.html");
        driver.findElement(By.linkText("Login")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("loginJWT.html"));

        WebElement mail=driver.findElement(By.id("email"));
        WebElement pass=driver.findElement(By.id("password"));

        mail.sendKeys("nikita.bansode@example.com");
        pass.sendKeys("12345");
        Assert.assertEquals("nikita.bansode@example.com",mail.getDomProperty("value"));
        Thread.sleep(1000);
        Assert.assertEquals("12345", pass.getDomProperty("value"));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Student logged in");

        wait.until(ExpectedConditions.urlContains("/Student/student.html"));
        Thread.sleep(2000);
        driver.findElement(By.linkText("Get All Test")).click();
        Thread.sleep(2000);

        //driver.findElement(By.xpath("//button[@data-id='3']")).click();
       //driver.findElement(By.cssSelector("button[data-id='3']").click();

        // WebElement btn = driver.findElement(By.cssSelector("button[data-id='3']"));
        // btn.click();

        // WebElement detailsBtn = driver.findElement(By.xpath("//button[contains(@data-test, 'Java')]"));
        // detailsBtn.click();

        driver.findElement(By.xpath("//button[@class='detailsBtn' and contains(@data-test, 'Java')]")).click();
        driver.findElement(By.xpath("//button[@class='startBtn' and contains(@data-id,'3')]")).click();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}