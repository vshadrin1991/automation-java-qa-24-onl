package lecture_10;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartProductPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;
import pageObjects.saucedemo.ProductPage;

public class ProductPageTest extends BaseTest {

    private LoginPage loginPage;
    private NavigationPage navigationPage;
    private ProductPage productPage;
    private CartProductPage cartProductPage;
    private Integer productIndex = 0;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        navigationPage = new NavigationPage();
        productPage = new ProductPage();
        cartProductPage = new CartProductPage();
        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }

    @Test(dataProvider = "index", priority = 1)
    public void addProductToCartTest(Integer index) {
        navigationPage.openMenu();
        navigationPage.clickMenuItem("All Items");
        productPage.clickAddToCard(index);
        productPage.headerElement.openCart();
        cartProductPage.clickRemoveByIndex(1);
    }

    @Test(priority = 2, invocationCount = 4)
    public void addProductToCartCounterTest() {
        navigationPage.openMenu();
        navigationPage.clickMenuItem("All Items");
        productPage.clickAddToCard(productIndex++);
        productPage.headerElement.openCart();
        cartProductPage.clickRemoveByIndex(1);
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
