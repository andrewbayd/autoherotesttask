import Pages.HomePage;
import Pages.SearchPage;
import Utils.Navigator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Utils.Constants.YEAR;
import static org.testng.Assert.assertTrue;

public class SearchTest {
    private Navigator navigator = new Navigator();
    private HomePage homePage = new HomePage();
    private SearchPage searchPage = new SearchPage();

    @BeforeClass
    public void setUp() {
        navigator.openApp();
    }

    @Test
    public void searchTest() {
        homePage.openSearchPage();
        searchPage.filterForFirstRegistrationFrom(YEAR);
        searchPage.sortResultsByPriceDescending();
        assertTrue(searchPage.isPricesSortedByDesc());
        assertTrue(searchPage.isAllCarsOnPageRegisteredFrom(YEAR));
    }

    @AfterClass
    public void closeUp() {
        navigator.closeBrowser();
    }
}
