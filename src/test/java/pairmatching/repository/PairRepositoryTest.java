package pairmatching.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.util.Level.LEVEL1;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.util.Course;

class PairRepositoryTest {

    private PairRepository pairRepository;

    @BeforeEach
    void init() {
        pairRepository = new PairRepository();
    }

    @Test
    void 이미_존재하는_페어() {
        pairRepository.save(LEVEL1, List.of(new Pair(
                        List.of(new Crew(Course.BACKEND, "가나"), new Crew(Course.BACKEND, "다라"))),
                new Pair(List.of(new Crew(Course.BACKEND, "사아"), new Crew(Course.BACKEND, "다라")))));
        assertThat(pairRepository.isExistPair(LEVEL1, new Pair(
                List.of(new Crew(Course.BACKEND, "가나"), new Crew(Course.BACKEND, "다라"),
                        new Crew(Course.BACKEND, "마바"))))).isTrue();
    }

}