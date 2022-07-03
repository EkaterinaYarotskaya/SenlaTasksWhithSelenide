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
    private List<TableDate> result = new ArrayList<TableDate>();

    @Override
    public String toString() {
        for ()
        return ;
    }

    public List<TableDate> getTable() {
        List<TableDate> result = new ArrayList<TableDate>();
        By by = By.cssSelector(" tr");
        List<WebElement> tr = table.findElements(by);
        for (int i = 0; i < tr.size(); i++) {
            result.add(i, createTable(tr.get(i)));
        }
        return result;
    }

    private TableDate createTable(WebElement tr) {
        By by = By.cssSelector("td");
        List<WebElement> tds = tr.findElements(by);

        TableDate result = new TableDate();
        String s1 = tds.get(0).getText();
        String s2 =(tds.get(1)).getText();
        String s3 =(tds.get(2)).getText();
        String s4=(tds.get(3)).getText();

        result.setComputerName(s1);
        result.setIntroduced(s2);
        result.setDiscontinued(s3);
        result.setCompany(s4);
        return result;
    }
}

