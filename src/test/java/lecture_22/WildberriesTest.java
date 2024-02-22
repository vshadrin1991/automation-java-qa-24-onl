package lecture_22;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.wildberries.MainPage;
import pageObjects.wildberries.PopUpPage;
import pageObjects.wildberries.SearchResultPage;

public class WildberriesTest extends BaseTest {


    @Test(priority = 1)
    public void uploadImageTest() {
        get(MainPage.class)
                .open()
                .waitUntilPageLoaded()
                .uploadImage("download.png");
    }

    @Test(priority = 2)
    public void popupTest() {
        get(MainPage.class)
                .search("носки eco 401 высокие длинные из хлопка набор 10 пар");
        get(SearchResultPage.class)
                .waitUntilPageLoaded()
                .addToBasket("Носки", 1);
        get(PopUpPage.class)
                .clickClose();
    }
}
