import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.open;

public class DynamicControlTest extends DynamicControlPage {

    String dynamicControlUrl = property.getProperty("dynamicControlUrl");

    @BeforeEach
    public void beforeTest() {

        open(dynamicControlUrl);
    }

    @Test
    public void checkBoxPresentAndClickable() {

        checkBox.isDisplayed();
        checkBox.click();
        checkBox.shouldBe(Condition.selected).click();
        checkBox.isDisplayed();

    }

    @Test
    public void clickOnRemoveAndAddButton() {
        clickOnRemoveButtonAndCheckBoxButton();
        clickOnRemoveButtonAndCheckBoxButton();
    }

    @Test
    public void addTextOnFields() {

        String text = "Hello";
        addTextOnField(text);
        inputField.shouldHave(value(text));

    }
}
