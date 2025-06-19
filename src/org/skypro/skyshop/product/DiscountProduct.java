package org.skypro.skyshop.product;

public class DiscountProduct extends Product {

    private int basePrice;
    private int discountInPercents;

    public DiscountProduct(String nameOfProduct, int basePrice, int discountInPercents) {
        super(nameOfProduct);
        this.basePrice = basePrice;
        this.discountInPercents = discountInPercents;
    }

    @Override
    public int getPriceOfProduct() {
        return basePrice - basePrice * discountInPercents / 100;
    }

    @Override
    public String toString() {
        return nameOfProduct + ": " + getPriceOfProduct() + " (" + discountInPercents+ "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

   }
