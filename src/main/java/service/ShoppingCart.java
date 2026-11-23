package service;

import model.Food;

public class ShoppingCart {
    private final Food[] products;

    public ShoppingCart(Food[] products) {
        this.products = products;
    }

    public double getTotalWithoutDiscount() {
        double total = 0.0;
        /*
        Изначально хождение по циклу было вида
        for (int i = 0; i < products.length; i++) {
            Food product = products[i];
        Но IDEA предложила красивый вариант
         */
        for (Food product : products) {
            total += product.getAmount() * product.getPrice();
        }
        return total;
    }

    public double getTotalWithDiscount() {
        double total = 0.0;
        for (Food product : products) {
            double productTotal = product.getAmount() * product.getPrice();
            total += productTotal - productTotal * product.getDiscount() / 100.0;
        }
        return total;
    }

    public double getVegetarianTotalWithoutDiscount() {
        double total = 0.0;
        for (Food product : products) {
            if (product.isVegetarian()) {
                total += product.getAmount() * product.getPrice();
            }
        }
        return total;
    }
}