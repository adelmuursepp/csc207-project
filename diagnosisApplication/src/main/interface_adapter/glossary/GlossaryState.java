package main.interface_adapter.glossary;

import java.util.ArrayList;
import java.util.List;

public class GlossaryState {
    private static List<String> topics = new ArrayList<>();
    private String search = "";
    private String content = "";

    public GlossaryState() {}

    public static void setTopics(List<String> topics) {
        GlossaryState.topics = topics;
    }

    public static List<String> getTopics() {
        return topics;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
