package PageObjects;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class ProgressbarPage {
    WebDriver driver = Driver.getDriver();

    public void chooseButton(String button) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='" + button + "']")));
        WebElement btnElement = driver.findElement(By.xpath("//button[text()='" + button + "']"));
        btnElement.click();
    }

    public void validateProgress(String percentage, String btn) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        final String percentage1 = percentage;

        // wait.until(ExpectedConditions.visibilityOfElementLocated(
        // By.xpath("//div[@class='progress-label' and text()='Current Progress: " +
        // percentage + "']")));

        FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofNanos(100))
                .ignoring(NoSuchElementException.class);

        wait2.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(
                        By.xpath("//div[@class='progress-label' and text()='Current Progress: " + percentage1 + "']"));
            }
        });

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[text()='" + btn + "']")));

        WebElement percenElement = driver
                .findElement(By.xpath("//button[text()='" + btn + "']"));
        boolean t = percenElement.isDisplayed();
        System.out.println(t);

    }
}
