package lecture_10;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

public class Lecture10 extends BaseTest {


    @Test
    public void test() {
        System.out.println("Hello i'am test 1 ");
    }

    @Test
    public void test2() {
        System.out.println("Hello i'am test 2 :: " + System.getProperty("help"));
    }

    @Test
    public void test3() {
        System.out.println("Hello i'am test 3 :: " + System.getProperty("testInfo"));
    }
}
