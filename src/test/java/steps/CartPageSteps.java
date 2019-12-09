package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.client.AppiumClient;
import pages.CartPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static pages.CartPage.cartShouldBeEmpty;

public class CartPageSteps {
    CartPage cartPage = new CartPage();
    AppiumClient appiumClient = cartPage.getAppiumClient();

    @And("delete every product from card")
    public void deleteEveryProductFromCard() {
        cartPage.clearCart();
    }

    @Then("i expect to see that product card is empty")
    public void iExpectToSeeThatProductCardIsEmpty() {
        assertThat("When client clears basket, ", cartPage, cartShouldBeEmpty());

    }
}
