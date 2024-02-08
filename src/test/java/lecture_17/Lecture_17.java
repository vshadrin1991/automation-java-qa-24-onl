package lecture_17;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Lecture_17 {

    @BeforeTest
    public void precondition() {
        open("https://www.rw.by");
    }

    @Test
    public void test() {
        $("#acFrom").sendKeys("Витебск");
        $x("//input[@id=\"acTo\"]").should(visible).sendKeys("Минск");
        $(By.xpath("//input[@type=\"submit\"]")).should(enabled, exist).click();
        ElementsCollection dateElements = $$x("//ul[@class=\"sch-links__nav list-reset\"]//span");
        dateElements.should(sizeGreaterThan(0));
        List<String> dates = dateElements.texts();
        System.out.println(dates);
        dateElements.findBy(matchText("все дни")).click();
        System.out.println($("[name='direction']").should(exist).val());
    }

}
