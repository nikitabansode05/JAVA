package com.transflower;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

class CartTest{

    private WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testCart(){
        driver.get("http://localhost:8000/index.html");
        WebElement gallery = driver.findElement(By.id("Gallery"));
        gallery.click();
        String afterClick=driver.getCurrentUrl();
        assertTrue(afterClick.contains("catalog.html"),afterClick);
    }

}