package algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

public class RecursiveCall {

    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n *factorial(n - 1);
    }

    /** 숫자가 들어 있는 배열이 주어졌을 때, 배열의 합을 리턴하는 코드를 작성해 보시오. **/
    public int arraySum(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        return list.get(0) + arraySum(new ArrayList<>(list.subList(1, list.size())));
    }

    /** 정수 n이 입력으로 주어졌을 때, n을 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구하시오 **/
    public int tryPracticeThird(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        return tryPracticeThird(n - 1) + tryPracticeThird(n - 2) + tryPracticeThird(n - 3);
    }

    public static void main(String[] args) {
        RecursiveCall recursiveCall = new RecursiveCall();
        // 1
        System.out.println("==========1=========");
        System.out.println(recursiveCall.factorial(4) + " " + "24");

        // 2
        System.out.println("==========2=========");
        List<Integer> testData = new ArrayList<>();
        for (int data = 0; data < 10; data++) {
            testData.add(data);
        }
        System.out.println(recursiveCall.arraySum(testData));

        // 3
        System.out.println("==========3=========");
        System.out.println(recursiveCall.tryPracticeThird(5));
    }
}
