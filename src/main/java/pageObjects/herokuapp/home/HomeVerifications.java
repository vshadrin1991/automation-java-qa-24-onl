package pageObjects.herokuapp.home;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeVerifications {
    private final HomePage homePage;

    public HomeVerifications(HomePage homePage) {
        this.homePage = homePage;
    }

    public void verifyPageTitle() {
        homePage.wait.until(ExpectedConditions.textToBe(homePage.title, "Available Examples"));
    }
}
