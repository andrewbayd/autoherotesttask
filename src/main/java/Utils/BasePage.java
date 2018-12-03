package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static Utils.DriverWrapper.driver;

public class BasePage extends PageFactory {

    public BasePage() {
        initElements(driver, this);
    }

    private Waiter waiter = new Waiter();

    protected void waitForElementAndClick(WebElement element) {
        waiter.waitForElementIsVisible(element, Waiter.MEDIUM_DELAY);
        element.click();
    }

    protected void selectElementFromDropdownByText(List<WebElement> elements, String text) {
        for (WebElement element: elements) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }

    protected List<Integer> getIntFromElementsText(List<WebElement> elements) {
        return elements.stream().map(e -> Integer.parseInt(e.getText().replaceAll("\\D+","")))
                                .collect(Collectors.toList());
    }

    protected List<Integer> getIntSortedDescFromElementsText(List<WebElement> elements) {
        return elements.stream().map(e -> Integer.parseInt(e.getText().replaceAll("\\D+","")))
                                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    protected void waitForResultsLoaded() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
