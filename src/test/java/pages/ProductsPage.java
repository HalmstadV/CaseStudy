package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.datalist.ProductsDataList;
import org.openqa.selenium.By;

import java.util.HashMap;

public class ProductsPage extends PageWithProductsList {

    private By backIcon = MobileBy.AccessibilityId("Navigate up");
    public By productAddedPopup = MobileBy.xpath("//*[contains(@text,'Product added to shopping cart!')]");


    public ProductsPage() {
        super();
    }

    public void addProductToCart(String name) {
        ProductsDataList productsDataList = new ProductsDataList(this);
        HashMap<MobileElement, MobileElement> products = productsDataList.getElements();
        products.keySet()
                .stream()
                .filter((k) -> k.getText().contentEquals(name))
                .forEach(MobileElement::click);
    }

    public void navigateBack() {
        getAppiumClient().click(backIcon);
    }

    public void goToCartPage() {
        getAppiumClient().click(basketIcon);
    }


}
