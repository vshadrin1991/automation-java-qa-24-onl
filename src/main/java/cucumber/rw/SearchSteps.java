package cucumber.rw;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.HeaderPage;
import pageObjects.rw.HomePage;
import pageObjects.rw.SearchResultPage;

public class SearchSteps extends BaseTestSelenide {

    @When("i search by {string}")
    public void search(String searchData) {
        get(HeaderPage.class).openSearch().enterSearch(searchData).clickSearch();
    }

    @Then("i check search results great then 0")
    public void checkResults() {
        Assert.assertTrue(get(SearchResultPage.class).getSearchResults().size() > 0);
    }
}
