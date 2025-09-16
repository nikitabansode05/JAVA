package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


import static org.assertj.core.api.Assertions.assertThat;


public class DynamicContentTest extends BaseTest {


@Test
public void load_dynamic_content() {
driver.get("http://localhost:5500/dynamic.html");
driver.findElement(By.cssSelector("[data-test='btn-load']")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#content li")));
assertThat(driver.findElements(By.cssSelector("#content li"))).hasSize(3);
}
}