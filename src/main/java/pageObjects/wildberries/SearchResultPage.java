package pageObjects.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BaseWBPage<SearchResultPage> {
    private String getProductCard(String productName, String index) {
        return "(//*[@class='product-card__wrapper']//span[contains(., '" + productName + "')]//ancestor::article)[" + index + "]";
    }

    private String getAddToBasked(String productName, String index) {
        return getProductCard(productName, index).concat("//*[@class='btn-text']");
    }

    public SearchResultPage addToBasket(String productName, Integer productIndex) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getAddToBasked(productName, productIndex.toString()))));
        click(getAddToBasked(productName, productIndex.toString()));
        return me();
    }
}
