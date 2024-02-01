package pageObjects.rw;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {

    private final ElementsCollection results = $$(".search-result__item");

    public List<String> getSearchResults() {
        return results.shouldBe(sizeGreaterThan(0)).texts();
    }
}
