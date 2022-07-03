package jsonPlaceholder;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TableTest {
    @Test
    public void tenLinesTest() {
        open("http://computer-database.gatling.io/computers?p=1&n=10&s=name&d=asc");

        int size = $$("tbody >tr").size();
        Assert.assertEquals(10, size);
    }

    @Test
    public void failTenLinesTest() {
        open("http://computer-database.gatling.io/computers?p=0&n=10&s=name&d=asc");
        int h = 0;
        executeJavaScript(
                " var table=document.querySelectorAll(\"#main > table > tbody > tr:nth-child(0)\");" +
                        "for (var i=table.length; i>0; i--){" +
                        "table.remove()}"
        );

        int size = $$("tbody >tr").size();
        Assert.assertEquals(9, size);
    }

    public void saveContentData() {

        List<String> listOfName = new ArrayList<>();
        List<String> listOfIntroduced = new ArrayList<>();
        List<String> listOfDiscontinued = new ArrayList<>();
        List<String> listOfCompany = new ArrayList<>();
        List<SelenideElement> elementList = $$("tbody>tr");

        elementList.forEach(a ->
        {
            listOfName.add(a.$(By.tagName("a")).getText());
            listOfIntroduced.add(a.$(By.tagName("td:nth-child(2)")).getText());
            listOfDiscontinued.add(a.$(By.tagName("td:nth-child(3)")).getText());
            listOfCompany.add(a.$(By.cssSelector("#content>.row >.large-10")).getText());
        });

    }

    @Test
    public void sortedContentTest() {
        TestClassPageObject tC = new TestClassPageObject();
        open("http://computer-database.gatling.io/computers?p=0&n=10&s=name&d=asc");
        tC.getTable();


        }
    }
}
