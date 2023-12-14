package pairmatching.service;

import java.util.List;
import pairmatching.domain.Pair;
import pairmatching.repository.PairRepository;
import pairmatching.util.Level;

public class PairService {

    private final PairRepository pairRepository = new PairRepository();

    public boolean isDuplicatedPairExists(Level level,List<Pair> pairs){
        for (Pair pair : pairs) {
            if(pairRepository.isExistPair(level,pair)){
                return true;
            }
        }
        return false;
    }

    public List<Pair> matchPair(){
        return null;
    }

}
