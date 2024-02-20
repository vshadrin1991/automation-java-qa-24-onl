package pageObjects.lamoda;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class SearchResultPage extends BasePage {
    private final String preloader = "//*[@class='preloader__circle']";

    public SearchResultPage waitUntilPageLoaded() {
        waitUntil(1);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(preloader))));
        return this;
    }
}
