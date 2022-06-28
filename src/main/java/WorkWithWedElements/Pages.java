package WorkWithWedElements;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.$;

public class Pages {
    public SelenideElement getElementFromPage(String elemName)  {
        ListElements listElements = new ListElements();
        Optional<Field> correct = Arrays.stream(listElements.getClass().getFields())
                .filter(field -> field.getAnnotation(Name.class).value().equals(elemName))
                .findFirst();

        SelenideElement locator = null;
        if (correct.isPresent()) {
            Field field = correct.get();
            if (!field.getAnnotation(FindBy.class).css().isEmpty())
                locator = $(field.getAnnotation(FindBy.class).css());
        }
        return locator;
    }
}
