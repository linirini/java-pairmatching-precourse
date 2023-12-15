package pairmatching.service;

import java.util.List;
import pairmatching.domain.Pair;
import pairmatching.repository.PairRepository;
import pairmatching.util.Level;

public class PairService {

    private final PairRepository pairRepository = new PairRepository();

    public boolean isDuplicatedPairExists(Level level, List<Pair> pairs) {
        if (!pairRepository.isPairExistByLevel(level)) {
            return false;
        }
        List<Pair> storedPairs = pairRepository.getPairsByLevel(level);
        for (Pair pair : pairs) {
            if (isExistPair(storedPairs, pair)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistPair(List<Pair> storedPairs, Pair pair) {
        for (Pair storedPair : storedPairs) {
            if (storedPair.getNames().stream().filter(name -> pair.getNames().contains(name))
                    .count() >= 2) {
                return true;
            }
        }
        return false;
    }

    public List<Pair> matchPair() {
        
        return null;
    }

}
