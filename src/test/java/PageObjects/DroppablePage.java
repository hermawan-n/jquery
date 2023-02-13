package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class DroppablePage {
    WebDriver driver = Driver.getDriver();

    public void dragAndDrop() {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement target = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("draggable")));
        WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("draggable")));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public void validateDragAndDrop(String text) {
        WebElement target = driver.findElement(By.id("droppable"));
        String actualColor = target.getCssValue("background-color");
        String actualText = target.getText();

        String expectedColor = "rgb(255, 250, 144)"; // equivalent to #fffa90

        assertTrue(actualColor.equals(expectedColor), "Incorrect color: " + actualColor);
        assertEquals(actualText, text, "Incorrect text: " + actualText);
    }
}
