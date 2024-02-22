package pageObjects.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class BaseWBPage<P> extends BasePage {
    private final String preloader = "//*[@class='general-preloader']";

    public P waitUntilPageLoaded() {
        waitUntil(1);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(preloader))));
        return me();
    }

    public P me() {
        return (P) this;
    }
}
