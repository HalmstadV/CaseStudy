package pages;

import io.appium.java_client.MobileBy;
import models.client.AppiumClient;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static constants.Keywords.PRODUCT_REMOVED_FROM_CART;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPage extends PageWithProductsList {

    private By deleteCartIcon = MobileBy.id("imageview_remove");
    private By cartTotalPrice = MobileBy.id("total_price");
    private By emptyCartText = MobileBy.id("empty_textview");

    public CartPage() {
        super();
    }


    public void clearCart() {
        ArrayList<String> productNames = getProductNames();
        for (String productName : productNames) {
            getDriver().findElement(deleteCartIcon).click();
            assertThat("When a user deletes a product from cart, appropriate text should be visible on page.",
                    getAppiumClient().isTextVisibleInsidePageSource(String.format(PRODUCT_REMOVED_FROM_CART, productName)));

        }

    }


    public static BaseMatcher<CartPage> cartShouldBeEmpty() {
        return new BaseMatcher<CartPage>() {
            @Override
            public boolean matches(Object o) {
                CartPage cartPage = (CartPage) o;
                AppiumClient appiumClient = cartPage.getAppiumClient();

                boolean isEmptyCartTextVisible = appiumClient.isElementVisible(cartPage.emptyCartText, 5);
                boolean isEmptyCartTextCorrect = appiumClient.doesTextAppearInsideLocator(cartPage.emptyCartText, "Your card is empty!");
                boolean isTotalPriceZeroTL = appiumClient.doesTextAppearInsideLocator(cartPage.cartTotalPrice, "0.0 TL");

                return isEmptyCartTextCorrect && isEmptyCartTextVisible && isTotalPriceZeroTL;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Cart should be empty");

            }
        };
    }
}
