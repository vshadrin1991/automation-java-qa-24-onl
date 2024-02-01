package pageObjects.rw;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {

    private final SelenideElement openButton = $(".btn-open");
    private final SelenideElement searchButton = $(".btn-search");

    private final SelenideElement searchField = $("#headSearch");

    public HeaderPage openSearch() {
        openButton.click();
        return this;
    }

    public HeaderPage clickSearch() {
        searchButton.click();
        return this;
    }

    public HeaderPage enterSearch(String searchData) {
        searchField.should(Condition.visible).sendKeys(searchData);
        return this;
    }
}
