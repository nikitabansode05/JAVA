package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


import static org.assertj.core.api.Assertions.assertThat;


public class FormTest extends BaseTest {


@Test
public void fill_form_and_submit() {
driver.get("http://localhost:5500/form.html");
driver.findElement(By.cssSelector("[data-test='input-fullname']")).sendKeys("Ravi Tester");
driver.findElement(By.cssSelector("[data-test='input-email']")).sendKeys("ravi@example.com");
driver.findElement(By.cssSelector("[data-test='btn-submit']")).click();


WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result"), "Form submitted"));
assertThat(driver.findElement(By.id("result")).getText()).contains("Form submitted");
}
}