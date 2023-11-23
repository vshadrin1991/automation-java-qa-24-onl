package lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class BMICalculatorTests {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void smoketest() {
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//input[@name='wg']")).click();
        driver.findElement(By.name("wg")).sendKeys("70");
        {
            WebElement dropdown = driver.findElement(By.name("opt2"));
            dropdown.findElement(By.xpath("//option[. = '4′']")).click();
        }
        {
            WebElement dropdown = driver.findElement(By.name("opt3"));
            dropdown.findElement(By.xpath("//option[. = '5″']")).click();
        }
        driver.findElement(By.name("cc")).click();
        {
            List<WebElement> elements = driver.findElements(By.name("desc"));
            Assert.assertFalse(elements.isEmpty());
        }
        {
            String value = driver.findElement(By.name("desc")).getAttribute("value");
            Assert.assertEquals(value, "Your category is Obese");
        }
    }
}