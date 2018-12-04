package Utils;

import static Utils.Constants.HOMEPAGE_URL;
import static Utils.DriverWrapper.driver;

public class Navigator {


    public void openApp() {
        driver.get(HOMEPAGE_URL);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
