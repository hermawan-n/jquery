package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class AutocompletePage {
    WebDriver driver = Driver.getDriver();

    public void typeText(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement txtBox = driver.findElement(By.xpath("//input[@id='tags']"));
        txtBox.sendKeys(text);

        driver.switchTo().defaultContent();
    }

    public void hoverAndValidate(String input) {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/div[text()='" + input + "']")));

        WebElement suggestion = driver.findElement(By.xpath("//li/div[text()='" + input + "']"));
        Actions actions = new Actions(driver);

        // int x = suggestion.getLocation().getX();
        // int y = suggestion.getLocation().getY();

        // System.out.println("x: " + x);
        // System.out.println("y: " + y);

        // actions.moveByOffset(x, y).perform();

        actions.moveToElement(suggestion).perform();

        actions.clickAndHold(suggestion).perform();

        // String bgColor = suggestion.getCssValue("background-color");

        // assertEquals("rgba(243, 152, 20, 1)", bgColor, "color do not match");
        actions.click().perform();

        driver.switchTo().defaultContent();
    }

    public void validateInput(String input) {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        WebElement txtBox = driver.findElement(By.xpath("//input[@id='tags']"));

        String expectedTxt = txtBox.getAttribute("value");

        assertEquals(expectedTxt, input, "Text do not match");

        driver.switchTo().defaultContent();
    }
}
