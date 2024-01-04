package pageObjects.herokuapp;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

@Log4j
public class Frames extends BasePage {

    private final By header = By.tagName("h3");
    private final By frame = By.id("mce_0_ifr");

    private final By textField = By.tagName("p");

    private By getItem(String name) {
        return By.linkText(name);
    }

    public void verifyTitleText() {
        wait.until(textToBe(header, "Frames"));
    }

    public void clickOnItem(String itemName) {
        click(getItem(itemName));
    }

    public void switchToFrame() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(frame)));
        driver.switchTo().frame(driver.findElement(frame));
    }

    public void enterText(String text) {
        log.info(driver.findElement(textField).getText());
        sendKeys(textField, text);
    }

    public void unSwitchToFrame() {
        driver.switchTo().defaultContent();
    }


}
