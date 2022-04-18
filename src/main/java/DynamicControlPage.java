import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DynamicControlPage extends DataFix {

    SelenideElement checkBox = $("input[type='checkbox']");
    SelenideElement inputField = $("input[type=text]");

    public void clickOnRemoveButtonAndCheckBoxButton() {

        SelenideElement removeAndCheckButton = $("#checkbox-example>button");

        if (checkBox.isDisplayed()) {
            removeAndCheckButton.click();
            checkBox.should(Condition.hidden, Duration.ofSeconds(10));
        } else {
            removeAndCheckButton.click();
            checkBox.should(Condition.exist, Condition.visible);
        }
    }

    public void addTextOnField(String text) {

        SelenideElement enableButton = $("#input-example>button");
        if (inputField.isDisplayed()) {
            enableButton.click();
            inputField.setValue(text);
        } else {
            inputField.setValue(text);

        }
    }
}
