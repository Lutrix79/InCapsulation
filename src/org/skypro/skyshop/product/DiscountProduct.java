package org.skypro.skyshop.product;

public class DiscountProduct extends Product {

    private int basePrice;
    private int discountInPercents;

    public DiscountProduct(String nameOfProduct, int basePrice, int discountInPercents) {
        super(nameOfProduct);
        this.basePrice = basePrice;
        this.discountInPercents = discountInPercents;
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цены должна быть выше одного рубля");
        }
        if (discountInPercents < 0 || discountInPercents > 100) {
            throw new IllegalArgumentException("Процент должен быть числом в диапазоне от 0 до 100 включительно");
        }
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
