package lecture_23;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewTasks {

    @Test(priority = 1)
    public void testReverseString() {
        String val = "Hello my name is White";
        val = new StringBuilder(val).reverse().toString();
        System.out.println(val);
    }

    @Test(priority = 2)
    public void testReverse2String() {
        String val = "Hello my name is White";
        String[] newVal = new String[val.length()];
        for (int i = val.toCharArray().length - 1; i >= 0; i--) {
            newVal[val.length() - i - 1] = ((Character) val.charAt(i)).toString();
        }
        System.out.println(String.join("", newVal));
        System.out.println(String.join("", new ArrayList<>() {{
            for (int i = val.toCharArray().length - 1; i >= 0; i--) {
                add(((Character) val.charAt(i)).toString());
            }
        }}));
    }


    @Test(priority = 3)
    public void replacerStringTest() {
        String val = "Hello* my* name* is* White";
        System.out.println(String.join(",", val.split("\\*")));
        System.out.println(val.replaceAll("[*]", ","));
    }

    @Test(priority = 4)
    public void palindromeTest() {
        String val = "А роза упала на лапу Азора";
        List<String> right = new ArrayList<>();
        List<String> left = new ArrayList<>();
        for (int i = val.toCharArray().length - 1; i >= 0; i--) {
            left.add(((Character) val.charAt(i)).toString());
        }
        for (int i = 0; i < val.toCharArray().length; i++) {
            right.add(((Character) val.charAt(i)).toString());
        }
        Assert.assertEquals(
                right.stream().map(String::toLowerCase).filter(el -> !el.equals(" ")).collect(Collectors.toList()),
                left.stream().map(String::toLowerCase).filter(el -> !el.equals(" ")).collect(Collectors.toList())
        );
    }

    @Test(priority = 5)
    public void annargammTest() {
        String s1 = "кот";
        String s2 = "ток";
        System.out.println(generateData(s1));
        System.out.println(generateData(s2));
        Assert.assertEquals(generateData(s1), generateData(s2));
    }

    @Test(priority = 6)
    public void fibonacciTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
    }

    @Test(priority = 6)
    public void factorialTest() {
        System.out.println(factorial(5));
    }

    //0, 1, 1, 2, 3 , 5, 8
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public String generateData(String s) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            data.add(((Character) s.charAt(i)).toString());
        }
        return data.stream().sorted().collect(Collectors.joining());
    }
}
