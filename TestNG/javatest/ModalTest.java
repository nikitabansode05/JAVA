package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


import static org.assertj.core.api.Assertions.assertThat;


public class ModalTest extends BaseTest {


@Test
public void open_modal_and_confirm() {
driver.get("http://localhost:5500/modal.html");
driver.findElement(By.cssSelector("[data-test='btn-open-modal']")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
driver.findElement(By.cssSelector("[data-test='btn-confirm']")).click();
Alert alert = wait.until(ExpectedConditions.alertIsPresent());
assertThat(alert.getText()).isEqualTo("Confirmed!");
alert.accept();
}


@Test
public void open_modal_and_cancel() {
driver.get("http://localhost:5500/modal.html");
driver.findElement(By.cssSelector("[data-test='btn-open-modal']")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modal")));
driver.findElement(By.cssSelector("[data-test='btn-cancel']")).click();
assertThat(driver.findElement(By.id("modal")).isDisplayed()).isFalse();
}
}