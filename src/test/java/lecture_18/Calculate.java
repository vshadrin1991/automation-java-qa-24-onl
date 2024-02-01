package lecture_18;

import org.testng.annotations.Test;

public class Calculate {

    public Integer sum(Integer a, Integer b) {

        return null;
    }

    @Test
    public void test1() {
        sum(0, 0);
    }

    @Test
    public void test2() {
        sum(1, 2);
    }

    @Test
    public void test3() {
        sum(-1, -2);
    }

}
