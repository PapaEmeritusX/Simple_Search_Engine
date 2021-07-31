package search.logic;

import java.io.File;
import java.util.*;

public abstract class SearchEngine {

    public static Map<String, String> dataMap;
    public static Map<String, ArrayList<String>> invertedIndexMap;

    public static void initDataMap(String fileName) {

        dataMap = new HashMap<>();

        File file = new File(fileName);
        int count = 0;
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                dataMap.put( count++ + "", fileScanner.nextLine());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        initInvertedIndexMap(dataMap);
    }

    private static void initInvertedIndexMap(Map<String, String> map) {
        invertedIndexMap = new HashMap<>();

        for (var entry: map.entrySet()) {
            String[] words = entry.getValue().split(" ");
            for (String word: words) {
                String lowWord = word.toLowerCase();
                invertedIndexMap.putIfAbsent(lowWord, new ArrayList<>());
                invertedIndexMap.get(lowWord).add(entry.getKey());
            }
        }
    }

    public static void printDataset() {
        for (String line: dataMap.values()) {
            System.out.println(line);
        }
    }

}
