package steps;

import WorkWithWedElements.ListElements;

import WorkWithWedElements.Pages;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginSteps  {
    Pages pages=new Pages();
    SelenideElement element;
    @Given("Open website {string}")
    public void openWebsite(String URL) {
        open(URL);
    }

//    @Then("User enters  login {string}  and  password {string} . Was login successful {string}")
//    public void userEntersLoginAndPasswordWasLoginSuccessful(String login, String password, String result) {
//        $("#username").setValue(login);
//        $("#password").setValue(password).pressEnter();
//        boolean currentResult = false;
//        if (($$(".button.secondary.radius")).size() > 0) {
//            currentResult = true;
//        }
//        Assertions.assertEquals(currentResult, Boolean.valueOf(result));
//    }
    @Then("Add text {string} to field {string}")
    public void inputText(String text, String fieldName)  {

        element =pages.getElementFromPage(fieldName);
        Assertions.assertTrue(element.isDisplayed());
        element.setValue(text);

    }

    @Then("Click on {string}")
    public void clickOn(String fieldName)  {
        element =pages.getElementFromPage(fieldName);
        element.click();
        int o =0;
    }

    @Then("Is there {string} on the web page")
    public void isThereOnTheWebPage(String fieldName)  {
        Assertions.assertTrue(pages.getElementFromPage(fieldName).isDisplayed());
    }
}



