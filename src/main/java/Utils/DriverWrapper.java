package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverWrapper {
    private static final String CHROME_DRIVER_PATH = "comautoherotesttask/src/main/resources/chromedriver";

    private static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    public static WebDriver driver = getDriver();

}
