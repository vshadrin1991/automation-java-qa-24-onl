package pageObjects.saucedemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.elemets.HeaderElement;

public class CartProductPage extends BasePage {

    private final By remove = By.cssSelector("[data-test^='remove']");

    public HeaderElement headerElement = new HeaderElement();

    public void clickRemoveByIndex(Integer index) {
        click(driver.findElements(remove).get(index - 1));
    }
}
