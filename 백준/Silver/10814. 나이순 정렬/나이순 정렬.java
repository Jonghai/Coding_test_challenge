import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Member {
        int index;
        int age;

        String name;

        public Member(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 회원 수 입력 받기
        int number = Integer.parseInt(reader.readLine());

        List<Member> members = new ArrayList<>();

        // 2. 회원 나이, 이름 입력 받기
        for (int i = 0; i < number; i++) {
            // 한 라인 읽기
            String line = reader.readLine();

            // 공백을 구분으로 문자열 자르기
            String[] strings = line.split(" ",2);
            int age = Integer.parseInt(strings[0]);
            String name = strings[1];
            //Member 클래스 생성 후 members 리스트에 저장.
            members.add(new Member(i,age,name));

        }

        // 먼저 age를 기준으로 정렬, age가 같으면 index 기준으로 정렬.
        members.sort(Comparator.comparingInt((Member m) -> m.age)
                .thenComparingInt(m -> m.index));

        // 정렬 된 Member 리스트에서 나이, 이름 순서대로 출력
        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }

    }
}
