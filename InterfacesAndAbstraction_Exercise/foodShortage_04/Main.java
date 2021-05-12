package foodShortage_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Buyer> register = new LinkedHashMap<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPeople; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 4) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                register.put(tokens[0], citizen);

            } else {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                register.put(tokens[0], rebel);
            }
        }
        String currentName = scanner.nextLine();
        while (!currentName.equals("End")) {

            if(register.containsKey(currentName)) {
                register.get(currentName).buyFood();
            }

            currentName = scanner.nextLine();
        }
        int totalAmountFood = register.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(totalAmountFood);
    }
}
