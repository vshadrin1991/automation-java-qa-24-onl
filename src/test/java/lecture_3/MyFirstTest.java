package lecture_3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    String str = "Hello";


    @Test
    public void test1() {
        Assert.assertFalse(str.isEmpty(), "String is empty!");
    }

    @Test
    public void test2() {
        Assert.assertNotEquals(str, null);
    }
}
