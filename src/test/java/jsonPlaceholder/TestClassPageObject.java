package jsonPlaceholder;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class TestClassPageObject {
    private final SelenideElement table = $("tbody");
    private final SelenideElement nextButton = $("#pagination > ul > li.next > a");

    public ArrayList bigTable = new ArrayList<TableDate>();
    private TableDate tableDate;

    public List<TableDate> getTable() {

        List result = new ArrayList<TableDate>();
        By by = By.cssSelector(" tr");
        List<WebElement> tr = table.findElements(by);
        for (int i = 0; i < tr.size(); i++) {
            result.add(i, createTable(tr.get(i)));
            bigTable.add(tableDate);
        }
        turnPage();
        return bigTable;
    }

    private void turnPage() {
        try {
            if (!(nextButton.getAttribute("href")).equals(null)) {
                $(nextButton).click();
                getTable();
            }
        } catch (NullPointerException e) {
        }
    }

    private TableDate createTable(WebElement tr) {

        By by = By.cssSelector("td");
        List<WebElement> tds = tr.findElements(by);
        String s1 = tds.get(0).getText();
        String s2 = (tds.get(1)).getText();
        String s3 = (tds.get(2)).getText();
        String s4 = (tds.get(3)).getText();

        tableDate = new TableDate(s1, s2, s3, s4);
        return tableDate;
    }

    public void toStringMethod(List list) {

        for (int i = 0; i < list.size(); i++) {
            TableDate td = (TableDate) list.get(i);
            System.out.println(td.getComputerName() + " " + td.getIntroduced() + " " +
            td.getDiscontinued()+ " " + td.getCompany());
        }
    }

    public TableDate[] sort(List list, String fieldName) {

        TableDate[] tableDates = (TableDate[]) list.toArray(new TableDate[list.size()]);
        Comparator<TableDate> sortByField = null;
        if (fieldName.equals("computerName")) {
            sortByField = Comparator.comparing(TableDate::getComputerName);
        } else if (fieldName.equals("introduced")) {
            sortByField = Comparator.comparing(TableDate::getIntroduced);
        } else if (fieldName.equals("discontinued")) {
            sortByField = Comparator.comparing(TableDate::getDiscontinued);
        } else if (fieldName.equals("company")) {
            sortByField = Comparator.comparing(TableDate::getCompany);
        } else System.err.println("Field with name " + fieldName + "not found");
        Arrays.sort(tableDates, sortByField);
        return tableDates;
    }

    public TableDate[] sortRevers(List list, String fieldName) {

        TableDate[] tableDates = (TableDate[]) list.toArray(new TableDate[list.size()]);
        Comparator<TableDate> sortByField = null;
        if (fieldName.equals("computerName")) {
            sortByField = Comparator.comparing(TableDate::getComputerName).reversed();
        } else if (fieldName.equals("introduced")) {
            sortByField = Comparator.comparing(TableDate::getCompany);
        } else if (fieldName.equals("discontinued")) {
            sortByField = Comparator.comparing(TableDate::getCompany);
        } else if (fieldName.equals("company")) {
            sortByField = Comparator.comparing(TableDate::getCompany).reversed();
        } else System.err.println("Field with name " + fieldName + "not found");
        Arrays.sort(tableDates, sortByField);
        return tableDates;
    }
}

