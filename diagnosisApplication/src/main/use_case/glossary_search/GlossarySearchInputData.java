package main.use_case.glossary_search;

public class GlossarySearchInputData {
    private final String search;
    public GlossarySearchInputData(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }
}
