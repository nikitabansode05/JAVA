package com.tap.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest{

    @Test
    public void adminTest(){

        driver.findElement(By.linkText("Login")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("loginJWT.html"));

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        email.sendKeys("ravi.tambade@example.com");
        password.sendKeys("12345");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("http://127.0.0.1:5500/Admin/admin.html"));

        WebElement assignTest= driver.findElement(By.id("showTestBtw"));
        assignTest.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromDate")));
        WebElement startDate = driver.findElement(By.id("fromDate"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '2025-10-07';"+
                                                    "arguments[0].dispatchEvent(new Event('input',{bubbles:true} ));"+
                                                    "arguments[0].dispatchEvent(new Event('change' ,{bubbles:true}))", startDate);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toDate")));
        WebElement endDate =  driver.findElement(By.id("toDate"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '2025-10-10';"+
                                                    "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));"+
                                                    "arguments[0].dispatchEvent(new Event('change',{bubbles:true}))" , endDate) ;
    
        driver.findElement(By.xpath("//button[@onclick='fetchTests()']")).click();
    
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='updateTest(25)']")));
        driver.findElement(By.xpath("//button[@onclick='updateTest(25)']")).click();
        wait.until(ExpectedConditions.urlContains("Admin/updatetest.html"));

        WebElement statusDropdown = driver.findElement(By.id("statusDropdown"));
        Select selectStatus = new Select(statusDropdown);
        selectStatus.selectByVisibleText("Scheduled");

        //driver.findElement(By.id("changeStatus")).click();
    
        WebElement scheduledStart = driver.findElement(By.id("scheduledStart"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='2025-10-08T11:00:00';"+
                                                    "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));"+
                                                    "arguments[0].dispatchEvent(new Event('change',{bubbles:true}))",scheduledStart);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scheduledEnd")));
        WebElement scheduledEnd = driver.findElement(By.id("scheduledEnd"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='2025-10-09T12:00:00';"+
                                                    "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));"+
                                                    "arguments[0].dispatchEvent(new Event('change',{bubbles:true}))", scheduledEnd);

        WebElement remarks=driver.findElement(By.id("remarks"));
        remarks.sendKeys("All The Best for Your Test");

        driver.findElement(By.id("getStudents")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='emp-checkbox' and @value='7']")));
        WebElement selectStudent=driver.findElement(By.xpath("//input[@class='emp-checkbox' and @value='7']"));
        selectStudent.click();
        driver.findElement(By.id("addStudent")).click();
 }


    
}
