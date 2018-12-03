package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utils.DriverWrapper.driver;

class Waiter {
    static final int SHORT_DELAY = 5;
    static final int MEDIUM_DELAY = 15;
    static final int LONG_DELAY = 30;

    void waitForElementIsVisible(WebElement element, int delay) {
        WebDriverWait wait = new WebDriverWait(driver, delay);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
