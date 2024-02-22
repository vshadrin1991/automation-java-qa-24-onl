package pageObjects.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import propertyUtils.PropertyReader;

public class MainPage extends BaseWBPage<MainPage> {
    private final By searchInput = By.id("searchInput");
    private final By searchImage = By.xpath("//*[@id='searchByImageForm']//*[@name='photo']");

    public MainPage open() {
        navigateTo(PropertyReader.getProperties().getProperty("url"));
        return me();
    }

    public MainPage search(String searchData) {
        enter(searchInput, searchData, Keys.ENTER);
        return me();
    }

    public MainPage uploadImage(String imageName) {
        sendKeys(searchImage, FILE_PATH.concat(imageName));
        return me();
    }
}
