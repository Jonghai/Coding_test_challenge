import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int studentNum = Integer.parseInt(firstLine[0]);
        int prizeNum = Integer.parseInt(firstLine[1]);

        String[] scoreString = reader.readLine().split(" ");

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < studentNum; i ++) {
            int score = Integer.parseInt(scoreString[i]);
            scores.add(score);
        }
        // 내림차순으로 정렬 후 상을 받는 사람 중
        // 가장 낮은 점수의 사람의 인덱스로 점수 값 가져오기 (상을 받을 수 있는 사람 수 -1)
        scores.sort(Comparator.reverseOrder());
        System.out.println(scores.get(prizeNum -1));
    }


}
