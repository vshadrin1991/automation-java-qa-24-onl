package lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lesson6 {

    @BeforeTest
    public void setUp() {
        setUpWebDriver("https://www.saucedemo.com");
    }

    @Test(enabled = false)
    public void locators() {
        WebElement elementId = getWebDriver().findElement(By.id("name"));
        WebElement elementName = getWebDriver().findElement(By.name("name"));
        WebElement elementLinkText = getWebDriver().findElement(By.linkText("Challenging DOM"));
        WebElement elementPartialLinkText = getWebDriver().findElement(By.partialLinkText("Challenging"));
        WebElement elementTagName = getWebDriver().findElement(By.tagName("h3"));
        WebElement elementClassName = getWebDriver().findElement(By.className("form_column"));
        WebElement elementCssSelector = getWebDriver().findElement(By.cssSelector("form_column"));
        WebElement elementXpath = getWebDriver().findElement(By.xpath("//*div"));
    }

    @Test
    public void sourceDemoTests() {
        getWebDriver().findElement(with(By.tagName("input")).above(By.id("password"))).sendKeys("username");
        getWebDriver().findElement(with(By.tagName("input")).below(By.id("password"))).click();
        System.out.println( getWebDriver().findElements(with(By.tagName("input")).near(By.id("password"))).size());
        System.out.println( getWebDriver().findElements(with(By.tagName("input")).near(By.id("password"), 100)).size());

        getWebDriver().findElement(By.id("user-name")).clear();
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.id("login-button")).click();

        getWebDriver().findElements(with(By.xpath("//*[@class='inventory_item_description']")).toLeftOf(By.xpath("(//*[@class='inventory_item_description'])[2]"))).forEach(d -> System.out.println(d.getText()));
        getWebDriver().findElements(with(By.xpath("//*[@class='inventory_item_description']")).toRightOf(By.xpath("(//*[@class='inventory_item_description'])[1]"))).forEach(d -> System.out.println(d.getText()));
    }

    @AfterTest
    public void tearDown() {
        quit();
    }
}
