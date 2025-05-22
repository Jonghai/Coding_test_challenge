import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        // 학생 정보를 담을 Map 생성
        Map<Integer, String> students = new HashMap<>();

        for (int i = 0; i < number; i ++) {
            // 첫번째 공백을 기준으로 문자열 두조각으로 나누기
            String[] student = reader.readLine().split(" ",2);
            String name = student[0];
            // "1 10 1991" 형식 -> 숫자 19911001로 변경
            int birthdaySum = birthdayToInt(student[1]);
            students.put(birthdaySum, name);
        }

        // key값을 List로 변환 후 max 값 찾기 = 나이가 가장 적은 사람
        int maxKey = Collections.max(students.keySet());
        // key값을 List로 변환 후 min 값 찾기 = 나이가 가장 많은 사람
        int minKey = Collections.min(students.keySet());

        // 찾은 생년월일(key) 값으로 이름(value) 출력
        System.out.println(students.get(maxKey));
        System.out.println(students.get(minKey));

    }

    static int birthdayToInt(String birthday) {
        String[] parts = birthday.split(" ");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        return (year * 10000) + (month * 100) + day;
    }

}
