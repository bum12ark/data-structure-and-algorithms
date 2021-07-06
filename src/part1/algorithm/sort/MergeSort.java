package part1.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    //** 배열을 앞뒤 두 배열로 짜르는 코드 작성해보기 **/
    public List<Integer> splitArray(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int midIdx = list.size() / 2;

        List<Integer> leftArray = splitArray(list.subList(0, midIdx));
        List<Integer> rightArray = splitArray(list.subList(midIdx, list.size()));

        return mergeArray(leftArray, rightArray);
    }

    public List<Integer> mergeArray(List<Integer> leftArray, List<Integer> rightArray) {
        List<Integer> mergeData = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        while (leftPoint < leftArray.size() && rightPoint < rightArray.size()) {
            int leftNum = leftArray.get(leftPoint);
            int rightNum = rightArray.get(rightPoint);

            if (leftNum > rightNum) {
                mergeData.add(rightNum);
                rightPoint++;
            } else {
                mergeData.add(leftNum);
                leftPoint++;
            }

        }

        while (leftPoint < leftArray.size()) {
            mergeData.add(leftArray.get(leftPoint));
            leftPoint++;
        }

        while (rightPoint < rightArray.size()) {
            mergeData.add((rightArray.get(rightPoint)));
            rightPoint++;
        }

        return mergeData;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            testData.add((int) (Math.random() * 100));
        }
        System.out.println(mergeSort.splitArray(testData));
    }
}
