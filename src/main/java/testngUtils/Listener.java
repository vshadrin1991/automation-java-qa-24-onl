package testngUtils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.setUpProperty;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        if (System.getProperties().containsKey("config")) {
            setUpProperty(System.getProperty("config"));
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Hello i'am finished with ::" + context.getSuite().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveAllureScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
