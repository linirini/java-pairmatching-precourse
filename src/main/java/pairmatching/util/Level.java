package pairmatching.util;

import static pairmatching.util.Mission.BASEBALL;
import static pairmatching.util.Mission.CAR_RACING;
import static pairmatching.util.Mission.DISTRIBUTION;
import static pairmatching.util.Mission.LOTTO;
import static pairmatching.util.Mission.NO_FEATURE;
import static pairmatching.util.Mission.PAYMENT;
import static pairmatching.util.Mission.PERFORMANCE;
import static pairmatching.util.Mission.SHOPPING_BAG;
import static pairmatching.util.Mission.SUBWAY_PATH;

import java.util.List;

public enum Level {

    LEVEL1("레벨1", List.of(CAR_RACING, LOTTO, BASEBALL)),
    LEVEL2("레벨2", List.of(SHOPPING_BAG, PAYMENT, SUBWAY_PATH)),
    LEVEL3("레벨3", List.of(NO_FEATURE)),
    LEVEL4("레벨4", List.of(PERFORMANCE, DISTRIBUTION)),
    LEVEL5("레벨5", List.of(NO_FEATURE)),
    ;

    private String viewName;
    private List<Mission> features;

    Level(String viewName, List<Mission> features) {
        this.viewName = viewName;
        this.features = features;
    }

    public String getViewName() {
        return viewName;
    }

    public List<Mission> getFeatures() {
        return features;
    }
}
