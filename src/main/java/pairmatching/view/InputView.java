package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static pairmatching.util.Course.BACKEND;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import pairmatching.util.Course;

public class InputView {

    private static final String BACKEND_CREW = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW = "src/main/resources/frontend-crew.md";

    public String inputOption() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        return readLine();
    }

    public String inputCrewByCourse(Course course) {
        try {
            return getCrews(course);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    private static String getCrews(Course course) throws IOException {
        FileReader reader = getFilePathByCourse(course);
        int data;
        StringBuilder input = new StringBuilder();
        while ((data = reader.read()) != -1) {
            input.append((char) data);
        }
        return input.toString();
    }

    private static FileReader getFilePathByCourse(Course course) throws FileNotFoundException {
        if (course == BACKEND) {
            return new FileReader(BACKEND_CREW);
        }
        return new FileReader(FRONTEND_CREW);
    }

    public String inputPairInformation() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        return readLine();
    }

    public String inputRePair() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        return readLine();
    }

}
