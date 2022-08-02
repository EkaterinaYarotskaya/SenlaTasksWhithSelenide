package steps;

import WorkWithWedElements.Pages;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {
    Pages pages = new Pages();
    SelenideElement element;

    @Given("Open website {string}")
    public void openWebsite(String URL) {
        open(URL);
    }

    @Then("Add text {string} to field {string}")
    public void inputText(String text, String fieldName) {

        element = pages.getElementFromPage(fieldName);
        Assertions.assertTrue(element.isDisplayed());
        element.setValue(text);

    }

    @Then("Click on {string}")
    public void clickOn(String fieldName) {
        element = pages.getElementFromPage(fieldName);
        element.click();

    }

    @Then("Is there {string} on the web page")
    public void isThereOnTheWebPage(String fieldName) {
        Assertions.assertTrue(pages.getElementFromPage(fieldName).isDisplayed());
    }


}



