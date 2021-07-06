package part2.binarysearch;

public class Practice {
    // x 이하의 왼소 중에 가장 오른쪽에 있는 원소를 출력하라
    public int binarySearch(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < x) {
                result = nums[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        int[] nums = {10, 11, 18, 19, 38, 58, 72, 87, 92};
        System.out.println(practice.binarySearch(nums, 63));
    }
}
