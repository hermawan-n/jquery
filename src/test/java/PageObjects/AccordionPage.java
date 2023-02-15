package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class AccordionPage {
    WebDriver driver = Driver.getDriver();

    public void selectAccordion(String section) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement sectionElement = driver.findElement(By.xpath("//div[@id='accordion']/h3[" + section + "]"));

        sectionElement.click();

        driver.switchTo().defaultContent();
    }

    public void validateText(String section, String text) {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement sectionElement = driver.findElement(By.xpath("//div[@id='accordion']/div[" + section + "]/p"));

        wait.until(ExpectedConditions.visibilityOf(sectionElement));

        String actualText = sectionElement.getText();

        assertEquals(actualText, text, "Text do not match");
    }
}
