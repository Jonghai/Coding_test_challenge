import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        // 중복을 제거하면서 단어들을 저장 할 HashSet 생성
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < number; i ++) {
            String word = reader.readLine();

            wordSet.add(word); // set에 단어 저장
        }

        // 정렬을 위해 HashSet -> List로 변환
        List<String> wordList = new ArrayList<>(wordSet);

        // 1차: 문자열 길이로 정렬, 2치: 알파벳 순으로 정렬
        wordList.sort(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));

        for (String word : wordList) {
            System.out.println(word);
        }
    }

}
