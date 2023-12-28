package lecture_13;

import entities.saucedemo.User;
import entities.saucedemo.UserBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class ValueObjectTest extends BaseTest {

    @BeforeMethod
    public void setUpTest() {
        get(LoginPage.class).open();
    }

    @Test(priority = 1)
    public void loginTest() {
        get(LoginPage.class)
                .waitUntilPageLoaded()
                .login(new User() {{
                    setUsername("standard_user");
                    setPassword("secret_sauce");
                }})
                .clickLogin();
    }

    @Test(priority = 2, dataProvider = "get user")
    public void loginTest(User user) {
        get(LoginPage.class)
                .waitUntilPageLoaded()
                .login(user)
                .clickLogin();
    }

    @Test(priority = 3, dataProvider = "get user builder")
    public void loginTest(UserBuilder user) {
        get(LoginPage.class)
                .waitUntilPageLoaded()
                .login(user)
                .clickLogin();
    }

    @DataProvider(name = "get user")
    public Object[][] getData() {
        return new Object[][]{
                {new User() {{
                    setUsername("standard_user");
                }}},
                {new User() {{
                    setUsername("locked_out_user");
                }}},
                {new User() {{
                    setUsername("problem_user");
                }}},
                {new User() {{
                    setUsername("performance_glitch_user");
                }}},
                {new User() {{
                    setUsername("error_user");
                }}},
                {new User() {{
                    setUsername("visual_user");
                }}},
        };
    }

    @DataProvider(name = "get user builder")
    public Object[][] getUserData() {
        return new Object[][]{
                {new UserBuilder.Builder()
                        .withUsername("standard_user")
                        .withPassword("secret_sauce")
                        .build()},
                {new UserBuilder.Builder()
                        .withUsername("locked_out_user")
                        .withPassword("secret_sauce")
                        .build()},
                {new UserBuilder.Builder()
                        .withUsername("problem_user")
                        .withPassword("secret_sauce")
                        .build()}
        };
    }
}