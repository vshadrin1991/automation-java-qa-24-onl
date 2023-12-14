package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DynamicControlsPage extends BasePage {
    private final By checkbox = By.id("checkbox");

    public void verifyPage() {
        wait.until(visibilityOfElementLocated(checkbox));
    }

    public void verifyThatCheckNotExist() {
        wait.until(not(visibilityOfElementLocated(checkbox)));
    }
}
