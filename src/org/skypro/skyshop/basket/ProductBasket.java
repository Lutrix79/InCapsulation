package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {

    private final ArrayList <Product> productBasket = new ArrayList<>();

    public void initBasket() {
        productBasket.add(new SimpleProduct("Яблоки", 85));
        productBasket.add(new DiscountProduct("Груши", 100, 15));
        productBasket.add(new DiscountProduct("Персики", 115, 30));
        productBasket.add(new FixPriceProduct("Манго"));
    }

    public void addProductInBasket(Product product) {
        productBasket.add(product);
    }

    public int calculateFullPriceBasket() {
        int sum = 0;
        for (Product product : productBasket) {
            sum += product.getPriceOfProduct();
        }
        return sum;
    }

    public void printBasketContent() {
        int i = 0;
        int specialProductsCounter = 0;
        for (Product product : productBasket) {
            i++;
            System.out.println(product.getNameOfProduct());
            if (product.isSpecial()){
                specialProductsCounter++;
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
        for (Product product : productBasket) {
            if (product != null && product.getNameOfProduct().equals(productName)) {
                productInBasket = true;
                break;
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
        };
    }

    public ArrayList <Product> searchAndDeleteProducts (String name){
        ArrayList<Product> products = new ArrayList<>();
        Iterator <Product> iterator = productBasket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getNameOfProduct().equals(name)) {
                products.add(product);
                iterator.remove();
            }
        }
        return products;
    }

    public void delimiter() {
        System.out.println("***********************************");
    }
}
