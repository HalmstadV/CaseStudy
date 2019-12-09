package models.datalist;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.List;

public abstract class DataList {

    protected List<MobileElement> elements;
    protected BasePage container;
    protected By locator;

    public DataList(BasePage container, By locator) {
        this.container = container;
        this.locator = locator;
        elements = getElements();
    }

    public DataList(BasePage container) {
        this.container = container;
    }

    public abstract List<MobileElement> getElements();

    public MobileElement getSpecificElement(String name) {
        MobileElement foundElement = null;
        for (MobileElement element : elements) {
            if (element.getText().contentEquals(name)) {
                foundElement = element;
                break;
            }
        }
        return foundElement;

    }
}
