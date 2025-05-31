import java.util.*;

public class Main {
    static int[] perm;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            perm = new int[N + 1];  
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                perm[i] = sc.nextInt();
            }

            int count = 0;

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        int next = perm[node];
        if (!visited[next]) {
            dfs(next);
        }
    }
}
