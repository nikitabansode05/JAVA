package com.transflower;


//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;


public class DownloadTest extends BaseTest {

@Test
public void verify_download_link_exists() {
driver.get("http://127.0.0.1:5500/WebUI/download.html");
String href = driver.findElement(By.cssSelector("[data-test='link-download']")).getAttribute("href");
assertThat(href).startsWith("data:text/plain");
}
}