package part2.binarysearch;

import part2.common.FastReader;

import java.util.Arrays;

public class BOJ_2470 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static void input() {
        N = fastReader.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = fastReader.nextInt();
    }

    static int N;
    static int[] nums;

    // array[left...right] 에서 target 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
    // 그런게 없다면 right + 1 을 return 한다.
    static int lowerBound(int[] array, int target, int left, int right) {
        int result = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    static void solution() {
        // 이분 탐색을 위한 오름차순 정렬
        Arrays.sort(nums);

        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int index = 0; index < N; index++) {
            int candidate = lowerBound(nums, -nums[index], index + 1, N - 1);

            // 1. nums[index] + nums[candidate - 1]
            int prevSum = Math.abs(nums[index] + nums[candidate - 1]);
            if (index < candidate - 1 && prevSum < bestSum) {
                bestSum = prevSum;
                v1 = nums[index];
                v2 = nums[candidate - 1];
            }

            // 2. nums[index] + nums[candidate]
            if (candidate < N && Math.abs(nums[index] + nums[candidate]) < bestSum) {
                bestSum = Math.abs(nums[index] + nums[candidate]);
                v1 = nums[index];
                v2 = nums[candidate];
            }
        }
        sb.append(v1).append(" ").append(v2);
    }

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(sb.toString());
    }
}
