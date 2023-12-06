package lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static driver.SimpleWebDriver.getWebDriver;

public class CatalogPage {

    private WebElement schemaProducts = getWebDriver().findElement(By.xpath("//*[@id='schema-products']"));

    private WebElement groupSchemaProducts = schemaProducts.findElement(By.xpath(".//*[@class='schema-product__group']"));

    private WebElement getProduct(String productText) {
        return groupSchemaProducts.findElement(By.xpath(".//*[@class='schema-product__title']//span[text()='" + productText + "']"));
    }

    public void clickProduct(String productName) {
        getProduct(productName).click();
    }
}
