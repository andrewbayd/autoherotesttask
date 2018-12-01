package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage {
    private static final String FILTER_YEAR_XPATH = "//div[@data-qa-selector='filter-year']";
    private static final String YEAR_RANGE_DROPDOWN_XPATH = "//select[@name='yearRange.min']";
    private static final String YEAR_RANGE_OPTIONS_XPATH = "//select[@name='yearRange.min']/option";

    @FindBy(xpath = FILTER_YEAR_XPATH)
    private WebElement filterYear;

    @FindBy(xpath = YEAR_RANGE_DROPDOWN_XPATH)
    private WebElement yearRangeDropdown;

    @FindBy(xpath = YEAR_RANGE_OPTIONS_XPATH)
    private List<WebElement> yearRangeOptions;
    
}
