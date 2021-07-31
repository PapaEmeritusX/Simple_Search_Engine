package search.logic.strategy;

import search.logic.SearchEngine;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class AnyMatchingStrategy implements MatchingStrategy {

    public static SortedSet<String> indices;
    @Override
    public void getResult(String[] query) {

        indices = new TreeSet<>();
        for (String word : query) {
            List<String> wordIndices = SearchEngine.invertedIndexMap.get(word);
            indices.addAll(wordIndices);

        }
        print(indices);
    }

}
