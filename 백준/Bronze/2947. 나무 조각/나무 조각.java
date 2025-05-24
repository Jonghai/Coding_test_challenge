import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" ");
        int[] numbers = new int[5];
        for (int i = 0; i  < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        while (true) {
            boolean swapped = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                int firstNum = numbers[i];
                int secondNum = numbers[i + 1];
                if (firstNum > secondNum) {
                    numbers[i] = secondNum;
                    numbers[i + 1] = firstNum;
                    printNumbers(numbers);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    static void printNumbers(int[] numbers) {
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
