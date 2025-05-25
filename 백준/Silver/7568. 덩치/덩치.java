import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            persons.add(new Person(weight, height));
        }


        // 키와 몸무게 둘 다 높은 사람이 있다면 place = 1
        for (int i = 0; i < persons.size(); i++) {
            int rank = 1; // 1등부터 시작

            for (int j = 0; j < persons.size(); j++) {
                if (i == j) continue;

                // i보다 키와 몸무게가 둘 다 큰 경우
                if (persons.get(i).weight < persons.get(j).weight &&
                        persons.get(i).height < persons.get(j).height) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }

    }

class Person {
    int weight;
    int height;

    Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}
