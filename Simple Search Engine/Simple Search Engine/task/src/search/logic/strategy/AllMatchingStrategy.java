package search.logic.strategy;

import search.logic.SearchEngine;
import java.util.*;

public class AllMatchingStrategy implements MatchingStrategy {

    public static SortedSet<String> indices;

    @Override
    public void getResult(String[] query) {
        indices = new TreeSet<>();

        for (String word : query) {
            List<String> wordIndices = SearchEngine.invertedIndexMap.get(word);
            if (wordIndices != null) {
                if (indices.isEmpty()) {
                    indices.addAll(wordIndices);
                }
                indices.retainAll(wordIndices);
            }
        }
        print(indices);
    }



}


