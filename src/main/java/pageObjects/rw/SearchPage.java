package pageObjects.rw;

import com.codeborne.selenide.ElementsCollection;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private final ElementsCollection dates = $$x("//ul[@class=\"sch-links__nav list-reset\"]//span");

    public SearchPage verifyDates(String... dates) {
        Arrays.asList(dates).forEach(date -> this.dates.find(matchText(date)).should(exist));
        return this;
    }

    public SearchPage clickDate(String date) {
        dates.find(matchText(date)).click();
        return this;
    }
}
