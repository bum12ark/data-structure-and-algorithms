package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    /**
     * 1. 리스트를 맨 앞의 데이터를 기준으로 작은 데이터는 left 변수에 그렇지 않은 데이터는 right 변수에 넣기
     * 2. left, right, pivot 변수에 들어 있는 배열 아이템들을 하나의 배열로 정렬하여 출력해보기
     */
    public List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        int pivot = list.get(0);
        for (int index = 1; index < list.size(); index++) {
            int num = list.get(index);
            if (num < pivot) {
                leftList.add(num);
            } else {
                rightList.add(num);
            }
        }

        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(this.sort(leftList));
        mergedList.add(pivot);
        mergedList.addAll(this.sort(rightList));

        return mergedList;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testList.add((int) (Math.random() * 100));
        }
        System.out.println(quickSort.sort(testList));
    }
}
