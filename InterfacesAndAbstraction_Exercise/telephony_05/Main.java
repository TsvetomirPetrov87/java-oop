package telephony_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> phoneNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::toString)
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> sites = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::toString)
                .collect(Collectors.toCollection(ArrayList::new));

        Smartphone smartphone = new Smartphone(phoneNumbers, sites);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}

