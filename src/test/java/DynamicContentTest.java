import com.codeborne.selenide.commands.ShouldHave;
import org.assertj.core.error.ShouldBe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class DynamicContentTest extends DynamicContentPage {

    @BeforeEach
    public void beforeTest() {
        open(property.getProperty("dynamicContentUrl"));
    }

    @Test
    public void dynamicContentIsPresent() {
        List<String> listBefore = new ArrayList();
        List<String> listAfter = new ArrayList();
        listBefore = saveContentData();
        $("p>a[href]").click();
        listAfter = saveContentData();
        Assertions.assertFalse(listBefore.equals(listAfter));
    }
}