package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Driver.Driver;

public class SortablePage {
    WebDriver driver = Driver.getDriver();

    public void clickAndHoldItems(String item, String target) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement itemElement = driver.findElement(By.xpath("//li[text()='Item " + item + "']"));
        WebElement targetElement = driver.findElement(By.xpath("//ul[@id='sortable']/li[" + target + "]"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(itemElement);

        if (Integer.parseInt(item) > Integer.parseInt(target)) {
            actions.moveToElement(targetElement, 10, -10);

        } else {
            actions.moveToElement(targetElement, 10, 10);
        }

        actions.release().perform();

        driver.switchTo().defaultContent();
    }

    public void validateOrder(String item, String target) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement itemElement = driver.findElement(By.xpath("//li[text()='Item " + item + "']"));
        WebElement targetElement = driver.findElement(By.xpath("//ul[@id='sortable']/li[" + target + "]"));

        String actualText = targetElement.getText();
        String expectedText = itemElement.getText();

        assertEquals(actualText, expectedText, "Text do not match");

        driver.switchTo().defaultContent();
    }
}
