package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> productBasket = new TreeMap<>();
    //создаём списки продуктов
    private final List <Product> apples = new ArrayList<>();
    private final List <Product> pears = new ArrayList<>();
    private final List <Product> peaches = new ArrayList<>();
    private final List <Product> mangoes = new ArrayList<>();
    private final List <Product> oranges = new ArrayList<>();


    public void initBasket() {
        apples.add(new FixPriceProduct("Свежий урожай"));
        apples.add(new DiscountProduct("Антоновка", 85, 15));
        apples.add(new SimpleProduct("Золотой налив", 150));
        productBasket.put("Яблоки", apples);
        pears.add(new FixPriceProduct("Конференс"));
        pears.add(new DiscountProduct("Вильямс", 90, 20));
        pears.add(new SimpleProduct("Аббат", 130));
        productBasket.put("Груши", pears);
        peaches.add(new FixPriceProduct("Золотой триумф"));
        peaches.add(new DiscountProduct("Посол мира", 100, 10));
        peaches.add(new SimpleProduct("Донецкий белый", 180));
        productBasket.put("Персики", peaches);
        mangoes.add(new FixPriceProduct("Дункан"));
        mangoes.add(new DiscountProduct("Карабао", 150, 12));
        mangoes.add(new SimpleProduct("Альфонсо", 200));
        productBasket.put("Манго", mangoes);
        oranges.add(new FixPriceProduct("Валенсия"));
        oranges.add(new DiscountProduct("Гамлин", 145, 25));
        oranges.add(new SimpleProduct("Аджарский", 220));
        productBasket.put("Апельсины", oranges);
    }

    public void addProductInBasket(Product product) {
        if (product == null){
            throw new  IllegalArgumentException ("Продукт не может быть нулевым");
        }
        productBasket.computeIfAbsent(product.getNameOfProduct(), k -> new ArrayList<>()).add(product);
    }

    public int calculateFullPriceBasket() {
        int sum = 0;
        for (List<Product> products: productBasket.values()) {
            for (Product product : products) {
                sum += product.getPriceOfProduct();
            }
        }
        return sum;
    }

    public void printBasketContent() {
        int i = 0;
        int specialProductsCounter = 0;
        for (List<Product> products: productBasket.values()) {
            for (Product product : products) {
                i++;
                System.out.println(product.getNameOfProduct());
                if (product.isSpecial()) {
                    specialProductsCounter++;
                }
            }
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
        for (List<Product> products: productBasket.values()) {
            for (Product product : products) {
                if (product != null && product.getNameOfProduct().equals(productName)) {
                    productInBasket = true;
                    break;
                }
            }
        }
        return productInBasket;
    }

    public void cleanBasket() {
        productBasket.clear();
        System.out.println("Корзина очищена");
    }

    public void printResultSearch(boolean resultSearch) {
        if (resultSearch){
            System.out.println("Продукт найден");
        } else {
            System.out.println("Продукт не найден");
        }
    }

    public List <Product> searchAndDeleteProducts (String name){
        List<Product> products = new ArrayList<>();
        for (List<Product> productDelete: productBasket.values()) {
            Iterator<Product> iterator = productDelete.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product != null && product.getNameOfProduct().equals(name)) {
                    products.add(product);
                    iterator.remove();
                }
            }
        }
        return products;
    }

    public void delimiter() {
        System.out.println("***********************************");
    }
}
