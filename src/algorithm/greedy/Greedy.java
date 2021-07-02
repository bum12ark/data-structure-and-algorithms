package algorithm.greedy;

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

    /** 부분 배낭 문제제 **/
    public void fractionalKnapsack(Integer[][] objectList, double capacity) {
        // objectList를 무게 / 물건 이 큰 순으로 표기하기
        for (Integer[] integers : objectList) {
            System.out.println((double) integers[1] / integers[0]);
        }

        Arrays.sort(objectList, (o1, o2) -> {
            double v1 = (double) o1[1] / o1[0];
            double v2 = (double) o1[1] / o1[0];
            return o1[0] - o2[1];
        });
        Arrays.stream(objectList).forEach(integers -> System.out.println(Arrays.toString(integers)));
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
                {10, 10},
                {10, 15},
                {10, 18}
        };
        greedy.fractionalKnapsack(objectList, 10);
    }
}
