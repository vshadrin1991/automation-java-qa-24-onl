package lecture_23;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.lamoda.HomePage;

public class LamodaTest extends BaseTest {

    @Test
    public void openTest() {
        get(HomePage.class)
                .open()
                .waitUntilPageLoaded();
        System.out.println("");
    }
}
