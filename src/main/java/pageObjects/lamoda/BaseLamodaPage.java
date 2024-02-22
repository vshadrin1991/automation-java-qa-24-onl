package pageObjects.lamoda;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class BaseLamodaPage<P> extends BasePage {
    private final String preloader = "//*[@class='preloader__circle']";

    public P waitUntilPageLoaded() {
        waitUntil(1);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(preloader))));
        return page();
    }

    public P page() {
        return (P) this;
    }
}
