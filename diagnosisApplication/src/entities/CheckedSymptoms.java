package entities;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class CheckedSymptoms {
    public final Map<String, Boolean> checkedSymptoms = new HashMap<>();

    public CheckedSymptoms() {

        checkedSymptoms.put("symptom1", false);
    }

}
