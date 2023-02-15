package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Driver.Driver;

public class DatepickerPage {
    WebDriver driver = Driver.getDriver();

    public void chooseDate(String dateChosen) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);
        js.executeScript("window.scrollTo(0, 100);");

        WebElement dateElement = driver.findElement(By.id("datepicker"));
        dateElement.sendKeys(dateChosen);
    }

    public void validateDate(String dateChosen) {
        String[] arrDate = dateChosen.split("/");
        if (arrDate[0].charAt(0) == '0') {
            arrDate[0] = arrDate[0].substring(1);
        } else if (arrDate[1].charAt(0) == '0') {
            arrDate[1] = arrDate[1].substring(1);
        }

        WebElement dateElement = driver
                .findElement(By.xpath(
                        "//td[@data-month='" + (Integer.parseInt(arrDate[0]) - 1) + "' and @data-year='" + arrDate[2]
                                + "']/a[@data-date='" + arrDate[1] + "']"));

        String bgColor = dateElement.getCssValue("background-color");

        assertEquals("rgba(0, 127, 255, 1)", bgColor, "color do not match");

        driver.switchTo().defaultContent();
    }
}
