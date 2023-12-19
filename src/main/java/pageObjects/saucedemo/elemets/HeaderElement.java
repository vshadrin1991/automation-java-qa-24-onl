package pageObjects.saucedemo.elemets;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class HeaderElement extends BasePage {
    private final By menu = By.id("react-burger-menu-btn");
    private final By cart = By.id("shopping_cart_container");


    public void openMenu() {
        click(menu);
    }

    public void openCart() {
        click(cart);
    }
}
