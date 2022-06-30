package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DynamicContentSteps {
    List<String> listOfContentBefore = new ArrayList<>();
    List<String> listOfContentAfter = new ArrayList<>();

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

    @Then("Save information from  the page")
    public void saveInformation() {
        if (listOfContentBefore.isEmpty()) {
            listOfContentBefore = saveInformationFromThePage();
        } else listOfContentAfter = saveInformationFromThePage();
    }

    @And("Checking for dynamic content")
    public void checkingForDynamicContent() {
        Assertions.assertFalse(listOfContentBefore.equals(listOfContentAfter));
    }
}
