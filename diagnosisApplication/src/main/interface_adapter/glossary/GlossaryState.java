package main.interface_adapter.glossary;

import java.util.List;

public class GlossaryState {
    private List<String> topics;

    public GlossaryState() {}

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getTopics() {
        return topics;
    }
}
