package Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String projectPath = System.getProperty("user.dir");

            System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resource/driver/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);

            driver = new ChromeDriver();

            driver.manage().window().maximize();
        }
        return driver;
    }
}
