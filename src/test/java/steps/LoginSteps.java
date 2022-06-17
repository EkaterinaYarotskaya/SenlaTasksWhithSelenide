package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginSteps {
    @Given("Open website (.*)")
    public void openWebsite(String URL) {
        open(URL);
    }

    @Then("User enters  login (\".*\") and password (\".*\")")
    public void userEntersLoginAndPasswords(String stringLogin, String stringPassword) {
        $("#username").setValue(stringLogin);
        $("#password").setValue(stringPassword);
    }

    @Then("Press button LOGIN")
    public void pressButtonLogin() {
        $(".radius").click();
    }

    @And("Web page open with URL (.*)")
    public void webPageOpenWithURL(String URL) {
        webdriver().shouldHave(url(URL));
    }


}
