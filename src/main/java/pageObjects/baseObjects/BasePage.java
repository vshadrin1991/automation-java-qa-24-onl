package pageObjects.baseObjects;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;

@Log4j
public abstract class BasePage {
    protected WebDriver driver;
    public WebDriverWait wait;
    protected Actions actions;

    {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    protected void navigateTo(String url) {
        log.info("Navigate to :: " + url);
        driver.get(url);
    }

    protected void click(By by) {
        click(driver.findElement(by));
    }

    protected void click(WebElement element) {
        log.info("Click on element :: " + element);
        waitUntilElementToBeClickable(element);
        element.click();
    }

    protected void sendKeys(By by, CharSequence... charSequences) {
        sendKeys(driver.findElement(by), charSequences);
    }

    protected void sendKeys(WebElement element, CharSequence... charSequences) {
        log.info("Enter in :: " + element + ", next values :: " + Arrays.toString(charSequences));
        element.clear();
        element.sendKeys(charSequences);
    }

    protected void waitUntil(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected Integer getElementsCount(By by) {
        return driver.findElements(by).size();
    }

    protected String getElementText(By by) {
        return getElementText(driver.findElement(by));
    }

    protected String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    protected List<String> getElementTexts(By by) {
        return getElementTexts(driver.findElements(by));
    }

    protected List<String> getElementTexts(List<WebElement> webElements) {
        return webElements.stream().map(data -> data.getText()).collect(Collectors.toList());
    }

    protected void waitUntilTextToBe(By by, String expectedText) {
        log.info("Wait until text to be present  :: " + expectedText);
        wait.until(ExpectedConditions.textToBe(by, expectedText));
    }

    protected void waitUntilTextNotToBe(By by, String expectedText) {
        log.info("Wait until text not to be present  :: " + expectedText);
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(by, expectedText)));
    }

    protected void waitUntilElementToBeClickable(By by) {
        waitUntilElementToBeClickable(driver.findElement(by));
    }

    protected void waitUntilElementToBeClickable(WebElement element) {
        log.info("Wait until element to be clickable  :: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementToBeNotClickable(By by) {
        waitUntilElementToBeNotClickable(driver.findElement(by));
    }

    protected void waitUntilElementToBeNotClickable(WebElement element) {
        log.info("Wait until element not to be clickable  :: " + element);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
    }

}
