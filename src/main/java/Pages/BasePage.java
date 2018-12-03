package Pages;

import Utils.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static Utils.DriverWrapper.driver;

public class BasePage extends PageFactory {

    public BasePage() {
        initElements(driver, this);
    }

    private Waiter waiter = new Waiter();

    void waitForElement(WebElement element) {
        waiter.waitForElementIsVisible(element, Waiter.MEDIUM_DELAY);
    }

    void waitForElementAndClick(WebElement element) {
        waiter.waitForElementIsVisible(element, Waiter.MEDIUM_DELAY);
        element.click();
    }

    void selectElementFromDropdownByText(List<WebElement> elements, String text) {
        for (WebElement element: elements) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }

    List<Integer> getIntFromElementsText(List<WebElement> elements) {
        return elements.stream().map(e -> Integer.parseInt(e.getText().replaceAll("\\D+","")))
                                .collect(Collectors.toList());
    }
}
