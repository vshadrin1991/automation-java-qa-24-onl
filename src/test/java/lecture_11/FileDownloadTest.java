package lecture_11;

import io.qameta.allure.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.FileDownloadPage;
import pageObjects.herokuapp.home.HomePage;

import static pageObjects.herokuapp.HomePageItems.FILE_DOWNLOAD;

public class FileDownloadTest extends BaseTest {
    HomePage homePage;

    @BeforeTest
    public void preconditions() {
        homePage = new HomePage();
        homePage.getSteps().navigateTo(FILE_DOWNLOAD);
    }

    @Description("File download test")
    @Step("Download Test1.pdf")
    @Link("https://the-internet.herokuapp.com/download")
    @Test(priority = 1)
    public void firstFileDownloadTest() {
        FileDownloadPage downloadPage = new FileDownloadPage();
        downloadPage.verifyTitleText();
        downloadPage.downloadFile("Test1.pdf");
    }

    @Description("File download test")
    @Step("Download file.docx")
    @TmsLink("QA24-33")
    @Issue("QA-56")
    @Link("https://the-internet.herokuapp.com/download")
    @Test(priority = 2)
    public void secondFileDownloadTest() {
        FileDownloadPage downloadPage = new FileDownloadPage();
        downloadPage.verifyTitleText();
        downloadPage.downloadFile("file.docx");
    }
}
