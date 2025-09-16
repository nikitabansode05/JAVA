package com.transflower;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginPageTitle() {
        driver.get("http://127.0.0.1:5500/WebUI/login.html");
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        Assert.assertEquals(title, "Login by pradnya");
    }

    @Test
    public void testLoginButtonExists() {
        driver.get("http://127.0.0.1:5500/WebUI/login.html");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
