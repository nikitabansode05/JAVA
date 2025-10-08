package com.tap.testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SMETest extends BaseTest{

    @Test
    public void smeTest(){
        try{
        driver.findElement(By.linkText("Login")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("loginJWT.html"));

        WebElement mail=driver.findElement(By.id("email"));
        WebElement pass=driver.findElement(By.id("password"));

        mail.sendKeys("nirjala.naik@example.com");
        pass.sendKeys("12345");
        Assert.assertEquals("nirjala.naik@example.com",mail.getDomProperty("value"));
        Assert.assertEquals("12345",pass.getDomProperty("value"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("SME/sme.html"));
        driver.findElement(By.linkText("Get Subject and Criteria via Questions")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlSubjects")));
        WebElement dropdownSubject = driver.findElement(By.id("ddlSubjects"));
        Select select = new Select(dropdownSubject);
        select.selectByVisibleText("DOTNET");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlCriteria")));
        System.out.println("******************Drop down is working for get subject and criteria*************************");

        driver.findElement(By.linkText("Create Test")).click();

        WebElement inputText=driver.findElement(By.id("testName"));
        inputText.sendKeys("Advance Java Test");

        WebElement duration=driver.findElement(By.id("duration"));
        duration.sendKeys("00:15:00");
        System.out.println("*********************The duration is getting filled up*******************************");
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subjectSelect")));
        WebElement dropdown=driver.findElement(By.id("subjectSelect"));
        Select selectSubject=new Select(dropdown);

        selectSubject.selectByVisibleText("ADVJAVA");
        System.out.println("*****The Drop Down of creating the test is working***********************");
        Thread.sleep(1000);
      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("smeSelect")));
        WebElement dropdownSme = driver.findElement(By.id("smeSelect"));
        Select sme = new Select(dropdownSme);
        sme.selectByVisibleText("kajal ghule");
        Thread.sleep(1000);

        WebElement date = driver.findElement(By.id("scheduledDate"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("scheduledDate")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '2025-10-08T11:00';" +
                                                    "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                                                    "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",date);
        // date.clear();
        // date.sendKeys("08-10-2025 T 11:05:00");

        WebElement passingLevel = driver.findElement(By.id("passingLevel"));
        passingLevel.sendKeys("5");
        
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("questionsList")));
        WebElement questions = driver.findElement(By.id("questionsList"));
        List<WebElement> checkboxes = questions.findElements(By.tagName("input"));

        for(WebElement question: checkboxes){
            question.click();
        }
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.id("submitBtn"));
        submitButton.click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.urlContains("SME/reviewtest.html"));
        WebElement confirmButton = driver.findElement(By.id("confirmBtn"));
        confirmButton.click();


        }catch(Exception e){
            System.out.println(e);
        }
    }
}
