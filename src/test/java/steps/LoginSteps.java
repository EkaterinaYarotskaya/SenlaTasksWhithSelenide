package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginSteps {
    @Given("Open website {string}")
    public void openWebsite(String URL) {
        open(URL);
    }

    @Then("User enters  login {string} and password {string}")
    public void userEntersLoginAndPasswords(String stringLogin, String stringPassword) {
        $("#username").setValue(stringLogin);
        $("#password").setValue(stringPassword);
    }

    @Then("Press button LOGIN")
    public void pressButtonLogin() {
        $(".radius").click();
    }

    @And("Web page open with URL {string}")
    public void webPageOpenWithURL(String URL) {
        webdriver().shouldHave(url(URL));
    }


    @And("Web page don`t open with URL {string}")
    public void webPageDonTOpenWithURL(String URL) {
        webdriver().shouldNotHave(url(URL));
    }
}
