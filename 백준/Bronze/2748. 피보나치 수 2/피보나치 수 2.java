import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 피보나치 수를 저장할 배열
        long[] fibo = new long[n + 1];

        // 초기값 설정
        fibo[0] = 0;
        if (n > 0) fibo[1] = 1;

        // 피보나치 수 계산
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        System.out.println(fibo[n]);
    }
}
