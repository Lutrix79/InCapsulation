package org.skypro.skyshop.product;

public class SimpleProduct extends Product{

    private int priceOfProduct;

    public SimpleProduct(String nameOfProduct, int priceOfProduct) {
        super(nameOfProduct);
        this.priceOfProduct = priceOfProduct;
        if (priceOfProduct <= 0) {
            throw new IllegalArgumentException("Цены должна быть выше одного рубля");
        }
    }

    @Override
    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    @Override
    public String toString() {
        return nameOfProduct + ": " + getPriceOfProduct();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
