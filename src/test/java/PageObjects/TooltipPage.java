package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class TooltipPage {
    WebDriver driver = Driver.getDriver();

    public void hover() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement txt = driver.findElement(By.id("age"));
        Actions actions = new Actions(driver);

        actions.moveToElement(txt).perform();
    }

    public void validate(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='tooltip']")));
        WebElement tooltip = driver.findElement(By.xpath("//div[@role='tooltip']"));

        String sTooltip = tooltip.getText();
        assertEquals(text, sTooltip, "Text do not match");
    }
}
