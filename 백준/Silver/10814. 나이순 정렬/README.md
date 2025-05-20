# [Silver V] 나이순 정렬 - 10814 

[문제 링크](https://www.acmicpc.net/problem/10814) 

### 성능 요약

메모리: 63456 KB, 시간: 1300 ms

### 분류

정렬

### 제출 일자

2025년 5월 20일 23:26:45

### 문제 설명

<p>온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)</p>

<p>둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.</p>

### 출력 

 <p>첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.</p>


## 문제 이해
1.  첫째 줄에 온라인 저지 회원의 수 N 개.
2. 둘째 줄 부터 N개의 줄에는 회원의 나이, 이름이 공백으로 구분 되어 주어진다.
3. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수.
4. 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
5. 입력 순서 = 가입한 순서
6. 나이가 같으면 가입한 순이 우선으로 출력한다.
7. 한 줄에 한명씩 나이와 이름을 공백으로 구분하여 출력한다.


## 코드 설계

초반엔 바로 이름과 나이를 공백으로 분리해서 map에 저장을 해야겠다고 생각을 했었다.
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i <= number; i++) {
            // 한 라인 읽기
            String line = reader.readLine();
            // 공백을 기준으로 문자열 자르기
            String[] lines = line.split(" ",2);

            // 나이 추출
            int age = Integer.parseInt(lines[0]);
            // 이름 추출
            String name = lines[1];

            map.put(age,name);
        }
    }
}
```

작성하다 나이가 Key값이 되면 안된다는 것을 인지함.
그렇다면 이름을 Key 값으로 한다면? 문제에는 상관없을 것 같지만...
가입이라는 기능의 목적을 생각한다면 무조건 동일한 나이와 동명이인 있을 수 있기 때문에 자료구조 Map을 사용하지 않기로 결정.

그렇다면 순서가 보장되는 list로 한 줄 씩 저장하는 방법을 생각하게 됨.

두번째 코드 설계 방향

### 2. List의 Index를 이용한 방법(실패)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 회원 수 입력 받기
        int number = Integer.parseInt(reader.readLine());

        List<Integer> ages = new ArrayList<>();
        List<String> names = new ArrayList<>();

        // 2. 회원 나이, 이름 입력 받기
        for (int i = 0; i < number; i++) {
            // 한 라인 읽기
            String line = reader.readLine();

            // 공백을 구분으로 문자열 자르기
            String[] strings = line.split(" ",2);

            // 나이 리스트, 이름 리스트에 순서대로 저장
            ages.add(Integer.parseInt(strings[0]));
            names.add(strings[1]);
        }

        // 3. 나이 리스트 또는 이름 리스트가 비어있을 때 까지 순회하며 값 출력
        while (!ages.isEmpty() || !names.isEmpty()) {
            // 나이가 가장 작은 값의 인덱스 추출
            int minValue = Collections.min(ages); // O(N)
            int minValueIndex = ages.indexOf(minValue); // O(N)

            // 추출한 인덱스 값으로 나이, 이름 출력
            System.out.println(minValue + " " + names.get(minValueIndex));

            // 출력한 값 제거
            ages.remove(minValueIndex); 
            names.remove(minValueIndex);
        }

    }
}
```

하지만 시간 초과....

### 원인 분석
```java
int minValue = Collections.min(ages); // O(N)
int minValueIndex = ages.indexOf(minValue); // O(N)
```

매번 `ages` 리스트 전체를 순회하면서 **최솟값을 찾고** 또 다시 **인덱스를 찾음.**
`remove()` 할 때도 리스트가 다시 이동하게 됨.

총 시간복잡도: **O(N²)**

시간복잡도를 너무 생각 안함...

## 3. 클래스 + Sort + Comparator 사용 (해결)

기존에 작성하던 코드는 나이와 이름을 각각의 리스트로 따로 관리하던 방법은 정렬이나 동기화가 어렵고 느리기 때문에 클래스를 작성하여 DTO나 VO 같이 사용하기.
### `Collections.sort()`
Java의 `Collections.sort()`는 내부적으로 **TimSort**를 사용하며 
시간복잡도는 평균/최악 **O(N log N)**

### `thenComparingInt()`
1차 기준이 같을 때 2차 기준으로 정렬하는 메서드
```java
members.sort(
    Comparator.comparingInt((Member m) -> m.age)
              .thenComparingInt(m -> m.index)
);
```

### 객체 생성비용은 괜찮은가?
=> 3개의 필드를 갖는 단순한 데이터 객체는 힙에 할당될 뿐 특별히 무겁지 않다.

### 최종 코드
```java
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
```
