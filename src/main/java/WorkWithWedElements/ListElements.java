package WorkWithWedElements;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListElements {

    @Name("username")
    @FindBy(css = "#username")
    public WebElement username;

    @Name("password")
    @FindBy(css = "#password")
    public WebElement password;

    @Name("loginButton")
    @FindBy(css = ".radius")
    public WebElement loginButton;

    @Name("logoutButton")
    @FindBy(css = ".button.secondary.radius")
    public WebElement logoutButton;

    @Name("checkbox")
    @FindBy(css="input[type=checkbox]")
    public SelenideElement checkbox;

    @Name("inputField")
    @FindBy(css="input[type='text']")
    public WebElement inputField;

    @Name("enable/disable button")
    @FindBy(css ="#input-example>button")
    public WebElement enableDisableButton;

    @Name("remove/add button")
    @FindBy(css = "button[type='button']")
    public WebElement removeOrAddButton;
}