package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final String SEARCH_LINK_XPATH = "//a[@data-qa-selector='search']";

    @FindBy(xpath = SEARCH_LINK_XPATH)
    private WebElement searchLink;

    public void openSearchPage() {
        waitForElementAndClick(searchLink);
    }
}
