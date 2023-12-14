package pairmatching.util;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String viewName;

    Course(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }
}
