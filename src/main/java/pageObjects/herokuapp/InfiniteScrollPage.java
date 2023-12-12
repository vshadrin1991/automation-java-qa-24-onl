package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import java.time.Duration;

public class InfiniteScrollPage extends BasePage {

    private final By header = By.tagName("h3");
    private final By footer = By.id("page-footer");

    public void verifyTitleText() {
        wait.until(ExpectedConditions.textToBe(header, "Infinite Scroll"));
    }

    public void scroll(Integer count) {
        for (int i = 0; i < count; i++) {
            actions
                    .scrollToElement(driver.findElement(footer))
                    .pause(Duration.ofSeconds(1))
                    .build().perform();
        }
    }
}
