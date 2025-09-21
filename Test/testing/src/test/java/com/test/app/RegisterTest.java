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
        try{
            driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
            WebElement name=driver.findElement(By.name("name"));
            Assert.assertTrue(name.isDisplayed());
            System.out.println("Pre name text box");
            name.sendKeys("Nikita Bansode");
            Thread.sleep(3000);
            Assert.assertEquals("Nikita Bansode",name.getAttribute("value"));
            WebElement mail=driver.findElement(By.name("mail"));
            mail.sendKeys("nikita123@gmail.com");
            WebElement number=driver.findElement(By.id("num"));
            number.sendKeys("9087654321");
            WebElement date=driver.findElement(By.id("dob"));
            date.sendKeys("05-10-2005");
            WebElement pass=driver.findElement(By.id("pass"));
            pass.sendKeys("password");
            WebElement button1=driver.findElement(By.id("course1"));
            button1.click();
            WebElement submit=driver.findElement(By.id("submit"));
            System.out.println("Pre Submit button");
            submit.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlContains("welcome.html"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

//     @Test
//     public void testmail(){
//         try{
//             driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
//             WebElement mail=driver.findElement(By.name("mail"));
//             Assert.assertTrue(mail.isDisplayed());
//             mail.sendKeys("nikita123@gmail,com");
//             Thread.sleep(3000);
//             Assert.assertEquals("nikita123@gmail,com",mail.getAttribute("value"));
//         }catch(Exception e){
//             e.printStackTrace();
//         }
        
//     }

//     @Test
//     public void testNumber(){
//         try{
//             driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
//             WebElement number=driver.findElement(By.id("num"));
//             Assert.assertTrue(number.isDisplayed());
//             number.sendKeys("9087654321");
//             Thread.sleep(3000);
//              Assert.assertEquals("9087654321",number.getAttribute("value"));
//         }catch(Exception e){
//             e.printStackTrace();
//         }
        
       
//     }

//     @Test
//     public void testDate(){
//         try{
//             driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
//             WebElement date=driver.findElement(By.id("dob"));
//             Assert.assertTrue(date.isDisplayed());
//             date.sendKeys("05-10-2005");
//             Thread.sleep(3000);
//             Assert.assertEquals("05-10-2005",date.getAttribute("value"));
//         }catch(Exception e){
//             e.printStackTrace();
//         }
        
//     }

//     @Test
//     public void testPassword(){
//         try{
//             driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
//             WebElement pass=driver.findElement(By.id("pass"));
//             Assert.assertTrue(pass.isDisplayed());
//             pass.sendKeys("password");
//             Thread.sleep(3000);
//             Assert.assertEquals("password",pass.getAttribute("value"));
//         }catch(Exception e){
//             e.printStackTrace();
//         }
        
//     }

//     @Test
//     public void testButton(){
//         try{
//             driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
//             WebElement button1=driver.findElement(By.name("course1"));
//             WebElement button2=driver.findElement(By.name("course2"));
//             WebElement button3=driver.findElement(By.name("course3"));
//             WebElement button4=driver.findElement(By.name("course4"));

//             Assert.assertTrue(button1.isDisplayed());
//             Assert.assertTrue(button2.isDisplayed());
//             Assert.assertTrue(button3.isDisplayed());
//             Assert.assertTrue(button4.isDisplayed());

//             button1.click();
//             Thread.sleep(3000);
//            // button2.click();
//            // button3.click();
//            // button4.click();
//         }catch(Exception e){
//             e.printStackTrace();
//         }
        
//     }

//     @Test
//     public void testSubmit(){
//         try{
//              driver.get("http://127.0.0.1:5500/src/main/webpages/register.html");
//             WebElement submit=driver.findElement(By.id("submit"));
//             Assert.assertTrue(submit.isDisplayed());
//             submit.click();
//             Thread.sleep(5000);
//         }catch(Exception e){
//             e.printStackTrace();
//         }
       
//     }
}
