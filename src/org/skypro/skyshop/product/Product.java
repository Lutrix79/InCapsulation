package org.skypro.skyshop.product;

public abstract class Product {

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
}
