package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Scanner;

public class App {
    private final static Scanner SCANNER = new Scanner(System.in);
    static ProductBasket productBasket = new ProductBasket();

    public static void main(String[] args) {
        productBasket.initBasket();
        System.out.println("Задача 1");
        System.out.println("Полная стоимость продуктов в корзине составляет "+ productBasket.calculateFullPriceBasket());
        Product product = new Product("Мандарины", 150);
        productBasket.addProductInBasket(product);
        System.out.println("Задача 2");
        productBasket.addProductInBasket(product);
        System.out.println("Задача 3");
        productBasket.printBasketContent();
        System.out.println("Задача 4");
        System.out.println("Полная стоимость продуктов в корзине составляет "+ productBasket.calculateFullPriceBasket());
        System.out.println("Задача 5");
        String productName = "Манго";
        productBasket.printResultSearch(productBasket.searchProduct(productName));
        System.out.println("Задача 6");
        productName = "Апельсины";
        productBasket.printResultSearch(productBasket.searchProduct(productName));
        System.out.println("Задача 7");
        productBasket.cleanBasket();
        System.out.println("Задача 8");
        productBasket.printBasketContent();
        System.out.println("Задача 9");
        System.out.println("Полная стоимость продуктов в корзине ссоставляет "+ productBasket.calculateFullPriceBasket());
        System.out.println("Задача 10");
        productName = "Манго";
        productBasket.printResultSearch(productBasket.searchProduct(productName));
    }
}
