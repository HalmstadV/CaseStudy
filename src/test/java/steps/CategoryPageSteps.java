package steps;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.When;
import models.client.AppiumClient;
import models.datalist.CategoriesDataList;
import pages.HomePage;

public class CategoryPageSteps {
    HomePage homePage = new HomePage();
    AppiumClient appiumClient = homePage.getAppiumClient();

    @When("i navigate to {string} category")
    public void iNavigateToCategory(String category) {
        CategoriesDataList categoriesDataList = new CategoriesDataList(homePage);
        MobileElement desiredCategory = categoriesDataList.getSpecificElement(category);
        appiumClient.click(desiredCategory);

    }
}
