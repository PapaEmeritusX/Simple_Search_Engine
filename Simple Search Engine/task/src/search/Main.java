package search;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (Objects.equals(args[0], "--data")) {
            String fileName = args[1];
            AppUI UI = new AppUI(scanner, fileName);
            UI.start();
        } else {
            System.out.println("No command line argument referring to a file ( i.e. --data fileName.txt");
        }

    }
}
