package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class DynamicContentSteps {
    List<String> listOfContentBefore = new ArrayList<>();
    List<String> listOfContentAfter = new ArrayList<>();

//    @Given("Open web {string}")
//    public void openWeb(String URL) {
//        open(URL);
//    }

    public List saveInformationFromThePage() {
        List<String> listOfContent = new ArrayList<>();
        List<SelenideElement> elementList = $$("#content>.row");

        elementList.forEach(a ->
        {
            listOfContent.add(a.$(By.tagName("img")).getAttribute("src"));
            listOfContent.add(a.$(By.cssSelector("#content>.row >.large-10")).getText());
        });

        return listOfContent;
    }

    @Then("Save information from  the page before")
    public List saveInformationFromThePageBefore() {
        return listOfContentBefore = saveInformationFromThePage();
    }

    @Then("Click on button click here")
    public void clickOnButton() {
        $("#content > div > p:nth-child(3) > a").click();
    }

    @Then("Save information from  the page after")
    public List saveInformationFromThePageAfter() {
        return listOfContentAfter=saveInformationFromThePage();
    }

    @And("Checking for dynamic content")
    public void checkingForDynamicContent() {
        Assertions.assertFalse(listOfContentBefore.equals(listOfContentAfter));

    }


}
