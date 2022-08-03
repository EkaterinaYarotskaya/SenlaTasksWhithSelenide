package jsonPlaceholder;

import com.codeborne.selenide.SelenideElement;
import enums.SortType;
import enums.SortedColumn;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableUtils {
    private final SelenideElement nextButton = $("li.next > a");

    public List<TableRowDto> bigTable = new ArrayList<>();

    public List<TableRowDto> getTable() throws ParseException {

        for (SelenideElement row : $$("tbody > tr"))
            bigTable.add(createRawDto(row));
//        turnPage();
        return bigTable;
    }

    private void turnPage() {
        try {
            if ((nextButton.getAttribute("href")) != null) {
                $(nextButton).click();
                getTable();
            }
        } catch (NullPointerException | ParseException e) {
        }
    }

    private TableRowDto createRawDto(SelenideElement tr) throws ParseException {
        List<String> texts = tr.$$("td").texts();
        return new TableRowDto(texts.get(0), texts.get(1), texts.get(2), texts.get(3));
    }

    public void toStringMethod(List list) {

        for (int i = 0; i < list.size(); i++) {
            TableRowDto td = (TableRowDto) list.get(i);
            System.out.println(td.getComputerName() + " " + td.getIntroduced() + " " +
                    td.getDiscontinued() + " " + td.getCompany());
        }
    }

    public List<TableRowDto> sortList(List list, SortedColumn columnName, SortType sortType) {

        Comparator<TableRowDto> sortByField = null;
        if (columnName.equals(SortedColumn.COMPUTER_NAME)) {
            sortByField = Comparator.comparing(TableRowDto::getComputerName);
        } else if (columnName.equals(SortedColumn.INTRODUCED)) {
            sortByField = Comparator.comparing(TableRowDto::getIntroduced);
        } else if (columnName.equals(SortedColumn.DISCONTINUED)) {
            sortByField = Comparator.comparing(TableRowDto::getDiscontinued);
        } else if (columnName.equals(SortedColumn.COMPANY)) {
            sortByField = Comparator.comparing(TableRowDto::getCompany);
        }
        list.sort(sortByField);
        if (sortType.equals(SortType.DESC))
            list.sort(Collections.reverseOrder());
        return list;
    }
}

