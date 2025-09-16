package com.transflower;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
protected WebDriver driver;


@BeforeMethod 
public void setUp(){
WebDriverManager.chromedriver().setup();
ChromeOptions opts = new ChromeOptions();
// uncomment headless for CI
// opts.addArguments("--headless=new");
driver = new ChromeDriver(opts);
driver.manage().window().maximize();
}


@AfterMethod
public void tearDown(){
if(driver != null) driver.quit();
}
}