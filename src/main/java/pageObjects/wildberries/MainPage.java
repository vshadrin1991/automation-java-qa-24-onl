package pageObjects.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageObjects.baseObjects.BasePage;
import propertyUtils.PropertyReader;

public class MainPage extends BasePage {
    private final By searchInput = By.id("searchInput");

    public MainPage open(){
        navigateTo(PropertyReader.getProperties().getProperty("url"));
        return this;
    }

    public MainPage search(String searchData) {
        sendKeys(searchInput, searchData, Keys.ENTER);
        return this;
    }
}
