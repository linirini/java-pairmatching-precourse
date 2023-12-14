package pairmatching.util;

import static pairmatching.util.Feature.BASEBALL;
import static pairmatching.util.Feature.CAR_RACING;
import static pairmatching.util.Feature.DISTRIBUTION;
import static pairmatching.util.Feature.LOTTO;
import static pairmatching.util.Feature.NO_FEATURE;
import static pairmatching.util.Feature.PAYMENT;
import static pairmatching.util.Feature.PERFORMANCE;
import static pairmatching.util.Feature.SHOPPING_BAG;
import static pairmatching.util.Feature.SUBWAY_PATH;

import java.util.List;

public enum Level {

    LEVEL1("레벨1", List.of(CAR_RACING, LOTTO, BASEBALL)),
    LEVEL2("레벨2", List.of(SHOPPING_BAG, PAYMENT, SUBWAY_PATH)),
    LEVEL3("레벨3", List.of(NO_FEATURE)),
    LEVEL4("레벨4", List.of(PERFORMANCE, DISTRIBUTION)),
    LEVEL5("레벨5", List.of(NO_FEATURE)),
    ;

    private String viewName;
    private List<Feature> features;

    Level(String viewName, List<Feature> features) {
        this.viewName = viewName;
        this.features = features;
    }

    public String getViewName() {
        return viewName;
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
