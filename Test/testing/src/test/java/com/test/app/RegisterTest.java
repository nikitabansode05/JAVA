package com.test.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class RegisterTest {
    
    private WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testName(){
        driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
        WebElement name=driver.findElement(By.name("name"));
        Assert.assertTrue(name.isDisplayed());
    }

    @Test
    public void testmail(){
        driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
        WebElement mail=driver.findElement(By.name("mail"));
        Assert.assertTrue(mail.isDisplayed());
    }

    @Test
    public void testNumber(){
        driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
        WebElement number=driver.findElement(By.id("num"));
        Assert.assertTrue(number.isDisplayed());
    }

    @Test
    public void testdate(){
        driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
        WebElement date=driver.findElement(By.id("dob"));
        Assert.assertTrue(date.isDisplayed());
    }
}
