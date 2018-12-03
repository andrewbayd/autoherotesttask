package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage {
    private static final String FILTER_YEAR_XPATH = "//div[@data-qa-selector='filter-year']";
    private static final String YEAR_RANGE_DROPDOWN_XPATH = "//select[@name='yearRange.min']";
    private static final String YEAR_RANGE_OPTIONS_XPATH = "//select[@name='yearRange.min']/option";
    private static final String SORT_DROPDOWN_XPATH = "//select[@name='sort']";
    private static final String SORT_BY_PRICE_DESC_XPATH = "//option[@data-qa-selector-value='offerPrice.amountMinorUnits.desc']";
    private static final String CARS_REGISTRATION_DATES_XPATH = "//li[@class='specItem___2gMHn'][1]";
    private static final String ALL_PRICES_ON_PAGE_XPATH = "//div[@data-qa-selector='price']";

    @FindBy(xpath = FILTER_YEAR_XPATH)
    private WebElement filterYear;

    @FindBy(xpath = YEAR_RANGE_DROPDOWN_XPATH)
    private WebElement yearRangeDropdown;

    @FindBy(xpath = YEAR_RANGE_OPTIONS_XPATH)
    private List<WebElement> yearRangeOptions;

    @FindBy(xpath = SORT_DROPDOWN_XPATH)
    private WebElement sortDropdown;

    @FindBy(xpath = SORT_BY_PRICE_DESC_XPATH)
    private WebElement sortByPriceDescOption;

    @FindBy(xpath = CARS_REGISTRATION_DATES_XPATH)
    private List<WebElement> carsRegistrationDates;

    @FindBy(xpath = ALL_PRICES_ON_PAGE_XPATH)
    private List<WebElement> allPricesOnPage;

    public void filterForFirstRegistrationFrom(String year) {
        waitForElementAndClick(filterYear);
        waitForElementAndClick(yearRangeDropdown);
        selectElementFromDropdownByText(yearRangeOptions, year);
        System.out.println("Results were filtered for first registration from " + year);
    }

    public void sortResultsByPriceDescending() {
        waitForElementAndClick(sortDropdown);
        waitForElementAndClick(sortByPriceDescOption);
        System.out.println("Results were sorted by price descending");
    }

    public List<Integer> getAllPrices() throws InterruptedException {
        Thread.sleep(1000);
        return getIntFromElementsText(allPricesOnPage);
    }

    public List<Integer> getAllPricesSorted() {
        return allPricesOnPage.stream()
                .map(e -> Integer.parseInt(e.getText().replaceAll("\\D+","")))
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public boolean isAllCarsOnPageRegisteredFrom(String year) {
        int yearInt = Integer.parseInt(year);
        boolean result = true;
        List<Integer> years = getIntFromElementsText(carsRegistrationDates);

        for (int element: years) {
            if (element < yearInt) {
                result = false;
                break;
            }
        }

        return result;

    }

}
