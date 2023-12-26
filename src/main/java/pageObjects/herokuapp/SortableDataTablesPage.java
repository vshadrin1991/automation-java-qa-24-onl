package pageObjects.herokuapp;

import driver.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseObjects.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class SortableDataTablesPage extends BasePage implements HerokuApp {
    private final By header = By.tagName("h3");
    private final By cell = By.tagName("td");

    private WebElement getTable(Integer tableIndex) {
        return driver.findElement(By.id("table" + tableIndex));
    }

    private List<WebElement> getHeaders(Integer tableIndex) {
        return getTable(tableIndex).findElements(By.tagName("th"));
    }

    private List<WebElement> getTableRows(Integer tableIndex) {
        return getTable(tableIndex).findElements(By.xpath("//tbody//tr"));
    }

    public void clickEdit() {
        UIElement element = new UIElement(driver.findElement(By.linkText("edit")), wait);
        element.click();
    }

    @Override
    public void verifyPageLoaded() {
        verifyTitleText();
    }

    @Override
    public void verifyTitleText() {
        waitUntilTextToBe(header, "Data Tables");
    }

    public List<String> getTableHeaders(Integer tableIndex) {
        return getHeaders(tableIndex).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTableRowData(Integer tableIndex, Integer tableRowIndex) {
        return getTableRows(tableIndex).get(tableRowIndex - 1).findElements(cell).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
