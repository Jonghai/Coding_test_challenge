import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람 수

        int[][] cards = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                cards[i][j] = sc.nextInt();
            }
        }

        int winner = 0;
        int maxDigit = -1;

        for (int i = 0; i < n; i++) {
            int best = 0;

            // 3장 선택 조합
            for (int a = 0; a < 5; a++) {
                for (int b = a + 1; b < 5; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = cards[i][a] + cards[i][b] + cards[i][c];
                        int digit = sum % 10;
                        if (digit >= best) best = digit;
                    }
                }
            }

            // 가장 큰 값이면 갱신 (번호가 큰 사람 우선)
            if (best >= maxDigit) {
                maxDigit = best;
                winner = i + 1; // 1-based index
            }
        }

        System.out.println(winner);
    }
}