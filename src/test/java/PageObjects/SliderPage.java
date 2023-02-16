package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class SliderPage {
    WebDriver driver = Driver.getDriver();

    public void slide(String slider, String range) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='slider-range']/span[" + slider + "]")));
        WebElement sliderElement = driver.findElement(By.xpath("//div[@id='slider-range']/span[" + slider + "]"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(sliderElement).perform();

        int sliderInt = Integer.parseInt(slider) - 1;
        double rangeInt = Double.parseDouble(range) * 0.2;

        js.executeScript(
                "document.getElementById('slider-range').getElementsByTagName('div')[0].setAttribute('style', 'width: 0%;')");

        js.executeScript(
                "document.getElementById('slider-range').getElementsByTagName('span')[" + sliderInt
                        + "].setAttribute('style', 'left: " + rangeInt + "%;')");

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@id='slider-range']/span[" + slider + "]")));

        actions.moveToElement(sliderElement, 0, 0).perform();

        actions.release().perform();

        driver.switchTo().defaultContent();
    }
}
