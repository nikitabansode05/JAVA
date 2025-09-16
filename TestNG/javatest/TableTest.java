package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;


public class TableTest extends BaseTest {


@Test
public void table_rows_and_edit_buttons() {
driver.get("http://localhost:5500/table.html");
List<WebElement> rows = driver.findElements(By.cssSelector("#userTable tbody tr"));
assertThat(rows).hasSize(3);


WebElement firstRow = rows.get(0);
firstRow.findElement(By.cssSelector("[data-test='btn-edit']")).click();
assertThat(driver.findElement(By.id("editStatus")).getText()).contains("Editing user 1");
}
}