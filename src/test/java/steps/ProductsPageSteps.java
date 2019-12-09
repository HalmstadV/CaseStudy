package steps;

import io.cucumber.java.en.And;
import models.client.AppiumClient;
import org.hamcrest.MatcherAssert;
import pages.ProductsPage;

import static constants.Keywords.PRODUCT_ADDED_TO_CART;

public class ProductsPageSteps {

    ProductsPage productsPage = new ProductsPage();
    AppiumClient appiumClient = productsPage.getAppiumClient();

    @And("i add a {string} to card")
    public void iAddAToCard(String productName) {
        productsPage.addProductToCart(productName);
        MatcherAssert.assertThat("Product should be added to cart",
                appiumClient.isTextVisibleInsidePageSource(PRODUCT_ADDED_TO_CART));


    }

    @And("i navigate back from category")
    public void iNavigateBackFromCategory() {
        productsPage.navigateBack();
    }

    @And("i navigate to cart page")
    public void iNavigateToCartPage() {
        productsPage.goToCartPage();
    }
}
