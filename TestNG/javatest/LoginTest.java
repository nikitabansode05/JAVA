package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


import static org.assertj.core.api.Assertions.assertThat;


public class LoginTest extends BaseTest {


@Test
public void login_success_and_navigate_home() {
driver.get("http://localhost:5500/login.html");
driver.findElement(By.cssSelector("[data-test='input-username']")).sendKeys("admin");
driver.findElement(By.cssSelector("[data-test='input-password']")).sendKeys("admin");
driver.findElement(By.cssSelector("[data-test='btn-login']")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.urlContains("index.html"));
assertThat(driver.getCurrentUrl()).contains("index.html");
}
}