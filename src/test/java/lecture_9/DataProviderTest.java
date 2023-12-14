package lecture_9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;

public class DataProviderTest extends BaseTest {

    private LoginPage loginPage;
    private NavigationPage navigationPage;
    private String password;

    @Parameters({"url", "userPassword"})
    @BeforeTest
    public void precondition(@Optional("") String url, @Optional("secret_sauce") String password) {
        loginPage = new LoginPage();
        navigationPage = new NavigationPage();
        this.password = password;
        loginPage.open(url);
    }

    @Test(priority = 1, dataProvider = "get user name")
    public void loginTest(String userName, Boolean loginStatus) {
        loginPage.verifyPage();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        if (loginStatus) {
            navigationPage.openMenu();
            navigationPage.clickMenuItem("Logout");
        }
    }

    @DataProvider(name = "get user name")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", true},
                {"locked_out_user", false},
                {"problem_user", true},
                {"performance_glitch_user", true},
                {"error_user", true},
                {"visual_user", true}
        };
    }
}