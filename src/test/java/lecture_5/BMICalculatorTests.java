package lecture_5;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;

public class BMICalculatorTests {

    @BeforeTest
    public void setUp() {
        setUpWebDriver("https://healthunify.com/bmicalculator/");
    }

    @Test
    public void smokeTest() {
        getWebDriver().findElement(By.xpath("//input[@name='wg']")).click();
        getWebDriver().findElement(By.name("wg")).sendKeys("70");
        Select opt2 = new Select(getWebDriver().findElement(By.name("opt2")));
        opt2.selectByValue("4");
        Select opt3 = new Select(getWebDriver().findElement(By.name("opt3")));
        opt3.selectByValue("5");
        getWebDriver().findElement(By.name("cc")).click();
        Assert.assertFalse(getWebDriver().findElements(By.name("desc")).isEmpty());
        Assert.assertEquals(getWebDriver().findElement(By.name("desc")).getAttribute("value"), "Your category is Obese");
    }

    @AfterTest
    public void tearDown() {
        quit();
    }
}