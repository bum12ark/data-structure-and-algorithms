package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertSort {

    public List<Integer> sort(List<Integer> list) {
        for (int keyIdx = 1; keyIdx < list.size(); keyIdx++) {
            int key = list.get(keyIdx);
            int prevIdx = keyIdx - 1;
            while (prevIdx >= 0 && list.get(prevIdx) > key) {
                list.set(prevIdx + 1, list.get(prevIdx));
                prevIdx--;
            }
            list.set(prevIdx + 1, key);
        }
        return list;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testData.add((int) (Math.random() * 100));
        }
        System.out.println(insertSort.sort(testData));
    }
}
