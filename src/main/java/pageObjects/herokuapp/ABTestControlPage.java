package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.or;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class ABTestControlPage extends BasePage {

    private final By header = By.tagName("h3");


    public void verifyTitleText() {
        wait.until(or(textToBe(header, "A/B Test Control"), textToBe(header, "A/B Test Variation 1")));
    }
}
