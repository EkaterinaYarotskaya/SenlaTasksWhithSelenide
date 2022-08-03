package jsonPlaceholder;

import enums.SortType;
import enums.SortedColumn;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TableTest {

    @Test
    public void tenLinesTest() {
        open("http://computer-database.gatling.io/computers");
        int size = $$("tbody >tr").size();
        Assert.assertEquals(10, size);
    }

    @Test
    public void failTenLinesTest() {
        open("http://computer-database.gatling.io/computers");
        // js проходит компиляцию , но ассерт падает (9 не равно 10)
        // удалить строку вручную через кнопку на экране не выходит. Пишет что компьютер удален. а он всёравно в списке

        for (int i = $$("tbody>tr").size()-1; i >= 0; i--)
            executeJavaScript("return document.querySelectorAll('tbody>tr')["+i+"].remove();");

        int size = $$("tbody >tr").size();
        Assert.assertEquals(9, size);
    }

    @Test
    public void sortedContentByCompanyTest() throws ParseException {
        TableUtils tC = new TableUtils();
        open("http://computer-database.gatling.io/computers");
        $("th.col-company.header > a").click();
        ArrayList<TableRowDto> list = (ArrayList<TableRowDto>) tC.getTable();
        List<TableRowDto> listSorted = ;
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        list.forEach(tableRowDto -> System.out.println(tableRowDto.getDiscontinued()));

        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        listSorted.forEach(tableRowDto -> System.out.println(tableRowDto.getDiscontinued()));
        Assert.assertEquals(list, listSorted);
    }

    @Test
    public void sortedContentByCompanyReverseTest() throws ParseException {
        TableUtils tC = new TableUtils();
        open("http://computer-database.gatling.io/computers?p=0&n=300&s=name&d=asc");
        String companyButton = "th.col-company.header > a";
        $(companyButton).click();
        $(companyButton).click();
        ArrayList<TableRowDto> list = (ArrayList<TableRowDto>) tC.getTable();
        List listSorted = List.of(tC.sortRevers(list, "company"));
        Assert.assertEquals(list, listSorted);
    }

    // отсортировать по полю computerName не выходит. т к список на сайте идет a-z & i-l
    @Test
    public void sortedContentByDiscontinuedTest() throws ParseException {
        TableUtils tC = new TableUtils();
        open("http://computer-database.gatling.io/computers");
        $("th.col-discontinued.header > a").click();
        $("th.col-discontinued.header > a").click();
        ArrayList<TableRowDto> list = (ArrayList<TableRowDto>) tC.getTable();
        tC.toStringMethod(list);
        List listSorted = List.of(tC.sortList(list, "discontinued"));

        // в этом тесте вся логика как в предыдущих , но ассерт падает. Т к после сортировки в 64 строке каша получается.
        // А выше в тестах всё работает
        Assertions.assertEquals(list, listSorted);
    }


    @Test
    public void sortedContentByDiscontinuedReverseTest() throws ParseException, NoSuchMethodException {
        TableUtils tableUtils = new TableUtils();
        open("http://computer-database.gatling.io/computers?p=2&n=200&s=discontinued&d=asc");

        $("#main > table > thead > tr > th.col-discontinued.header > a").click();

        List<TableRowDto> list = tableUtils.getTable();

        List<TableRowDto> listSorted = tableUtils.sortList(list, SortedColumn.DISCONTINUED, SortType.DESC);
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        list.forEach(tableRowDto -> System.out.println(tableRowDto.getDiscontinued()));
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        listSorted.forEach(tableRowDto -> System.out.println(tableRowDto.getDiscontinued()));
        // ассерт падает т к сортировка неправильно работает
        Assert.assertEquals(list, listSorted);
    }

}


