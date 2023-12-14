package pageObjects.baseObjects;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testngUtils.Listener;

import static driver.DriverCreation.createDriver;
import static driver.DriverCreation.quitDriver;
import static driver.DriverTypes.CHROME;

@Listeners(Listener.class)
public abstract class BaseTest {

    @BeforeTest
    protected void setUp() {
        createDriver(CHROME);
    }

    @AfterTest(alwaysRun = true)
    protected void tearDown() {
        quitDriver();
    }
}
