package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{

    public FixPriceProduct(String nameOfProduct) {
        super(nameOfProduct);
    }

    @Override
    public int getPriceOfProduct() {
        return 100;
    }

    @Override
    public String toString() {
        return nameOfProduct + ": Фиксированая цена " + getPriceOfProduct();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
