package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import static org.assertj.core.api.Assertions.assertThat;


public class RichTextTest extends BaseTest {


@Test
public void edit_and_save_rich_text() {
driver.get("http://localhost:5500/richtext.html");
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("document.getElementById('editor').innerHTML = '<b>Test content</b>'");
driver.findElement(By.cssSelector("[data-test='btn-save']")).click();
assertThat(driver.findElement(By.id("output")).getText()).contains("Test content");
}
}