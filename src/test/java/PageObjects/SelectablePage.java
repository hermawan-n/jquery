package PageObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Driver.Driver;

public class SelectablePage {
    WebDriver driver = Driver.getDriver();

    public void selecableBySwiping(String aRowStart, String aColStart, String aRowEnd, String aColEnd) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//li[@class='ui-state-default ui-selectee']")));

        WebElement list = driver.findElement(By.id("selectable"));
        List<WebElement> listItems = list.findElements(By.tagName("li"));

        int rows = Integer.parseInt(aRowEnd) - Integer.parseInt(aRowStart) + 1; // 1-based index of row
        int cols = Integer.parseInt(aColEnd) - Integer.parseInt(aColStart) + 1; // 1-based index of column
        int startIndex = (Integer.parseInt(aRowStart) - 1) * 4 + Integer.parseInt(aColStart) - 1;
        int endIndex = startIndex + rows * cols;

        Actions actions = new Actions(driver);
        actions.clickAndHold(listItems.get(startIndex));

        for (int i = startIndex + 1; i < endIndex; i++) {
            WebElement selectee = listItems.get(i);
            actions.moveToElement(selectee);
        }

        actions.release().perform();

        for (int i = startIndex; i < endIndex; i++) {
            WebElement selectee = listItems.get(i);
            String bgColor = selectee.getCssValue("background-color");
            assertEquals("rgba(243, 152, 20, 1)", bgColor);
            System.out.println(i);
        }

        driver.switchTo().defaultContent();
    }

    public void selecableMouse(String aRowStart, String aColStart, String aRowEnd, String aColEnd) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//li[@class='ui-state-default ui-selectee']")));

        int rowS = Integer.parseInt(aRowStart); // 1-based index of row
        int colS = Integer.parseInt(aColStart); // 1-based index of column
        int rowE = Integer.parseInt(aRowEnd); // 1-based index of row
        int colE = Integer.parseInt(aColEnd); // 1-based index of column
        int indexStart = (rowS - 1) * 4 + (colS - 1);
        int indexEnd = (rowE - 1) * 4 + (colE - 1);

        WebElement list = driver.findElement(By.id("selectable"));
        List<WebElement> listItems = list.findElements(By.tagName("li"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(listItems.get(indexStart));

        actions.moveToElement(listItems.get(indexEnd));

        actions.release().perform();

        driver.switchTo().defaultContent();
    }

    public void selectedHadOrangeBG() {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);
        List<WebElement> selectedElements = driver.findElements(By.cssSelector(".ui-selected"));

        for (WebElement element : selectedElements) {
            String backgroundColor = element.getCssValue("background-color");
            assertEquals("rgba(243, 152, 20, 1)", backgroundColor);
        }
    }

    public void selectableByRowAndColumn(String aRow, String aCol) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//li[@class='ui-state-default ui-selectee']")));

        WebElement list = driver.findElement(By.id("selectable"));
        List<WebElement> listItems = list.findElements(By.tagName("li"));

        int row = Integer.parseInt(aRow); // 1-based index of row
        int col = Integer.parseInt(aCol); // 1-based index of column
        int index = (row - 1) * 4 + (col - 1);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(listItems.get(index)).build().perform();

        String bgColor = listItems.get(index).getCssValue("background-color");
        assertEquals("rgba(243, 152, 20, 1)", bgColor);

        driver.switchTo().defaultContent();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300);");
    }
}
