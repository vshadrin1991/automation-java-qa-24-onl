package pageObjects.rw;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private final SelenideElement from = $("[name='from']");
    private final SelenideElement to = $("[name='to']");
    private final SelenideElement search = $("input[type='submit']");

    public HomePage enterFrom(String from) {
        this.from.should(visible).sendKeys(from);
        return this;
    }

    public HomePage enterTo(String to) {
        this.to.should(visible).sendKeys(to);
        return this;
    }

    public HomePage clickSearch() {
        search.should(enabled).click();
        return this;
    }
}
