package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DynamicControlSteps {
    SelenideElement checkBox = $("input[type=checkbox]");

    SelenideElement inputField = $("input[type=\"text\"]");
    SelenideElement EnableDisableButton = $("#input-example>button");

    @Then("Check whether {string} is {string} on a web page")
    public void checkWhetherAnElementIsDisplayedAndSelected(String element, String checkTape) {
        if (element.equals("checkbox")) {
            if (checkTape.equals("displayed")) {
                Assertions.assertTrue(checkBox.isDisplayed());
            } else {
                if (checkTape.equals("selected")) {
                    Assertions.assertTrue(checkBox.isSelected());
                } else throw new RuntimeException("Элемент не найден");
            }
        } else {
//            if(element.equals("checkbox"))
        }

    }


//    @Then("Click on {string}")
//    public void clickOn(String buttonName) {
//
//        if (buttonName.equals("checkbox")) {
//            checkBox.click();
//        } else {
//            if (buttonName.equals("remove/add button")) {
//                SelenideElement removeAndCheckButton = $("#checkbox-example>button");
//
//                if (checkBox.isDisplayed()) {
//                    removeAndCheckButton.click();
//                    checkBox.should(Condition.hidden, Duration.ofSeconds(10));
//                } else {
//                    removeAndCheckButton.click();
//                    checkBox.should(Condition.exist, Condition.visible);
//                }
//
//            } else throw new RuntimeException("Элемент не найден");
//        }
//}
}

