package pages;

import base.BaseApplicationPage;
import models.datalist.ProductsDataList;

import java.util.ArrayList;

public class PageWithProductsList extends BaseApplicationPage {

    private ProductsDataList productsDataList;

    public PageWithProductsList() {
        super();
        this.productsDataList = new ProductsDataList(this);
    }

    protected ArrayList<String> getProductNames() {
        return productsDataList.getProductNames();
    }


}
