package shoppingSpree_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        String[] inputPersons = scanner.nextLine().split(";");
        for (String item : inputPersons) {
            int index = item.indexOf("=");
            String name = item.substring(0, index);
            double money = Double.parseDouble(item.substring(index + 1, item.length()));

            try {
                Person person = new Person(name, money);
                personList.add(person);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                break;
            }
        }

        List<Product> productList = new ArrayList<>();
        String[] inputProducts = scanner.nextLine().split(";");
        for (String item : inputProducts) {
            int index = item.indexOf("=");
            String name = item.substring(0, index);
            double cost = Double.parseDouble(item.substring(index + 1, item.length()));

            try {
                Product product = new Product(name, cost);
                productList.add(product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                break;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];

            for (Person p : personList) {
              if(p.getName().equals(personName)) {
                  try {

                      Product product1 = productList.stream()
                              .filter(product -> product.getName().equals(productName))
                              .findFirst()
                              .orElseThrow(Exception::new);

                      p.buyProduct(product1);
                      System.out.println(personName + " bought " + productName);
                  } catch (IllegalArgumentException ex) {
                      System.out.println(ex.getMessage());
                  }
              }
            }
            command = scanner.nextLine();
        }
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}
