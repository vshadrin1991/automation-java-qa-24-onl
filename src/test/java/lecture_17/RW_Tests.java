package lecture_17;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.HomePage;
import pageObjects.rw.SearchPage;

public class RW_Tests extends BaseTestSelenide {

    @Test
    public void searchTest() {
        get(HomePage.class)
                .enterFrom("Витебск")
                .enterTo("Минск")
                .clickSearch();

        get(SearchPage.class)
                .verifyDates("все дни")
                .clickDate("все дни");
    }

}
