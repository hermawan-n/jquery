package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class ResizablePage {
    WebDriver driver = Driver.getDriver();

    public void dragAndDropBy(Integer width, Integer height) {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement target = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='resizable']/div[3]")));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(target, (width - 150), (height - 150)).build().perform();
        // actions.moveToElement(target).clickAndHold().moveByOffset((width- 150),
        // (height-150)).release().perform();
    }

    public void validateDragAndDropBy(Integer aWidth, Integer aHeight) {
        WebElement target = driver.findElement(By.id("resizable"));

        String height = target.getCssValue("height");
        String width = target.getCssValue("width");

        assertEquals(aWidth + "px", width, "Incorrect width: " + aWidth);
        assertEquals(aHeight + "px", height, "Incorrect height: " + aHeight);

    }
}
