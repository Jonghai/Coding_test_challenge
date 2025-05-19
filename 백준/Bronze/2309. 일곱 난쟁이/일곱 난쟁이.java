import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> heights = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i <= 8; i ++) {
            int number = Integer.parseInt(reader.readLine());
            heights.add(number);
            sum += number;
        }
        Collections.sort(heights);
        int rest = sum - 100;
        List<Integer> removeNumList = new ArrayList<>();
        for (int num1 : heights) {
            int num2 = rest - num1;
            if (heights.contains(num2)) {
                removeNumList.add(num1);
                removeNumList.add(num2);
                break;
            }
        }
        heights.remove(removeNumList.get(0));
        heights.remove(removeNumList.get(1));
        for (int result : heights) {
            System.out.println(result);
        }

    }
}
