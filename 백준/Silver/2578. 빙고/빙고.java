import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 철수의 빙고판 생성
        Bingo bingo = new Bingo();
        for (int i = 0; i < 5; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo.setNumber(i, j, Integer.parseInt(line[j]));
            }
        }

        // 사회자가 부르는 숫자 리스트 입력
        List<Integer> callNumbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String[] line = reader.readLine().split(" ");
            for (String numStr : line) {
                callNumbers.add(Integer.parseInt(numStr));
            }
        }

        // 사회자가 숫자 부르기 시작
        for (int turn = 0; turn < callNumbers.size(); turn++) {
            int call = callNumbers.get(turn);
            bingo.mark(call);
            if (bingo.isBingo()) {
                System.out.println(turn + 1); // 문제에서 1부터 시작
                break;
            }
        }
    }
}

class Bingo {
    private final int[][] board = new int[5][5];
    private final boolean[][] marked = new boolean[5][5];

    // 숫자 설정
    public void setNumber(int row, int col, int num) {
        board[row][col] = num;
    }

    // 숫자 마킹
    public void mark(int num) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (board[i][j] == num) marked[i][j] = true;
    }

    // 빙고 개수 계산
    private int countBingo() {
        int count = 0;

        // 가로줄
        for (int i = 0; i < 5; i++) {
            boolean bingo = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) count++;
        }

        // 세로줄
        for (int j = 0; j < 5; j++) {
            boolean bingo = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) count++;
        }

        // 대각선 (\)
        boolean bingo1 = true;
        for (int i = 0; i < 5; i++)
            if (!marked[i][i]) bingo1 = false;
        if (bingo1) count++;

        // 대각선 (/)
        boolean bingo2 = true;
        for (int i = 0; i < 5; i++)
            if (!marked[i][4 - i]) bingo2 = false;
        if (bingo2) count++;

        return count;
    }

    // 3빙고 이상 여부
    public boolean isBingo() {
        return countBingo() >= 3;
    }
}
