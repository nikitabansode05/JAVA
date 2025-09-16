package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.assertj.core.api.Assertions.assertThat;


import java.io.File;


public class UploadTest extends BaseTest {


@Test
public void file_upload() {
driver.get("http://localhost:5500/upload.html");
WebElement input = driver.findElement(By.cssSelector("[data-test='input-file']"));
File file = new File(System.getProperty("user.dir") + "/src/test/resources/sample.txt");
input.sendKeys(file.getAbsolutePath());
driver.findElement(By.cssSelector("[data-test='btn-upload']")).click();
assertThat(driver.findElement(By.id("status")).getText()).contains("Selected: sample.txt");
}
}