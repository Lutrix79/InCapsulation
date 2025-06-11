package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class ProductBasket {

    private final Product [] productBasket = new Product[5];

    public void initBasket() {
        productBasket[0] = new SimpleProduct("Яблоки", 85);
        productBasket[1] = new DiscountProduct("Груши", 100, 15);
        productBasket[2] = new DiscountProduct("Персики", 115, 30);
        productBasket[3] = new FixPriceProduct("Манго");
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
        int specialProductsCounter = 0;
        while (i < productBasket.length && productBasket[i] != null) {
            System.out.println(productBasket[i]);
            if (productBasket[i].isSpecial()){
                specialProductsCounter++;
            }
            i++;
        }
        if (i == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + calculateFullPriceBasket());
        }
        System.out.println("Специальных товаров: " + specialProductsCounter);
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
        System.out.println("Корзина очищена");
    }

    public void printResultSearch(boolean resultSearch) {
        if (resultSearch){
            System.out.println("Продукт найден");
        } else {
            System.out.println("Продукт не найден");
        };
    }

    public void delimiter() {
        System.out.println("***********************************");
    }
}
