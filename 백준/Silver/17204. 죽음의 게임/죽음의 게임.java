import java.util.*;

public class Main {
    static int[] a;
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        // 가능한 M 찾기
        for (int m = 1; m <= N; m++) {
            int curr = 0;
            for (int cnt = 1; cnt < m; cnt++) {
                curr = a[curr];
            }
            if (curr == K) {
                System.out.println(m -1);
                return;
            }
        }

        System.out.println(-1);
    }
}
