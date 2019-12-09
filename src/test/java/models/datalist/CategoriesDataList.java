package models.datalist;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pages.BasePage;

import java.util.List;

public class CategoriesDataList extends DataList {


    public <T extends BasePage> CategoriesDataList(T t) {
        super(t, MobileBy.id("category_name"));
    }

    @Override
    public List<MobileElement> getElements() {
        return container.getDriver().findElements(locator);
    }
}
