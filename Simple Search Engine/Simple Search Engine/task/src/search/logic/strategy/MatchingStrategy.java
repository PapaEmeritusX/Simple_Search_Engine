package search.logic.strategy;

import search.logic.SearchEngine;
import java.util.SortedSet;

public interface MatchingStrategy {

    void getResult(String[] query);

    default void print(SortedSet<String> indices){
        boolean matchFound = false;

        if (indices != null) {
            System.out.println(indices.size() + " persons found:");
            for (String index : indices) {
                matchFound = true;
                System.out.println(SearchEngine.dataMap.get(index));

            }
        }
        if (!matchFound) {
            System.out.println("No matching people found.");
        }
    }
}
