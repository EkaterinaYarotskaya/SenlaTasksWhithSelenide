package pages;

import com.codeborne.selenide.SelenideElement;
import enums.SortType;
import enums.SortedColumn;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class ComputerDatabasePage {
    private SelenideElement computerNameHeader = $(".col-name");
    private SelenideElement introducedHeader = $(".col-introduced");
    private SelenideElement discontinuedHeader = $(".col-discontinued");
    private SelenideElement companyHeader = $(".col-company");
    private final Map<SortedColumn, SelenideElement> allHeaders;

    {
        allHeaders = new HashMap<>();
        allHeaders.put(SortedColumn.COMPUTER_NAME, computerNameHeader);
        allHeaders.put(SortedColumn.INTRODUCED, introducedHeader);
        allHeaders.put(SortedColumn.DISCONTINUED, discontinuedHeader);
        allHeaders.put(SortedColumn.COMPANY, companyHeader);
    }

    public void openStartPage() {
        open("http://computer-database.gatling.io/computers");
    }

    public void openStartPage(int rowsCount) {
        open(String.format("https://computer-database.gatling.io/computers?p=0&n=%s", rowsCount));
    }

    public int getTableSize() {
        return $$("tbody >tr").size();
    }

    public void sortTableByParameters(SortedColumn sortedColumn, SortType sortType) {
        String sortClassParameter;
        if (sortType.equals(SortType.ASC))
            sortClassParameter = "headerSortUp";
        else
            sortClassParameter = "headerSortDown";
        SelenideElement header = allHeaders.get(sortedColumn);
        while (!header.getAttribute("class").contains(sortClassParameter))
            header.$("a").click();
    }
}
