package part1.algorithm.sort.review;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public void split(List<Integer> list) {
        if (list.isEmpty()) {
            return;
        }
        int midIdx = list.size() / 2;
        List<Integer> leftList = new ArrayList<>(list.subList(0, midIdx));
        List<Integer> rightList = new ArrayList<>(list.subList(midIdx, list.size()));

        System.out.println(leftList);
        System.out.println(rightList);
    }

    public List<Integer> mergeSplit(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int midIdx = list.size() / 2;
        List<Integer> leftList = this.mergeSplit(list.subList(0, midIdx));
        List<Integer> rightList = this.mergeSplit(list.subList(midIdx, list.size()));

        return merge(leftList, rightList);
    }

    private List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        int leftPoint = 0;
        int rightPoint = 0;
        List<Integer> mergedList = new ArrayList<>();

        while (leftPoint < leftList.size() && rightPoint < rightList.size()) {
            int leftNum = leftList.get(leftPoint);
            int rightNum = rightList.get(rightPoint);
            if (leftNum < rightNum) {
                mergedList.add(leftNum);
                leftPoint++;
            } else {
                mergedList.add(rightNum);
                rightPoint++;
            }
        }

        while (leftPoint < leftList.size()) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        while (rightPoint < rightList.size()) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            testData.add((int) (Math.random() * 100));
        }
        System.out.println(mergeSort.mergeSplit(testData));
    }
}
