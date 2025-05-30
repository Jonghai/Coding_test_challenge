import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 0; // 1은 이미 1이므로 연산 필요없음

        for (int i = 2; i <= n; i++) {
            // 1 빼기
            dp[i] = dp[i - 1] + 1;

            // 2로 나누기
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            // 3으로 나누기
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[n]);
    }
}
