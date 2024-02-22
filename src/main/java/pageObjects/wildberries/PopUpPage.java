package pageObjects.wildberries;

public class PopUpPage extends BaseWBPage<PopUpPage> {
    private final String popup = "//*[contains(@class,'popup-list')]";
    private final String closeBtn = popup.concat("//*[contains(@class,'close')]");

    public PopUpPage clickClose() {
        click(closeBtn);
        return me();
    }
}
