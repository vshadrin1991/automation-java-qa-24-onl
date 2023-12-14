package lecture_9;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;
import testngUtils.Retry;

public class Lecture9_3 {
    Integer counter = 0;


    @Test(priority = 1, enabled = false)
    public void test1() {
        System.out.println("test1");
    }

    @Test(timeOut = 1000, description = "this is test verify timeout exception", expectedExceptions = ThreadTimeoutException.class)
    public void test2() {
        pause(2);
        System.out.println("test2");
    }

    @Test(dependsOnMethods = "test2", alwaysRun = true)
    public void test3() {
        System.out.println("test3");
    }

    @Test(invocationCount = 5, threadPoolSize = 2)
    public void test5() {
        counter++;
        pause(1);
        System.out.println("test5 :: " + counter);
    }

    @Test(priority = 1, timeOut = 1000, retryAnalyzer = Retry.class)
    public void test4() {
        pause(2);
        System.out.println("test4");
    }

    private void pause(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
