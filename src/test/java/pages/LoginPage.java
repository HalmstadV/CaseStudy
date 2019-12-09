package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    private By emailBox = MobileBy.id("email");
    private By passwordBox = MobileBy.id("password");
    private By loginButton = MobileBy.id("email_sign_in_button");

    public void fillEmailBox(String email) {
        getAppiumClient().fillTextBox(emailBox, email);
    }

    public void fillPassword(String password) {
        getAppiumClient().fillTextBox(passwordBox, password);
    }

    public HomePage clickLoginButton() {
        getAppiumClient().click(loginButton);
        return new HomePage();
    }


}
