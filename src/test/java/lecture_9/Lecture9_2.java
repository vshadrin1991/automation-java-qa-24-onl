package lecture_9;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Lecture9_2 {

    @BeforeClass
    public void beforeClass() {
        System.out.println("i'am BeforeClass from Lecture9_2");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("i'am Test 1 from Lecture9_2");
    }
}
