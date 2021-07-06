package part1.algorithm.greedy.review;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyReview {

    public int coinProblem(List<Integer> coins, int price) {
        int totalCount = 0;

        // 화폐 단위가 가장 큰 순으로 정렬
        coins.sort((o1, o2) -> Integer.compare(o2, o1));

        // greedy 알고리즘 적용
        for (int coin : coins) {
            int coinNum = price / coin;
            price -= coin * coinNum;
            totalCount += coinNum;
            System.out.println(coin + "원 동전: " + coinNum + "개");
        }
        return totalCount;
    }

    public double fractionalKnapsack(int[][] objectList, double capacity) {
        Arrays.sort(objectList, (o1, o2)
                -> Double.compare((double) o2[1] / o2[0],(double) o1[1] / o1[0]));
        System.out.println(Arrays.deepToString(objectList));

        double totalValue = 0;
        for (int[] object : objectList) {
            double weight = object[0];
            double value = object[1];

            if (capacity - weight > 0) {
                capacity -= weight;
                totalValue += value;
            } else {
                totalValue += (value / weight) * capacity;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        GreedyReview greedy = new GreedyReview();
        System.out.println("===========coinProblem===========");
        System.out.println(greedy.coinProblem(new ArrayList<>(Arrays.asList(1, 50, 100, 500)), 4720));

        System.out.println("===========coinProblem===========");
        int[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        System.out.println(greedy.fractionalKnapsack(objectList, 30.0));
    }
}
