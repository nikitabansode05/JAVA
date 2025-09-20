package com.test.app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterSubmit {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRegistrationForm(){
        try{
            driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");

      /*       WebElement name=driver.findElement(By.name("name"));
            WebElement mail=driver.findElement(By.name("mail"));
            WebElement number=driver.findElement(By.id("num"));
            WebElement date=driver.findElement(By.id("dob"));
            WebElement pass=driver.findElement(By.id("pass"));
            WebElement button1=driver.findElement(By.name("course1"));
            WebElement submit=driver.findElement(By.id("submit"));

            name.sendKeys("Nikita Bansode");
            mail.sendKeys("nikita123@gmail.com");
            number.sendKeys("9087654321");
            date.sendKeys("2005-10-05");
            pass.sendKeys("password");
            button1.click();
            submit.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
            */
        }catch(Exception e){
            e.printStackTrace();
        }
         
    }
}
