package testngUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Hello i'am started with ::" + context.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Hello i'am finished with ::" + context.getSuite().getName());
    }
}
