package pizza_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokensPizza = scanner.nextLine().split("\\s+");

        try {
            Pizza pizza = new Pizza(tokensPizza[1], Integer.parseInt(tokensPizza[2]));

            String[] tokensDough = scanner.nextLine().split("\\s+");
            Dough dough = new Dough(tokensDough[1], tokensDough[2], Double.parseDouble(tokensDough[3]));
            pizza.setDough(dough);

            String commandTopping = scanner.nextLine();
            while (!commandTopping.equals("END")) {
                String[] tokensTopping = commandTopping.split("\\s+");
                Topping topping = new Topping(tokensTopping[1],Double.parseDouble(tokensTopping[2]));
                pizza.addTopping(topping);

                commandTopping = scanner.nextLine();
            }

            System.out.println(pizza.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
