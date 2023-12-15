package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.ShuffleMachine;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;
import pairmatching.util.Course;
import pairmatching.util.Level;

public class PairService {

    private final CrewRepository crewRepository = new CrewRepository();
    private final PairRepository pairRepository = new PairRepository();
    private final ShuffleMachine shuffleMachine = ShuffleMachine.getInstance();

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

    public List<Pair> matchPairInCourse(List<String> names, Course course) {
        return getPairs(shuffleMachine.shuffle(names),course);
    }

    private List<Pair> getPairs(List<String> names,Course course) {
        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<names.size();i+=2){
            List<Crew> crews = getCrews(names,course,i);
            if(isNamesCountOdd(names) && isLastPair(names, pairs)){
                crews.add(crewRepository.getCrewByCourseAndName(course,names.get(i+2)));
            }
            pairs.add(new Pair(crews));
        }
        return pairs;
    }

    private static boolean isNamesCountOdd(List<String> names) {
        return names.size() % 2 != 0;
    }

    private static boolean isLastPair(List<String> names, List<Pair> pairs) {
        return pairs.size() == names.size() / 2;
    }

    private List<Crew> getCrews(List<String> names, Course course, int index) {
        List<Crew> crews = new ArrayList<>();
        crews.add(crewRepository.getCrewByCourseAndName(course,names.get(index)));
        crews.add(crewRepository.getCrewByCourseAndName(course,names.get(index+1)));

        return crews;
    }

}
