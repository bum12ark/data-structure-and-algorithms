package algorithm.sort.review;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int pivot = list.get(0);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

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
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            testData.add((int) (Math.random() * 100));
        }
        System.out.println(quickSort.sort(testData));
    }
}
