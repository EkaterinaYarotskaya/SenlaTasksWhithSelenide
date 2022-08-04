package jsonPlaceholder;

import com.codeborne.selenide.SelenideElement;
import enums.SortType;
import enums.SortedColumn;

import java.text.ParseException;
import java.util.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableUtils {
    private static final SelenideElement nextButton = $("li.next > a");
    private static List<TableRowDto> bigTable = new ArrayList<>();
    private static final Map<SortedColumn, Comparator<TableRowDto>> sortComparators;

    static {
        sortComparators = new HashMap<>();
        sortComparators.put(SortedColumn.COMPUTER_NAME, Comparator.comparing(TableRowDto::getComputerName));
        sortComparators.put(SortedColumn.INTRODUCED, Comparator.comparing(TableRowDto::getIntroduced));
        sortComparators.put(SortedColumn.DISCONTINUED, Comparator.comparing(TableRowDto::getDiscontinued));
        sortComparators.put(SortedColumn.COMPANY, Comparator.comparing(TableRowDto::getCompany));
    }

    public static List<TableRowDto> getTable() throws ParseException {
        boolean status = true;
        while (status) {
            for (SelenideElement row : $$("tbody > tr"))
                bigTable.add(createRawDto(row));
            if ((nextButton.getAttribute("href") != null))
                turnPage();
            else status = false;
        }
        List<TableRowDto> finalTable = new ArrayList<>(bigTable);
        bigTable.clear();
        return finalTable;
    }

    private static void turnPage() {
        $(nextButton).click();
    }

    private static TableRowDto createRawDto(SelenideElement tr) throws ParseException {
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

    public static List<TableRowDto> sortList(List list, SortedColumn columnName, SortType sortType) {

        list.sort(sortComparators.get(columnName));
        if (sortType.equals(SortType.DESC))
            list.sort(Collections.reverseOrder());
        return list;
    }
}

