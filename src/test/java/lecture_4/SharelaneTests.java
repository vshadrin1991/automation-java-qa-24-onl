package lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SharelaneTests {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test(priority = 1)
    public void zipCodeNegativeValuesTest() {
       /* WebElement logo = driver.findElement(By.tagName("img"));
        logo.click();
        WebElement singUpButton = driver.findElement(By.cssSelector("[href='./register.py']"));
        singUpButton.click();*/
        Arrays.asList("1234", "!@#$%", "ABCDE").forEach(value -> verifyZipCodeError(value));
    }

    @Test(priority = 2, dependsOnMethods = "zipCodeNegativeValuesTest")
    public void zipCodePositiveValuesTest() {
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        zipCode.clear();
        zipCode.sendKeys("12345");
        continueButton.click();
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        boolean result = registerButton.isDisplayed();
        Assert.assertTrue(result, "Register window not displayed.");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    /**
     * @param value - enter zip coe value
     *              Method check error message after enter value in zip code and click on continue button.
     */
    private void verifyZipCodeError(String value) {
        WebElement zipCode = driver.findElement(By.name("zip_code"));
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        zipCode.clear();
        zipCode.sendKeys(value);
        continueButton.click();
        WebElement error = driver.findElement(By.cssSelector("[class='error_message']"));
        boolean result = error.getText().equals("Oops, error on page. ZIP code should have 51 digits");
        Assert.assertTrue(result, "Error message is not displayed.");
    }
}
