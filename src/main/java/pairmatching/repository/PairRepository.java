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

    public List<Pair> getPairsByLevel(Level level){
        return pairStorage.get(level);
    }

    public boolean isPairExistByLevel(Level level){
        return pairStorage.get(level).size()!=0;
    }

    public List<Pair> findAllByCourse(Course course) {
        return null;
    }

}
