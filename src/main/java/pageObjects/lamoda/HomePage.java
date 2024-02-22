package pageObjects.lamoda;

import propertyUtils.PropertyReader;

public class HomePage extends BaseLamodaPage<HomePage> {

    public HomePage open() {
        navigateTo(PropertyReader.getProperties().getProperty("url"));
        return page();
    }
}
