package shoppingSpree_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!NameValidator.isValid(name)) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (!AmountValidator.isNonNegative(money)) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if(this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
    }

    public String getName() {
        return this.name;
    }

    @Override

    public String toString() {

        String productsOutput = this.products.isEmpty() ? "Nothing bought"
                : this.products.stream().map(Product::getName).collect(Collectors.joining(", "));
        return this.name + " - " + productsOutput;
    }
}
