import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] distance;
    static int N, start, end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // 전체 사람 수
        start = sc.nextInt();  // 촌수 계산할 사람1
        end = sc.nextInt();    // 촌수 계산할 사람2
        int M = sc.nextInt();  // 관계 수

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 부모-자식 관계 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        // BFS로 촌수 계산
        int result = bfs(start, end);
        System.out.println(result);
    }

    static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph[curr]) {
                if (distance[next] == -1) {
                    distance[next] = distance[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        return distance[target];
    }
}