package base;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import pages.BasePage;

public class BaseApplicationPage extends BasePage {

    protected By basketIcon = MobileBy.id("basket");

    protected BaseApplicationPage() {
        super();
    }
}
