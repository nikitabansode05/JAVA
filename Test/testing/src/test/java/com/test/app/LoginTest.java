package com.test.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginTest {
    
WebDriver driver;

@BeforeClass
public void beforeMethod(){
   WebDriverManager.chromedriver().setup();
   driver=new ChromeDriver();
   driver.manage().window().maximize();
}

@Test
public void testTitle(){
    driver.get("http://127.0.0.1:5500/src/main/webpages/login.html");
    String title=driver.getTitle();
    Assert.assertEquals(title,"login page");
}

@Test
public void testName(){
    driver.get("http://127.0.0.1:5500/src/main/webpages/login.html");
    WebElement inputName=driver.findElement(By.name("username"));
    Assert.assertTrue(inputName.isDisplayed());
}

@Test
public void testPassword(){
    driver.get("http://127.0.0.1:5500/src/main/webpages/login.html");
    WebElement pass=driver.findElement(By.name("password"));
    Assert.assertTrue(pass.isDisplayed());
}

// @Test
// public void loginSuccess(){
//     driver.get("http://127.0.0.1:5500/src/main/webpages/login.html");
//     driver.findElement(By.name("password")).sendKeys("Nikita@123");
//     driver.findElement(By.name("username")).sendKeys("Nikita");
//     driver.findElement(By.name("submit")).click();

//     // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
//     // wait.until(ExpectedConditions.urlContains(null));
// }
}