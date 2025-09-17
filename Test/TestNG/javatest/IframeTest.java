package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;


public class IframeTest extends BaseTest {


@Test
public void interact_with_iframe() {
driver.get("http://localhost:5500/iframe.html");
driver.switchTo().frame(driver.findElement(By.id("frame")));
driver.findElement(By.id("btnInside")).click();
assertThat(driver.findElement(By.id("inside")).getText()).isEqualTo("Clicked");
driver.switchTo().defaultContent();
}
}