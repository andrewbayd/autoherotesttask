package Utils;

import static Utils.Constants.HOMEPAGE_URL;
import static Utils.DriverWrapper.driver;

public class Navigator {


    public void openApp() {
        driver.get(HOMEPAGE_URL);
        System.out.println("Home page was opened");
    }

    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser was closed");
    }
}
