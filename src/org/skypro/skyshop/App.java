package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Scanner;

public class App {
    private final static Scanner SCANNER = new Scanner(System.in);
    static ProductBasket productBasket = new ProductBasket();

    public static void main(String[] args) {

        productBasket.initBasket();

        productBasket.delimiter();
        System.out.println("Задача 1");
        System.out.println("Полная стоимость продуктов в корзине составляет "+ productBasket.calculateFullPriceBasket());
        Product product = new SimpleProduct("Мандарины", 150);
        productBasket.addProductInBasket(product);

        productBasket.delimiter();
        System.out.println("Задача 2");
        productBasket.addProductInBasket(product);

        productBasket.delimiter();
        System.out.println("Задача 3");
        productBasket.printBasketContent();

        productBasket.delimiter();
        System.out.println("Задача 4");
        System.out.println("Полная стоимость продуктов в корзине составляет "+ productBasket.calculateFullPriceBasket());

        productBasket.delimiter();
        System.out.println("Задача 5");
        String productName = "Манго";
        productBasket.printResultSearch(productBasket.searchProduct(productName));

        productBasket.delimiter();
        System.out.println("Задача 6");
        productName = "Апельсины";
        productBasket.printResultSearch(productBasket.searchProduct(productName));

        productBasket.delimiter();
        System.out.println("Задача 7");
        productBasket.cleanBasket();

        productBasket.delimiter();
        System.out.println("Задача 8");
        productBasket.printBasketContent();

        productBasket.delimiter();
        System.out.println("Задача 9");
        System.out.println("Полная стоимость продуктов в корзине составляет "+ productBasket.calculateFullPriceBasket());

        productBasket.delimiter();
        System.out.println("Задача 10");
        productName = "Манго";
        productBasket.printResultSearch(productBasket.searchProduct(productName));
        productBasket.delimiter();
    }
}
