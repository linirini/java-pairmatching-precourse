package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class ShuffleMachine {

    private static final ShuffleMachine instance = new ShuffleMachine();

    public static ShuffleMachine getInstance() {
        return instance;
    }

    private ShuffleMachine() {
    }

    public List<String> shuffle(List<String> names) {
        return Randoms.shuffle(names);
    }

}
