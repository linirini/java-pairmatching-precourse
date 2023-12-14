package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import pairmatching.domain.Pair;
import pairmatching.util.Course;
import pairmatching.util.Level;

public class PairRepository {

    HashMap<Level, List<Pair>> pairStorage;

    {
        pairStorage = new HashMap<>();
    }

    public void save(Level level, List<Pair> pairs) {
        if(pairStorage.containsKey(level)) {
            List<Pair> updatedPair = pairStorage.get(level);
            pairs.stream().forEach(pair -> updatedPair.add(pair));
            pairStorage.replace(level, updatedPair);
            return;
        }
        pairStorage.put(level,pairs);
    }

    public List<Pair> findAllByCourse(Course course) {
        return null;
    }

    public boolean isExistPair(Level level, Pair pair) {
        for (Pair storedPair : pairStorage.get(level)) {
            if (storedPair.getNames().stream().filter(name -> pair.getNames().contains(name))
                    .count() >= 2) {
                return true;
            }
        }
        return false;
    }

}
