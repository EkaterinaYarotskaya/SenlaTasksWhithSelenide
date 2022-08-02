package jsonPlaceholder;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        executeJavaScript(
                " var table=document.querySelectorAll(\"#main > table > tbody > tr:nth-child(0)\");" +
                        "for (var i=table.length; i>0; i--){" +
                        "table.remove()}"
        );

        int size = $$("tbody >tr").size();
        Assert.assertEquals(9, size);
    }

    @Test
    public void sortedContentByCompanyTest() {
        TestClassPageObject tC = new TestClassPageObject();
        open("http://computer-database.gatling.io/computers");
        $("th.col-company.header > a").click();
        ArrayList<TableDate> list = (ArrayList<TableDate>) tC.getTable();
        List listSorted = List.of(tC.sort(list, "company"));
        Assert.assertEquals(list, listSorted);
    }

    @Test
    public void sortedContentByCompanyReverseTest() {
        TestClassPageObject tC = new TestClassPageObject();
        open("http://computer-database.gatling.io/computers?p=0&n=300&s=name&d=asc");
        String companyButton = "th.col-company.header > a";
        $(companyButton).click();
        $(companyButton).click();
        ArrayList<TableDate> list = (ArrayList<TableDate>) tC.getTable();
        List listSorted = List.of(tC.sortRevers(list, "company"));
        Assert.assertEquals(list, listSorted);
    }
// отсортировать по полю computerName не выходит. т к список на сайте идет a-z & i-l
    @Test
    public void sortedContentByDiscontinuedTest() {
        TestClassPageObject tC = new TestClassPageObject();
        open("http://computer-database.gatling.io/computers");
        $("#main > table > thead > tr > th.col-discontinued.header > a").click();
        ArrayList<TableDate> list = (ArrayList<TableDate>) tC.getTable();
        tC.toStringMethod(list);
        List listSorted = List.of(tC.sort(list, "discontinued"));

        // в этом тесте вся логика как в предыдущих , но ассерт падает. Т к после сортировки в 64 строке каша получается.
        // А выше в тестах всё работает
        Assertions.assertEquals(list, listSorted);
    }


    @Test
    public void sortedContentByDiscontinuedReverseTest() {
        TestClassPageObject tC = new TestClassPageObject();
        open("http://computer-database.gatling.io/computers");
        String discontinuedButton = "th.col-discontinued.header.headerSortUp > a";

        $("#main > table > thead > tr > th.col-discontinued.header > a").click();
        $("#main > table > thead > tr > th.col-discontinued.header.headerSortUp > a").click();

        ArrayList<TableDate> list = (ArrayList<TableDate>) tC.getTable();
        List listSorted = List.of(tC.sortRevers(list, "discontinued"));
        // ассерт падает т к сортировка неправильно работает
        Assert.assertEquals(list, listSorted);
    }

}


