package lecture_22;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Lecture22 {

    @Test
    public void popupTest() {
        Configuration.headless = false;
        open("https://www.lamoda.by/men-home/?sitelink=topmenuMu");
        $x("//a[@href='/lp/cookie/']").should(Condition.exist).click();
        System.out.println("");
    }
}
