package part1.algorithm.greedy;

import java.util.*;

public class Greedy {
    /**
     * 지불해야 하는 값이 4720원 일 때 1원, 50원, 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오.
     * 가장 큰 동전부터 최대한 지불하여 값을 채우는 방식으로 구현 가능
     * 탐욕 알고리즘으로 매순간 최적이라고 생각되는 경우를 선택
     */
    public void getCoins(int price, List<Integer> coinList) {
        coinList.sort(Collections.reverseOrder());
        int totalCoinCount = 0;
        for (int coinUnit : coinList) {
            int coinCont = price / coinUnit;
            price -= coinUnit * coinCont;
            totalCoinCount += coinCont;

            System.out.println(coinUnit + "원: " + coinCont + "개");
        }
        System.out.println("총 동전 개수: "+totalCoinCount);
    }

    /** 부분 배낭 문제 **/
    public double fractionalKnapsack(Integer[][] objectList, double capacity) {
        // 개당 가치가 높은 순서대로 정렬
        Arrays.sort(objectList, (integers1, integers2)
                -> Double.compare((double) integers2[1] / integers2[0], (double) integers1[1] / integers1[0]));

        double totalValue = 0;
        for (Integer[] integers : objectList) {
            double weight = integers[0];
            double value = integers[1];

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
        Greedy greedy = new Greedy();
        // getCoins
        System.out.println("=======getCoins=========");
        List<Integer> coinList = new ArrayList<>(Arrays.asList(500, 100, 50, 1));
        greedy.getCoins(4720, coinList);

        // fractionalKnapsack
        System.out.println("=======fractionalKnapsack=========");
        Integer[][] objectList = {
                {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}
        };

        System.out.println(greedy.fractionalKnapsack(objectList, 30.0));
    }
}
