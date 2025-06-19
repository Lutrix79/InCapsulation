package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
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

        System.out.println("Проверка SearchEngine");
        SearchEngine searchEngines = new SearchEngine(15);

        searchEngines.add(new SimpleProduct("Яблоки", 85));
        searchEngines.add(new DiscountProduct("Груши", 100, 15));
        searchEngines.add(new DiscountProduct("Персики", 115, 30));
        searchEngines.add(new FixPriceProduct("Манго"));
        searchEngines.add(new FixPriceProduct("Манго"));
        searchEngines.add(new FixPriceProduct("Манго"));
        searchEngines.add(new FixPriceProduct("Манго"));
        searchEngines.add(new FixPriceProduct("Манго"));
        searchEngines.add(new FixPriceProduct("Манго"));
        searchEngines.add(new Article("О ПОЛЬЗЕ ЯБЛОК", "Научно доказано. Ни для кого не секрет, что яблоко помогло Ньютону открыть закон всемирного тяготения"));
        searchEngines.add(new Article("О ПОЛЬЗЕ ГРУШ", "Улучшение пищеварения. Клетчатка в составе груш нормализует работу кишечника, улучшает пищеварение."));
        searchEngines.add(new Article("О ПОЛЬЗЕ ПЕРСИКОВ", "Для сердечно-сосудистой системы. Антиоксиданты и минеральные вещества нормализуют кровяное давление, восстанавливают тонус стенок сосудов."));
        searchEngines.add(new Article("О ПОЛЬЗЕ МАНГО", "Повышение иммунитета. Высокое содержание витамина С усиливает эффективность лейкоцитов — белых клеток крови, которые повышают защитную функцию организма."));

        System.out.println(Arrays.toString(searchEngines.search("Яблок")));
        productBasket.delimiter();
        System.out.println(Arrays.toString(searchEngines.search("Ньютон")));
        productBasket.delimiter();
        System.out.println(Arrays.toString(searchEngines.search("ПОЛЬЗЕ")));
        productBasket.delimiter();
        System.out.println(Arrays.toString(searchEngines.search("adfgaehjjrsyj")));
        productBasket.delimiter();
        System.out.println(Arrays.toString(searchEngines.search("Манго")));
        productBasket.delimiter();

    }
}
