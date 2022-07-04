package jsonPlaceholder;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestClassPageObject {
    private SelenideElement table = $("tbody");
    private List bigTable = new ArrayList<TableDate>();
    private TableDate tableDate;


    public List<TableDate> getTable() {
        List<TableDate> result = new ArrayList<TableDate>();
        By by = By.cssSelector(" tr");
        List<WebElement> tr = table.findElements(by);
        for (int i = 0; i < tr.size(); i++) {
            result.add(i, createTable(tr.get(i)));
            bigTable.add(tableDate);
        }
        return bigTable;
    }

    private TableDate createTable(WebElement tr) {
        By by = By.cssSelector("td");
        List<WebElement> tds = tr.findElements(by);

        String s1 = tds.get(0).getText();
        String s2 =(tds.get(1)).getText();
        String s3 =(tds.get(2)).getText();
        String s4=(tds.get(3)).getText();

         tableDate = new TableDate(s1,s2,s3,s4);

        return tableDate;

    }
    public void toStringMethod() {
        for (int i=1; i<bigTable.size();i++){
//            System.out.println(bigTable.get(i));
            TableDate td= (TableDate) bigTable.get(i);
            System.out.println(td.getComputerName());
            System.out.println(td.getIntroduced());
            System.out.println(td.getDiscontinued());
            System.out.println(td.getCompany());
        }

    }
}

