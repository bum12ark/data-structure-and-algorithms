package part2.binarysearch.review;

import java.util.Arrays;

public class Practice {
    // X 이하의 원소 중에서 가장 오른쪽에 있는 원소 고르기
    private int binarySearch(int[] array, int target, int left, int right) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int result = left - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        int X = 58; // 63
        int[] nums = {72, 19, 38, 58, 10, 92, 18, 11, 87};
        System.out.println(practice.binarySearch(nums, X, 0, nums.length - 1));
    }
}
