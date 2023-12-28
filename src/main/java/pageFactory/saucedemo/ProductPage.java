package pageFactory.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import java.util.List;

import static driver.DriverCreation.getDriver;

public class ProductPage extends BasePage implements Page<ProductPage> {
    @FindBys({@FindBy(className = "inventory_item")})
    List<WebElement> productList;

    @FindBy(id = "inventory_container")
    WebElement inventoryContainer;

    private final By addToCard = By.tagName("button");

    public ProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void clickAddToCard(Integer index) {
        click(productList.get(index).findElement(addToCard));
    }

    @Override
    public ProductPage waitUntilPageLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inventoryContainer));
        return this;
    }
}
