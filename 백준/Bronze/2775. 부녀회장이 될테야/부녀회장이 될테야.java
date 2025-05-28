import java.util.Scanner;

public class Main {
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

        if (k == 0) {
            return n;
        }
        if (n == 1) {
            return 1;
        }

        return fibo(k- 1, n) + fibo(k, n-1);
    }
}
