package lecture_13;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class ProductPageFactoryTest extends BaseTest {
    @BeforeTest
    public void precondition() {
        get(LoginPage.class)
                .open()
                .enterUsername()
                .enterPassword()
                .clickLogin();
    }

    @Test(dataProvider = "index", priority = 1)
    public void addProductToCartTest(Integer index) {
        get(ProductPage.class)
                .waitUntilPageLoaded()
                .clickAddToCard(index);
    }

    @DataProvider(name = "index")
    public Object[][] getData() {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4}
        };
    }
}
