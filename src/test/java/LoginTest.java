import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


class LoginTest extends DataFix {
    private final String loginPageUrl = property.getProperty("loginPageUrl");
    private final static String correctLogin = property.getProperty("correctLogin");
    private final static String correctPassword = property.getProperty("correctPassword1");
    private final String incorrectLogin = property.getProperty("incorrectLogin");
    private final String incorrectPassword = property.getProperty("incorrectPassword");

    @BeforeEach
    public void beforeTest() {
        open(loginPageUrl);
    }

    @Test
    public  void userCanLoginWithCorrectLoginAndCorrectPassword() {

        $("#username").setValue(correctLogin);
        $("#password").setValue(correctPassword).pressEnter();
        $(".example>a").isEnabled();

    }

    @Test
    public void userCanNotLoginWithInCorrectLoginAndInCorrectPassword() {
        $("#username").setValue(incorrectLogin);
        $("#password").setValue(incorrectPassword).pressEnter();
        $(".radius>i").isEnabled();
    }
}

