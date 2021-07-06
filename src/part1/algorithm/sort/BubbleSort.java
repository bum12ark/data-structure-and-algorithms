package part1.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

    /** 데이터가 두 개일 때 버블 정렬 알고리즘 방식으로 정렬해보세요 **/
    public void tryPracticeOne() {
        List<Integer> dataList = new ArrayList<>();
        dataList.add(10);
        dataList.add(5);
        if (dataList.get(0) > dataList.get(1)) {
            Collections.swap(dataList, 0, 1);
        }
    }

    /** 데이터가 세 개일 때 버블 정렬 알고리즘 방식으로 정렬해보세요 **/
    public void tryPracticeTwo() {
        List<Integer> dataList = new ArrayList<>();
        dataList.add(9);
        dataList.add(2);
        dataList.add(4);

        for (int index = 0; index < dataList.size() - 1; index++) {
            if (dataList.get(index) > dataList.get(index + 1)) {
                Collections.swap(dataList, index, index + 1);
            }
        }
    }

    /**
     * 데이터가 네 개일 때 버블 정렬 알고리즘 방식으로 정렬하는 방법에 대해 생각해보며,
     * 데이터 갯수에 상관없이 동작하는 버블 정렬 알고리즘 생각해보기
     */
    public List<Integer> sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            testData.add((int) (Math.random() * 100));
        }
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(bubbleSort.sort(testData));
    }
}
