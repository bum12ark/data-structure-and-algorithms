package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {

    public List<Integer> sort(List<Integer> list) {
        for (int stand = 0; stand < list.size() - 1; stand++) {
            int min = stand;
            for (int index = stand + 1; index < list.size(); index++) {
                if (list.get(min) > list.get(index)) {
                    min = index;
                }
            }
            if (min > stand) {
                Collections.swap(list, min, stand);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            testData.add((int) (Math.random() * 100));
        }
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(selectionSort.sort(testData));
    }
}
