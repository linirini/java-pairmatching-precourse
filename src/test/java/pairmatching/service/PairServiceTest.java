package pairmatching.service;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.util.Level.LEVEL1;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.repository.PairRepository;
import pairmatching.util.Course;

class PairServiceTest {

    private PairRepository pairRepository;
    private PairService pairService;


    @BeforeEach
    void init() {
        pairService = new PairService();
        pairRepository = new PairRepository();
        pairRepository.save(LEVEL1, List.of(new Pair(
                        List.of(new Crew(Course.BACKEND, "가나"), new Crew(Course.BACKEND, "다라"))),
                new Pair(List.of(new Crew(Course.BACKEND, "사아"), new Crew(Course.BACKEND, "다라")))));
    }

    @Test
    void 이미_존재하는_페어() {
        assertThat(pairService.isDuplicatedPairExists(LEVEL1, List.of(new Pair(
                List.of(new Crew(Course.BACKEND, "가나"), new Crew(Course.BACKEND, "다라"),
                        new Crew(Course.BACKEND, "마바")))))).isTrue();
    }

    @Test
    void 존재하지_않는_페어() {
        assertThat(pairService.isDuplicatedPairExists(LEVEL1, List.of(new Pair(
                List.of(new Crew(Course.BACKEND, "가자"), new Crew(Course.BACKEND, "다라"),
                        new Crew(Course.BACKEND, "마바")))))).isFalse();
    }

}