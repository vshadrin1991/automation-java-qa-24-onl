package pageObjects.herokuapp.home;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;
import pageObjects.herokuapp.HomePageItems;
import propertyUtils.PropertyReader;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage {

    private final HomeSteps steps;

    private final HomeVerifications verifications;

    protected By getItemLocator(String item) {
        return By.linkText(item);
    }

    protected By title = By.tagName("h2");

    public HomePage() {
        steps = new HomeSteps(this);
        verifications = new HomeVerifications(this);
    }

    public HomeSteps getSteps() {
        return steps;
    }

    public HomeVerifications getVerifications() {
        return verifications;
    }

    public void open() {
        open(PropertyReader.getProperties().getProperty("url"));
    }

    public void open(String url) {
        navigateTo(url);
    }

    public void clickOnItem(HomePageItems item) {
        wait.until(elementToBeClickable(getItemLocator(item.getItem())));
        click(getItemLocator(item.getItem()));
    }
}
