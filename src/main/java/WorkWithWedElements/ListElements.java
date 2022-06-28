package WorkWithWedElements;

import jdk.jfr.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import javax.annotation.Resource;

public class ListElements {

    @Name( "username")
    @FindBy(css = "#username")
    public WebElement username;

    @Name("password")
    @FindBy(css = "#password")
    public WebElement password;

    @Name("loginButton")
    @FindBy(css = ".radius")
    public WebElement loginButton;

    @Name("logoutButton")
    @FindBy(css=".button.secondary.radius")
    public WebElement logoutButton;
}
