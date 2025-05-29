import java.util.Scanner;

public class Main {
    static long[][] memo = new long[30][30];  // 최대 크기 30

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(combi(M, N));
        }
    }

    // 조합 계산 (메모이제이션)
    static long combi(int n, int r) {
        if (n == r || r == 0) return 1;

        if (memo[n][r] != 0) return memo[n][r];

        // nCr = n-1Cr-1 + n-1Cr
        return memo[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
}