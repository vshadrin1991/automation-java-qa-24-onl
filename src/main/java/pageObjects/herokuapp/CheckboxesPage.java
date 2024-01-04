package pageObjects.herokuapp;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

@Log4j
public class CheckboxesPage extends BasePage {
    private final By header = By.tagName("h3");

    private By getCheckbox(String index) {
        return By.xpath("(//*[@id='checkboxes']/input)[" + index + "]");
    }

    public void verifyTitleText() {
        wait.until(ExpectedConditions.textToBe(header, "Checkboxes"));
    }

    public void clickCheckbox(Integer index) {
        click(getCheckbox(index.toString()));
    }

    public void verifyElementsCount() {
        log.info("Elements count is :: " + getElementsCount(getCheckbox("..")));
        wait.until(ExpectedConditions.numberOfElementsToBe(getCheckbox(".."), 2));
    }

    public void verifyCheckboxStatus(Integer index, Boolean status) {
        //String str = <condition> ? <if> : <else>
        wait.until(ExpectedConditions.attributeToBe(getCheckbox(index.toString()), "checked", (status ? "true" : "")));
    }


}
