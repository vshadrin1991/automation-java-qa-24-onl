package lecture_9;

import org.testng.annotations.*;

public class Lecture9_1 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("i'am BeforeSuite Lecture9_1");
    }

    @BeforeTest(groups = {"smoke"})
    public void beforeTest() {
        System.out.println("i'am BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("i'am BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("i'am BeforeMethod");
    }

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void test1() {
        System.out.println("i'am Test 1 from Lecture9_1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("i'am Test 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("i'am AfterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("i'am AfterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("i'am AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("i'am AfterSuite");
    }

}
