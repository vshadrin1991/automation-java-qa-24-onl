package pageObjects.herokuapp;

public enum HomePageItems {
    AB_TESTING("A/B Testing"),
    ADD_REMOVE_ELEMENTS("Add/Remove Elements"),
    CHECKBOX("Checkboxes"),
    INFINITE_SCROLL("Infinite Scroll"),
    FRAMES("Frames"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FILE_DOWNLOAD("File Download"),
    SORTABLE_DATA_TABLES("Sortable Data Tables");

    private final String item;

    HomePageItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
