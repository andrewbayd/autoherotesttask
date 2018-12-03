import Pages.HomePage;
import Pages.SearchPage;
import Utils.Navigator;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Utils.Constants.YEAR;

public class SearchTest {
    private Navigator navigator = new Navigator();
    private HomePage homePage = new HomePage();
    private SearchPage searchPage = new SearchPage();

    @BeforeClass
    public void setUp() {
        navigator.openApp();
    }

    @Test
    public void searchTest() throws InterruptedException {
        homePage.openSearchPage();
        searchPage.filterForFirstRegistrationFrom(YEAR);
        searchPage.sortResultsByPriceDescending();
        Assertions.assertThat(searchPage.getAllPrices()).isEqualTo(searchPage.getAllPricesSorted());
        Assert.assertTrue(searchPage.isAllCarsOnPageRegisteredFrom(YEAR));
    }

    @AfterClass
    public void closeUp() {
        navigator.closeBrowser();
    }
}
