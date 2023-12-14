package pairmatching.repository;

import static pairmatching.util.Level.LEVEL1;
import static pairmatching.util.Level.LEVEL2;
import static pairmatching.util.Level.LEVEL3;
import static pairmatching.util.Level.LEVEL4;
import static pairmatching.util.Level.LEVEL5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pairmatching.domain.Pair;
import pairmatching.util.Course;
import pairmatching.util.Level;

public class PairRepository {

    HashMap<Level, List<Pair>> pairStorage;

    {
        pairStorage = new HashMap<>();
        pairStorage.put(LEVEL1, new ArrayList<>());
        pairStorage.put(LEVEL2, new ArrayList<>());
        pairStorage.put(LEVEL3, new ArrayList<>());
        pairStorage.put(LEVEL4, new ArrayList<>());
        pairStorage.put(LEVEL5, new ArrayList<>());
    }

    public void save(Level level, List<Pair> pairs) {
        List<Pair> updatedPair = pairStorage.get(level);
        pairs.forEach(pair -> updatedPair.add(pair));
        pairStorage.replace(level, updatedPair);
        System.out.println("###"+pairStorage.get(level).size());
    }

    public boolean isExistPair(Level level, Pair pair) {
        System.out.println("###"+pairStorage.get(level).size());
        for (Pair storedPair : pairStorage.get(level)) {
            if (storedPair.getNames().stream().filter(name -> pair.getNames().contains(name))
                    .count() >= 2) {
                return true;
            }
        }
        return false;
    }

    public List<Pair> findAllByCourse(Course course) {
        return null;
    }

}
