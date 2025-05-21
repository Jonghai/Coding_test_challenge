# [Silver V] 단어 정렬 - 1181 

[문제 링크](https://www.acmicpc.net/problem/1181) 

### 성능 요약

메모리: 23260 KB, 시간: 464 ms

### 분류

문자열, 정렬

### 제출 일자

2025년 5월 21일 22:22:51

### 문제 설명

<p>알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.</p>

<ol>
	<li>길이가 짧은 것부터</li>
	<li>길이가 같으면 사전 순으로</li>
</ol>

<p>단, 중복된 단어는 하나만 남기고 제거해야 한다.</p>

### 입력 

 <p>첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.</p>

### 출력 

 <p>조건에 따라 정렬하여 단어들을 출력한다.</p>

## 문제 이해
1. 알파벳 소문자로 이루어진 N개의 단어
2. 길이가 짧은 것부터 정렬
3. 길이가 같으면 사전순으로 정렬
4. 중복제거
5. 첫째줄에 단어의 개수 N 입력
6. N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩

## 코드 설계
1.  한 줄 씩 단어 입력 받기.
2. 단어의 길이를 구할 수 있는 함수가 필요. => String `length()`
3. 알파벳을 사전순으로 정렬할 수 있는 함수 필요 => `Comparator.naturalOrder()`
4. 어제 문제처럼 두가지 정렬 조건을 만족해야함. => `sort.thenComparing()`
5. 단어 중복 제거 => `Set` 사용

### `Comparator.naturalOrder()`
자연 순서(오름차순)를 기준으로 정렬하는 `Comparator`를 리턴하는 정적 메서드

## 최종 코드

```java
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.*;  
  
public class Main {  
    public static void main(String[] args) throws IOException {  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
  
        int number = Integer.parseInt(reader.readLine());  
  
        // 중복을 제거하면서 단어들을 저장 할 HashSet 생성  
        Set<String> wordSet = new HashSet<>();  
  
        for (int i = 0; i < number; i ++) {  
            String word = reader.readLine();  
  
            wordSet.add(word); // set에 단어 저장  
        }  
  
        // 정렬을 위해 HashSet -> List로 변환  
        List<String> wordList = new ArrayList<>(wordSet);  
  
        // 1차: 문자열 길이로 정렬, 2치: 알파벳 순으로 정렬  
        wordList.sort(Comparator.comparingInt(String::length)  
                .thenComparing(Comparator.naturalOrder()));  
  
        for (String word : wordList) {  
            System.out.println(word);  
        }  
    }  
  
}
```
