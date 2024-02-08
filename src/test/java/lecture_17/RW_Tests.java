package lecture_17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.HomePage;
import pageObjects.rw.SearchPage;

import static com.codeborne.selenide.Selenide.page;

public class RW_Tests extends BaseTestSelenide {

    @Test
    public void searchTest() {
        get(HomePage.class)
                .enterFrom("Витебск")
                .enterTo("Минск")
                .clickSearch();

        Assert.assertTrue(get(SearchPage.class).getDates().contains("все дни"));

        page(SearchPage.class)
                .verifyDates("все дни")
                .clickDate("все дни");
    }

}
