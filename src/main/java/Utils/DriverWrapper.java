package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class DriverWrapper {
    private static final String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver";

    private static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    static WebDriver driver = getDriver();

}
