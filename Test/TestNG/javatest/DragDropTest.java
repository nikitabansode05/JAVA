package com.transflower;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


import static org.assertj.core.api.Assertions.assertThat;


public class DragDropTest extends BaseTest {


@Test
public void perform_drag_and_drop() {
driver.get("http://localhost:5500/dragdrop.html");
Actions actions = new Actions(driver);
actions.dragAndDrop(driver.findElement(By.cssSelector("[data-test='drag-source']")),
driver.findElement(By.cssSelector("[data-test='drop-target']"))).perform();
assertThat(driver.findElement(By.cssSelector("[data-test='drop-target']")).getText()).isEqualTo("Dropped!");
}
}