package search.logic.strategy;

public class PeopleMatcher {

    private MatchingStrategy method;

    public PeopleMatcher(MatchingStrategy method) {
        this.method = method;
    }

    public void find(String[] query) {
        this.method.getResult(query);
    }
}
