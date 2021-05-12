package pizza_04;

import java.util.Map;

public class Topping {
    private static final Map<String, Double> TOPPING_TYPES_AND_MODIFIERS =
            Map.of("Meat", 1.2, "Veggies", 0.8, "Cheese", 1.1, "Sauce", 0.9);

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!TOPPING_TYPES_AND_MODIFIERS.containsKey(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return TOPPING_TYPES_AND_MODIFIERS.get(this.toppingType) * 2 * this.weight;
    }
}
