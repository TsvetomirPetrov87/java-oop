package pizza_04;

import java.util.Map;

public class Dough {

    private static final Map<String, Double> DOUGH_FLOUR_TYPES_AND_MODIFIERS =
            Map.of("White", 1.5, "Wholegrain", 1.0);

    private static final Map<String, Double> DOUGH_BACKING_TYPES_AND_MODIFIERS =
            Map.of("Crispy", 0.9, "Chewy", 1.1, "Homemade", 1.0);

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String backingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(backingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!DOUGH_FLOUR_TYPES_AND_MODIFIERS.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw  new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!DOUGH_BACKING_TYPES_AND_MODIFIERS.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return 2 * this.weight * DOUGH_FLOUR_TYPES_AND_MODIFIERS.get(this.flourType)
                * DOUGH_BACKING_TYPES_AND_MODIFIERS.get(this.bakingTechnique);
    }
}