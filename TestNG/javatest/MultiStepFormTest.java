package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


import static org.assertj.core.api.Assertions.assertThat;


public class MultiStepFormTest extends BaseTest {


@Test
public void wizard_navigation_and_submit() {
driver.get("http://localhost:5500/multi-step-form.html");
driver.findElement(By.cssSelector("[data-test='wizard-name']")).sendKeys("Ravi");
driver.findElement(By.cssSelector("[data-test='wizard-next']")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='wizard-age']")));
driver.findElement(By.cssSelector("[data-test='wizard-age']")).sendKeys("30");
driver.findElement(By.cssSelector("[data-test='wizard-submit']")).click();
assertThat(driver.findElement(By.id("wizardMsg")).getText()).contains("Wizard finished");
}
}