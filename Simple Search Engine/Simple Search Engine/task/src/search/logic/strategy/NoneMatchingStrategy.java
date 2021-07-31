package search.logic.strategy;

import search.logic.SearchEngine;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class NoneMatchingStrategy implements MatchingStrategy{

    public static SortedSet<String> indices;
    @Override
    public void getResult(String[] query) {
        indices = new TreeSet<>();
        indices.addAll(SearchEngine.dataMap.keySet());

        for (String word : query) {
            List<String> wordIndices = SearchEngine.invertedIndexMap.get(word);
            indices.removeAll(wordIndices);
        }
        print(indices);
    }


}
