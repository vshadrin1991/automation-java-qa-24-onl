package lecture_4;

import driver.SimpleWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static driver.SimpleWebDriver.getWebDriver;

public class GoogleTests {

    private SimpleWebDriver webDriver = new SimpleWebDriver();
    private WebElement search;

    @BeforeTest
    public void setUp() {
        getWebDriver().get("http://google.com");
    }

    @Test
    public void test1() {
        String searchTxt = "-DskipTests=true";
        search = getWebDriver().findElement(By.cssSelector("[type='search']"));
        search.sendKeys(searchTxt, Keys.ENTER);
        Assert.assertEquals(getWebDriver().findElement(By.cssSelector("[class='card-section'] em")).getText(), searchTxt, "Not found results.");
    }


    @Test
    public void test2() throws InterruptedException {
        search = getWebDriver().findElement(By.cssSelector("[type='search']"));
        search.clear();
        search.sendKeys("Hello world", Keys.ENTER);
        List<String> data = new ArrayList<>();
        Thread.sleep(10000);
        for (WebElement element : getWebDriver().findElements(By.cssSelector("[lang='ru'] h3"))) {
            data.add(element.getText());
        }
        Assert.assertTrue(data.contains("Hello, world!"), "Not found results.");
    }


    @AfterTest
    public void tearDown() {
        getWebDriver().quit();
    }
}
