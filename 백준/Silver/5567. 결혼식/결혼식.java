import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 총 인원
        int m = sc.nextInt(); // 친구 관계 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 친구 관계 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a); // 양방향
        }

        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>(); // [사람 번호, 깊이]
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int now = curr[0];
            int depth = curr[1];

            if (depth >= 2) continue; // 친구의 친구까지만

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, depth + 1});
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}