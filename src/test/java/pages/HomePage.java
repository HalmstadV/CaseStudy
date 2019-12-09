package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By homePageBar = MobileBy.id("action_bar");

    public HomePage() {
        super();
    }

    public boolean isHomepageVisible() {
        return getAppiumClient().isElementVisible(homePageBar, 5);
    }
}
