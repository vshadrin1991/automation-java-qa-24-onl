package lecture_7;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        loginPage.open("https://www.saucedemo.com");
    }

    @Test(priority = 1)
    public void successfulLoginTest() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLogin();
    }

    @Test(priority = 2)
    public void addProductToCartTest() {
        productPage.verifyPage();
        productPage.clickAddToCard(1);
    }
}
