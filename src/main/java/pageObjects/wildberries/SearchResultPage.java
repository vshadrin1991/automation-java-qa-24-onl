package pageObjects.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class SearchResultPage extends BasePage {
    private final String preloader = "//*[@class='general-preloader']";

    private String getProductCard(String productName, String index) {
        return "(//*[@class='product-card__wrapper']//span[contains(., '" + productName + "')]//ancestor::article)[" + index + "]";
    }

    private String getAddToBasked(String productName, String index) {
        return getProductCard(productName, index).concat("//*[@class='btn-text']");
    }

    public SearchResultPage waitUntilPageLoaded() {
        waitUntil(1);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(preloader))));
        return this;
    }

    public SearchResultPage addToBasket(String productName, Integer productIndex) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getAddToBasked(productName, productIndex.toString()))));
        click(getAddToBasked(productName, productIndex.toString()));
        return this;
    }
}
