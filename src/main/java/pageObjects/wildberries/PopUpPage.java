package pageObjects.wildberries;

import pageObjects.baseObjects.BasePage;

public class PopUpPage extends BasePage {
    private final String popup = "//*[contains(@class,'popup-list')]";
    private final String closeBtn = popup.concat("//*[contains(@class,'close')]");

    public PopUpPage clickClose() {
        click(closeBtn);
        return this;
    }
}
