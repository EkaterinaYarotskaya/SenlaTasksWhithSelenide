package jsonPlaceholder;

import enums.SortType;
import enums.SortedColumn;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.ComputerDatabasePage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TableTest {

    ComputerDatabasePage computerDatabasePage = new ComputerDatabasePage();

    @Test
    public void tenLinesTest() {
        computerDatabasePage.openStartPage();
        int size = computerDatabasePage.getTableSize();
        Assert.assertEquals(10, size);
    }

    @Test
    public void failTenLinesTest() {
        computerDatabasePage.openStartPage();
        executeJavaScript("return document.querySelectorAll('tbody>tr')[0].remove();");
        int size = computerDatabasePage.getTableSize();
        Assert.assertEquals(9, size);
    }

    @Test
    public void sortedContentByCompanyTest() throws ParseException {
        computerDatabasePage.openStartPage(500);
        computerDatabasePage.sortTableByParameters(SortedColumn.COMPANY, SortType.ASC);
        List<TableRowDto> list = TableUtils.getTable();
        List<TableRowDto> listSorted = TableUtils.sortList(list, SortedColumn.COMPANY, SortType.ASC);
        Assertions.assertEquals(list, listSorted);
    }

    @Test
    public void sortedContentByCompanyReverseTest() throws ParseException {
        computerDatabasePage.openStartPage(500);
        computerDatabasePage.sortTableByParameters(SortedColumn.COMPANY, SortType.DESC);
        List<TableRowDto> list = TableUtils.getTable();
        List<TableRowDto> listSorted = TableUtils.sortList(list, SortedColumn.COMPANY, SortType.DESC);
        Assertions.assertEquals(list, listSorted);
    }

    @Test
    public void sortedContentByDiscontinuedTest() throws ParseException {
        computerDatabasePage.openStartPage(100);
        computerDatabasePage.sortTableByParameters(SortedColumn.DISCONTINUED, SortType.ASC);
        List<TableRowDto> list = TableUtils.getTable();
        System.out.println(list.toString());
        List<TableRowDto> listSorted = TableUtils.sortList(list, SortedColumn.DISCONTINUED, SortType.ASC);
        Assertions.assertEquals(list, listSorted);
    }


    @Test
    public void sortedContentByDiscontinuedReverseTest() throws ParseException, NoSuchMethodException {
        computerDatabasePage.openStartPage(100);
        computerDatabasePage.sortTableByParameters(SortedColumn.DISCONTINUED, SortType.DESC);
        List<TableRowDto> list = TableUtils.getTable();
        List<TableRowDto> listSorted = TableUtils.sortList(list, SortedColumn.DISCONTINUED, SortType.DESC);
        Assertions.assertEquals(list, listSorted);
    }

}


