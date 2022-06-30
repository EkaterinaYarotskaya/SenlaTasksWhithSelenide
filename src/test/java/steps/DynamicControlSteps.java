package steps;

import WorkWithWedElements.Pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.function.BooleanSupplier;

public class DynamicControlSteps {
    Pages pages = new Pages();
    SelenideElement element;

    @Then("Check whether {string} is {string} on a web page. Expect {string}")
    public void checkWhetherIsOnAWebPageExpect(String fieldName, String action, String expectedResult) {

        if (action.equals("displayed"))

            Assertions.assertEquals(pages.getElementFromPage(fieldName).isDisplayed(), Boolean.valueOf(expectedResult));
        else if (action.equals("selected"))
            Assertions.assertEquals(pages.getElementFromPage(fieldName).isSelected(), Boolean.valueOf(expectedResult));
        else if (action.equals("enabled"))
            Assertions.assertEquals(pages.getElementFromPage(fieldName).should(Condition.disabled), Boolean.valueOf(expectedResult));
        else throw new RuntimeException("Нет заданного дествия. Доступны методы displayed, selected, enabled");

    }

    @And("Check whether {string} is hidden")
    public void checkWhetherIsHidden(String fieldName) {
        element = pages.getElementFromPage(fieldName);
        element.should(Condition.hidden);
    }

    @And("Check whether {string} is exist and visible")
    public void checkWhetherIsExistAndVisible(String fieldName) {

        pages.getElementFromPage(fieldName).should(Condition.exist, Condition.visible);
    }

    @And("Check whether {string} is disabled")
    public void checkWhetherIsDisabled(String fieldName) {
        pages.getElementFromPage(fieldName).should(Condition.disabled);
    }

    @Then("Whether the text {string} was introduced in the field {string}")
    public void whetherTheTextWasIntroducedInTheField(String textOnField, String fieldName) {
        pages.getElementFromPage(fieldName).shouldHave(Condition.exactValue(textOnField));

    }
}