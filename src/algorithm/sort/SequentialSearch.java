package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class SequentialSearch {

    /** 임의의 배열이 있을 때, 원하는 데이터의 위치를 리턴하는 순차 탐색 알고리즘 작성해보기 **/
    public int search(List<Integer> list, int target) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index) == target) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequentialSearch sequentialSearch = new SequentialSearch();
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testData.add((int) (Math.random() * 100));
        }
        System.out.println(testData);
        System.out.println(sequentialSearch.search(testData, 99));
    }
}
