package models.datalist;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.PageWithProductsList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductsDataList {

    private By productName = MobileBy.id("product_name");
    private By productPrice = MobileBy.id("product_price");
    private BasePage container;
    private LinkedHashMap<MobileElement, MobileElement> elements;


    public <T extends PageWithProductsList> ProductsDataList(T pageWithProductList) {
        this.container = pageWithProductList;
        elements = getElements();

    }

    public ArrayList<String> getProductNames() {
        return (ArrayList<String>) elements.keySet().stream().map(x -> x.getText()).collect(Collectors.toList());
    }

    public LinkedHashMap<MobileElement, MobileElement> getElements() {
        List<MobileElement> productNames = container.getDriver().findElements(productName);
        List<MobileElement> productPrices = container.getDriver().findElements(productPrice);
        return constructHashMap(productNames, productPrices);
    }

    public LinkedHashMap<MobileElement, MobileElement> constructHashMap(List<MobileElement> productNames, List<MobileElement> productPrices) {
        return IntStream.range(0, productNames.size())
                .collect(
                        LinkedHashMap::new,
                        (m, i) -> m.put(productNames.get(i), productPrices.get(i)),
                        LinkedHashMap::putAll);
    }
}
