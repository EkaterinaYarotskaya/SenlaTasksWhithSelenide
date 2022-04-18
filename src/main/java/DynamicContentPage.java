import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class DynamicContentPage extends DataFix {

    public List<String> saveContentData() {

        List<String> listOfContent = new ArrayList<>();
        List<SelenideElement> elementList = $$("#content>.row");

        elementList.forEach(a ->
        {
            listOfContent.add(a.$(By.tagName("img")).getAttribute("src"));
            listOfContent.add(a.$(By.cssSelector("#content>.row >.large-10")).getText());
        });

        return listOfContent;
    }
}