package pageObjects.saucedemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class NavigationPage extends BasePage {
    private final By menu = By.id("react-burger-menu-btn");

    private By getMenuItem(String text) {
        return By.linkText(text);
    }

    public void openMenu() {
        click(menu);
    }

    public void clickMenuItem(String itemName) {
        click(getMenuItem(itemName));
    }
}
