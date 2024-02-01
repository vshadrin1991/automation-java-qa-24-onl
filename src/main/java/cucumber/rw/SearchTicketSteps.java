package cucumber.rw;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.HomePage;
import pageObjects.rw.SearchPage;

public class SearchTicketSteps extends BaseTestSelenide {

    @Given("open home page")
    public void precondition() {
        get(HomePage.class);
    }

    @When("i enter from {string}")
    public void enterFrom(String city) {
        get(HomePage.class).enterFrom(city);
    }

    @And("i enter to {string}")
    public void enterTo(String city) {
        get(HomePage.class).enterTo(city);
    }

    @And("i click on search")
    public void clickSearch() {
        get(HomePage.class).clickSearch();
    }

    @Then("i check departure time great then 0")
    public void checkResults() {
        Assert.assertTrue(get(SearchPage.class).getDates().size() > 0);
    }
}
