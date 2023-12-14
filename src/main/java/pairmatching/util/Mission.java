package pairmatching.util;

public enum Mission {

    CAR_RACING("자동차 경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    SHOPPING_BAG("장바구니"),
    PAYMENT("결제"),
    SUBWAY_PATH("지하철노선도"),
    PERFORMANCE("성능개선"),
    DISTRIBUTION("배포"),
    NO_FEATURE("없음");


    private String viewName;

    Mission(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

}
