package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private List<Crew> crews;

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Crew crew : crews) {
            names.add(crew.getName());
        }
        return names;
    }

}
