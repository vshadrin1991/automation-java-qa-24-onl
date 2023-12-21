package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class FileDownloadPage extends BasePage {
    private final By header = By.tagName("h3");

    private By getFile(String filename) {
        return By.linkText(filename);
    }

    public void verifyTitleText() {
        wait.until(textToBe(header, "File Downloader"));
    }

    public void downloadFile(String file) {
        click(getFile(file));
    }
}
