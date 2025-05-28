# [Bronze I] 부녀회장이 될테야 - 2775 

[문제 링크](https://www.acmicpc.net/problem/2775) 

### 성능 요약

메모리: 17512 KB, 시간: 224 ms

### 분류

수학, 다이나믹 프로그래밍

### 제출 일자

2025년 5월 28일 22:18:15

### 문제 설명

<p>평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.</p>

<p>이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.</p>

<p>아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.</p>

### 입력 

 <p>첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다</p>

### 출력 

 <p>각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.</p>

## 문제 이해
### 아파트 계약 규칙
- 0층 i 호에는 i명이 살고 있음.
- a층 b호에 살기 위해서는 아래층`(a-1층)`의 1호~b호까지 모든 사람들의 합을 데려와야 함.

### 입력
- 첫 줄: 테스트 케이스 수 **T**
- 이 후 각 케이스마다
	1. 층 수: **k** (0이상 14 이하)
	2. 호 수: n (0이상 14 이하)

### 출력
각 케이스에 대해 k층 n호에 사는 사람 수 출력

### 예시
0층: 1 2 3 4 ...  
1층 3호: 1층 1호 ~3호까지의 합 = 1 + 2 + 3 = 6

시간 제한: 0.5초


## 코드 설계

먼저 해당 문제에 대해 이해를 하고 피보나치 수열을 생각하여 점화식을 구함. <br>
#### => `f(k, n) = f(k-1, n) + f(k, n-1)`

#### 종료조건1: k가 0 일 때 n을 반환 (0층 일 때)
#### 종료조건2: n이 1일 때 1 반환(1호 일 때)

재귀를 도는데 종료조건 하나라도 빼먹으면 **StackOverflow 발생!**
### 첫 번째 코드
```java
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

```

### 개선 된 두 번째 코드 (메모이제이션 적용)

#### 메모이제이션
- 이미 계산한 결과를 저장(캐시) 하기
- 같은 값이 다시 필요할 때 저장된 값을 사용
- 증복 계산을 방지해서 속도 향상

```java
import java.util.Scanner;

public class Main {

    static int[][] memo = new int[15][15];

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
        // 이미 계산된 값이 있으면 반환
        if (memo[k][n] != 0) return memo[k][n];

        // 종료조건
        if (k == 0) {
            return memo[k][n] = n;
        }
        if (n == 1) {
            return memo[k][n] = 1;
        }

        return memo[k][n] = fibo(k- 1, n) + fibo(k, n-1);
    }
}
```

- 같은 `(k, n)` 에 대해 중복 호출 제거.
- 끝까지 재귀를 돌지 않고 이전에 계산한 값을 즉시 반환

첫번째 코드:  **352ms** <br>
두번째 코드(메모이제이션으로 개선): **224ms**

