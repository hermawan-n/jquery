package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Driver.Driver;

public class CheckboxradioPage {
    WebDriver driver = Driver.getDriver();

    public void selectChecboxRadio(String cbName, String cbOption) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);
        js.executeScript("window.scrollTo(0, 100);");

        WebElement cbElement = driver.findElement(
                By.xpath("//legend[contains(text(),'" + cbOption + "')]/../label[normalize-space(text())='" + cbName
                        + "']"));
        cbElement.click();
        driver.switchTo().defaultContent();
    }

    public void validateCheckboxradio(String cbName, String cbOption, String color) {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement cbElement = driver.findElement(
                By.xpath("//legend[contains(text(),'" + cbOption + "')]/../label[normalize-space(text())='" + cbName
                        + "']"));
        String bgColor = cbElement.getCssValue("background-color");
        String expectedColor = "";

        if (color.equalsIgnoreCase("blue")) {
            expectedColor = "rgba(0, 127, 255, 1)";
        } else if (color.equalsIgnoreCase("grey")) {
            expectedColor = "rgba(246, 246, 246, 1)";
        }

        assertEquals(expectedColor, bgColor, "color do not match");

        driver.switchTo().defaultContent();
    }
}
