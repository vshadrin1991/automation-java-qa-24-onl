package lecture_18;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"cucumber/rw"},
        plugin = {
                "json:target/cucumber.json",
                "html:target/rw/cucumber-pretty.html"
        },
        tags = "@smoke"
)
public class RunRWTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
