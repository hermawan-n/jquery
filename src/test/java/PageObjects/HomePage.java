package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Driver.Driver;

public class HomePage {
    WebDriver driver = Driver.getDriver();

    public void goToPage(String page) {
        WebElement pageElement = driver.findElement(By.xpath("//a[text() = '" + page + "']"));

        pageElement.click();
    }
}
