package Utils;

import static Utils.DriverWrapper.driver;

public class Navigator {
    private static final String HOMEPAGE_URL = "https://www.autohero.com/de/";

    public void openHomePage() {
        driver.get(HOMEPAGE_URL);
        System.out.println("Home page was opened");
    }
}
