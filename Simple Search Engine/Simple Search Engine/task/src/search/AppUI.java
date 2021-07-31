package search;

import search.logic.*;
import search.logic.strategy.AllMatchingStrategy;
import search.logic.strategy.AnyMatchingStrategy;
import search.logic.strategy.NoneMatchingStrategy;
import search.logic.strategy.PeopleMatcher;

import java.util.Locale;
import java.util.Scanner;

public class AppUI {
    private final Scanner scanner;

    public AppUI(Scanner scanner, String fileName) {
        this.scanner = scanner;
        SearchEngine.initDataMap(fileName);
    }

    public void start() {
        appMenu();
    }

    private void appMenu() {
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");

            int input = Integer.parseInt(scanner.nextLine());
            System.out.println();

            PeopleMatcher matcher = null;

            switch (input) {
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String type = scanner.nextLine().toLowerCase();
                    switch (type) {
                        case "all":
                            matcher = new PeopleMatcher(new AllMatchingStrategy());
                            break;
                        case "any":
                            matcher = new PeopleMatcher(new AnyMatchingStrategy());
                            break;
                        case "none":
                            matcher = new PeopleMatcher(new NoneMatchingStrategy());
                            break;
                        default:
                            break;
                    }
                    if (matcher == null) {
                        throw new RuntimeException(
                                "Unknown strategy type passed. Please, write to the author of the problem.");
                    }
                    System.out.println("Enter a name or email to search all suitable people.");
                    String[] query = scanner.nextLine().toLowerCase().split("\\s+");

                    matcher.find(query);

                    System.out.println();
                    break;
                case 2:
                    System.out.println("=== List of people ===");
                    SearchEngine.printDataset();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.out.println();
                    return;
                default:
                    System.out.println("Incorrect option! Try again.");
                    System.out.println();
                    break;
            }
        }
    }

}
