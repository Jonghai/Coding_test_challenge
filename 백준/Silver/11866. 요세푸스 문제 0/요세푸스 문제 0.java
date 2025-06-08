import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사람 수
        int k = sc.nextInt(); // K번째 제거

        List<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int index = 0;

        while (!people.isEmpty()) {
            index = (index + k - 1) % people.size();  // 다음 제거할 사람 위치
            result.add(people.remove(index));         // 제거 및 결과에 추가
        }

        // 결과 출력 포맷 <a, b, c, ...>
        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1)
                System.out.print(", ");
        }
        System.out.println(">");
    }
}
