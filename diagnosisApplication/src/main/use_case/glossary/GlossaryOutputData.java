package main.use_case.glossary;

import java.util.List;

public class GlossaryOutputData {
    private final List<String> topics;

    public GlossaryOutputData(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getTopics() {
        return topics;
    }
}
