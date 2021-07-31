package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fileName = args[1];
        AppUI UI = new AppUI(scanner, fileName);
        UI.start();
    }
}
