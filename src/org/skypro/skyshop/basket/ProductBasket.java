package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {

    private final Product [] productBasket = new Product[5];

    public void initBasket() {
        productBasket[0] = new Product("Яблоки", 85);
        productBasket[1] = new Product("Груши", 100);
        productBasket[2] = new Product("Персики", 115);
        productBasket[3] = new Product("Манго", 120);
    }

    public void addProductInBasket(Product product) {
        boolean freePlace = false;
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                System.out.println("Продукт добавлен");
                freePlace = true;
                break;
            }
        }
        if (!freePlace){
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int calculateFullPriceBasket() {
        int i = 0;
        int sum = 0;
        while (i < productBasket.length && productBasket[i] != null) {
            sum += productBasket[i].getPriceOfProduct();
            i++;
        }
        return sum;
    }

    public void printBasketContent() {
        int i = 0;
        while (i < productBasket.length && productBasket[i] != null) {
            System.out.println(productBasket[i].getNameOfProduct() + ": " + productBasket[i].getPriceOfProduct());
            i++;
        }
        if (i == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Общая стоимость корзины " + calculateFullPriceBasket());
        }
    }

    public boolean searchProduct(String productName) {
        boolean productInBasket = false;
        for (Product product : productBasket) {
            if (product != null && product.getNameOfProduct().equals(productName)) {
                productInBasket = true;
                break;
            }
        }
        return productInBasket;
    }

    public void cleanBasket() {
        Arrays.fill(productBasket, null);
    }

    public void printResultSearch(boolean resultSearch) {
        if (resultSearch){
            System.out.println("Продукт найден");
        } else {
            System.out.println("Продукт не найден");
        };
    }
}
