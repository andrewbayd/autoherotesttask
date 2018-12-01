package Pages;

import org.openqa.selenium.support.PageFactory;

import static Utils.DriverWrapper.driver;

public class BasePage extends PageFactory {
    public BasePage() {
        initElements(driver, this);
    }

    
}
