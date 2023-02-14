package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Driver.Driver;

public class SwitchFrame {
    WebDriver driver = Driver.getDriver();

    public void switchTo() {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);
    }
}
