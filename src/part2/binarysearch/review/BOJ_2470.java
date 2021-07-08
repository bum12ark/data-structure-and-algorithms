package part2.binarysearch.review;

import part2.common.FastReader;

import java.util.Arrays;

public class BOJ_2470 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int N;
    static int[] nums;

    static void input() {
        N = fastReader.nextInt();
        nums = new int[N];
        for (int n = 0; n < N; n++) nums[n] = fastReader.nextInt();
    }

    static int lowerBound(int[] array, int target, int left, int right) {
        // A[L...R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런게 없다면 R + 1 을 return 한다.
        int res = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    static void process() {
        // A 에 대해 이분 탐색을 할 예정이니까, 정렬을 미리 해주자.
        Arrays.sort(nums);

        int bestSum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int index = 0; index < N; index++) {
            // A[index] 용액을 쓸 것이다. 고로 -A[index]와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자.
            int candidate = lowerBound(nums, -nums[index], index + 1, N - 1);

            // A[candidate -1] 와 A[candidate] 중에서 A[index] 와 섞었을 때의 정보를 정답에 갱신시킨다.
            // candidate - 1 과 비교
            if (index < candidate - 1 && Math.abs(nums[index] + nums[candidate - 1]) < bestSum) {
                bestSum = Math.abs(nums[index] + nums[candidate - 1]);
                v1 = nums[index];
                v2 = nums[candidate - 1];
            }

            // candidate 와 비교
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
        process();
        System.out.println(sb.toString());

    }
}
