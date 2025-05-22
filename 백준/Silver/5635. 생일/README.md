# [Silver V] 생일 - 5635 

[문제 링크](https://www.acmicpc.net/problem/5635) 

### 성능 요약

메모리: 13980 KB, 시간: 100 ms

### 분류

구현, 정렬, 문자열

### 제출 일자

2025년 5월 22일 23:04:25

### 문제 설명

<p>어떤 반에 있는 학생들의 생일이 주어졌을 때, 가장 나이가 적은 사람과 가장 많은 사람을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 반에 있는 학생의 수 n이 주어진다. (1 ≤ n ≤ 100)</p>

<p>다음 n개 줄에는 각 학생의 이름과 생일이 "이름 dd mm yyyy"와 같은 형식으로 주어진다. 이름은 그 학생의 이름이며, 최대 15글자로 이루어져 있다. dd mm yyyy는 생일 일, 월, 연도이다. (1990 ≤ yyyy ≤ 2010, 1 ≤ mm ≤ 12, 1 ≤ dd ≤ 31) 주어지는 생일은 올바른 날짜이며, 연, 월 일은 0으로 시작하지 않는다.</p>

<p>이름이 같거나, 생일이 같은 사람은 없다.</p>

### 출력 

 <p>첫째 줄에 가장 나이가 적은 사람의 이름, 둘째 줄에 가장 나이가 많은 사람 이름을 출력한다.</p>


## 문제 이해
1. 첫째 줄에 반 학생 수 N개 입력 (1 ≤ n ≤ 100)
2.  N줄에는 각 학생의 이름과 생일이 주어짐.
	Ex) 이름 dd mm yyyy
3. 이름이 같거나, 생일이 같은 사람은 없다.

## 코드 설계
가장 먼저 든 생각
- 주어진 한 라인의 정보를 첫번째 공백을 기준으로 이름과 생일을 나눈다.
- 생년월일을 공백을 기준으로 또 나눈 후 String -> Integer로 타입 변경
- 생년월일을 모두 더한 값을 저장.
- 생년월일을 모두 더 한 값의 max : 나이가 가장 적은 사람 이름 출력
- 생년월일을 모두 더한 값의 min: 나이가 가장 많은 사람 이름 출력

자료구조는?
이름이 같거나 생일이 같은 사람은 없다고 했으니 Map을 사용하기로 결정.
Map의 Key 값을 더한 생년월일 값.
value를 이름으로 담은 후 Key값 정렬하기

```java
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
  
        int number = Integer.parseInt(reader.readLine());  
  
        Map<Integer, String> students = new HashMap<>();  
  
        for (int i = 0; i < number; i ++) {  
            String[] student = reader.readLine().split(" ");  
            String name = student[0];  
            int birthdaySum = sumOfNumbersInString(student[1]);  
            students.put(birthdaySum, name);  
        }  
  
        int maxKey = Collections.max(students.keySet());  
        int minKey = Collections.min(students.keySet());  
  
        System.out.println(students.get(maxKey));  
        System.out.println(students.get(minKey));  
  
    }  
  
    static int sumOfNumbersInString(String birthday) {  
        String[] date = birthday.split(" ");  
        int sum = 0;  
        for (int i = 0; i < date.length; i++) {  
            sum += Integer.parseInt(date[i]);  
        }  
        return sum;  
    }  
  
}
```

잘못 생각했다.....
다 더하면 당연히 잘못 된 결과가 나올 수 밖에 없다...
A: `5 7 1990` = 2002
B: `1 1 1991` = 1993
year가 1만 차이 나도 day와 month 가 더해져서 원하는 값이 나오지 않아 정렬 불가능.

### 최종 해결 코드 설계
아래와 같은 방법으로 자리수를 더해 int 타입의 yyyymmdd 형식으로 만들기
`(year * 10000) + (month * 100) + day;`

### 최종 코드
```java
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
  
        int number = Integer.parseInt(reader.readLine());  
  
        // 학생 정보를 담을 Map 생성  
        Map<Integer, String> students = new HashMap<>();  
  
        for (int i = 0; i < number; i ++) {  
            // 첫번째 공백을 기준으로 문자열 두조각으로 나누기  
            String[] student = reader.readLine().split(" ",2);  
            String name = student[0];  
            // "1 10 1991" 형식 -> 숫자 19911001로 변경  
            int birthdaySum = birthdayToInt(student[1]);  
            students.put(birthdaySum, name);  
        }  
  
        // key값을 List로 변환 후 max 값 찾기 = 나이가 가장 적은 사람  
        int maxKey = Collections.max(students.keySet());  
        // key값을 List로 변환 후 min 값 찾기 = 나이가 가장 많은 사람  
        int minKey = Collections.min(students.keySet());  
  
        // 찾은 생년월일(key) 값으로 이름(value) 출력  
        System.out.println(students.get(maxKey));  
        System.out.println(students.get(minKey));  
  
    }  
  
    static int birthdayToInt(String birthday) {  
        String[] parts = birthday.split(" ");  
        int day = Integer.parseInt(parts[0]);  
        int month = Integer.parseInt(parts[1]);  
        int year = Integer.parseInt(parts[2]);  
  
        return (year * 10000) + (month * 100) + day;  
    }  
  
}
```


