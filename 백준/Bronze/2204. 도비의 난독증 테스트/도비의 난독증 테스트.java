import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;

            List<String> words = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                words.add(sc.nextLine());
            }

            // 대소문자 무시하고 정렬
            words.sort(String.CASE_INSENSITIVE_ORDER);

            // 정렬 후 첫 번째 단어 출력 (원래 대소문자 유지)
            System.out.println(words.get(0));
        }

        sc.close();
    }
}