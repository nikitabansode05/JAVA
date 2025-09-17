package com.transflower;


import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;


public class CanvasTest extends BaseTest {

@Test
public void canvas_element_exists() {
driver.get("http://127.0.0.1:5500/WebUI/canvas.html");
assertThat(driver.findElement(By.id("c")).isDisplayed()).isTrue();
assertThat(driver.findElement(By.id("c")).getAttribute("width")).isEqualTo("400");
assertThat(driver.findElement(By.id("c")).getAttribute("height")).isEqualTo("120");
}
}