package lecture_13;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class LoginPageFactoryTest extends BaseTest {
    @BeforeMethod
    public void setUpTest() {
        get(LoginPage.class).open();
    }

    @Test(priority = 1, dataProvider = "get user name")
    public void loginTest(String userName) {
        get(LoginPage.class)
                .waitUntilPageLoaded()
                .enterUsername(userName)
                .enterPassword(get(LoginPage.class).getPassword())
                .clickLogin();
    }

    @DataProvider(name = "get user name")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user"},
                {"locked_out_user"},
                {"problem_user"},
                {"performance_glitch_user"},
                {"error_user"},
                {"visual_user"}
        };
    }
}
