package lecture_12;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.List;
import java.util.stream.Collectors;

public class SortableDataTablesTest extends BaseTest {

    @Test(priority = 1)
    public void getTableHeadersTest() {
        SortableDataTablesPage tablesPage = new SortableDataTablesPage();
        List<String> headers = tablesPage.getTableHeaders(1);
        System.out.println(headers.stream().filter(value -> value.contains("Name")).collect(Collectors.toList()));
        List<String> row = tablesPage.getTableRowData(1, 1);
        System.out.println(row);
    }
}
