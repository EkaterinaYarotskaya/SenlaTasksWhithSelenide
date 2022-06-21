package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DynamicControlSteps {

    WebElement checkBox = $("input[type=checkbox]");
    WebElement removeAndCheckButton = $("#checkbox-example>button");
    WebElement inputField = $("");

    @Then("Check whether an element is displayed on a web page")
    public void checkWhetherAnElementIsDisplayedOnAWebPage() {
        checkBox.isDisplayed();
    }

    @Then("Click on check box")
    public void clickOnCheckBox() {
        checkBox.click();
    }

    @Then("Check box is selected on the web page")
    public void checkBoxIsSelectedOnTheWebPage() {
        checkBox.isSelected();
    }

    @Then("Click on remove/add button")
    public void clickOnRemoveButton() {
        removeAndCheckButton.click();
    }

    @Then("Check box is hidden on the web page")
    public void checkBoxIsHiddenOnTheWebPage() {
//        checkBox.shouldBe(Condition.hidden, Duration.ofSeconds(15));
        $("input[type=checkbox]").should(Condition.hidden, Duration.ofSeconds(15));
    }

    @Then("Check box is visible and exist on the web page")
    public void checkBoxIsVisibleAndExistOnTheWebPage() {
        $("input[type=checkbox]").should(Condition.visible, Condition.exist);
    }
}
