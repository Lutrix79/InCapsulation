package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{

    private final int fixPrice = 100;

    public FixPriceProduct(String nameOfProduct) {
        super(nameOfProduct);
    }

    @Override
    public int getPriceOfProduct() {
        return fixPrice;
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
