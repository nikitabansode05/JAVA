package com.tap.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts=new ChromeOptions();
        driver=new ChromeDriver(opts);
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/Home.html");
    }


}
