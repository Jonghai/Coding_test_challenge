import java.util.Scanner;

public class Main {

    static int[][] memo = new int[15][15];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int pair = sc.nextInt();

        for (int i = 0; i < pair; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(fibo(k, n));
        }


    }

    //피보나치 수열 계산하는 메서드
    static int fibo(int k, int n) {
        // 이미 계산된 값이 있으면 반환
        if (memo[k][n] != 0) return memo[k][n];

        // 종료조건
        if (k == 0) {
            return memo[k][n] = n;
        }
        if (n == 1) {
            return memo[k][n] = 1;
        }

        return memo[k][n] = fibo(k- 1, n) + fibo(k, n-1);
    }
}
