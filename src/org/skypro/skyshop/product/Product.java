package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    protected String nameOfProduct;
//    private int priceOfProduct;

    public Product(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
//        this.priceOfProduct = priceOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public abstract int getPriceOfProduct();

    public abstract boolean isSpecial();

    @Override
    public String findSearchTerm() {
        return nameOfProduct;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return nameOfProduct;
    }
}
