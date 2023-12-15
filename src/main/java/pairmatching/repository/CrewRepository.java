package pairmatching.repository;

import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.util.Course;

public class CrewRepository {

    private List<Crew> crewStorage;

    public void save(Crew crew){
        crewStorage.add(crew);
    }

    public Crew getCrewByCourseAndName(Course course, String name){
        return crewStorage.stream().filter(crew -> crew.getName()==name&&crew.getCourse()==course).findAny().get();
    }

}
