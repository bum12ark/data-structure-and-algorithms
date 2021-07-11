package part2.twopointer;

import java.util.Arrays;

public class BOJ_13144 {

    static int N;
    static int[] nums, cnt;


    static void pro() {
        long ans = 0;
        for (int left = 1, right = 0; left <= N; left++) {
            // R 을 옮길 수 있는 만큼 옮긴다.
            while (right + 1 <= N && cnt[nums[right + 1]] < 1) {
                right += 1;
                cnt[nums[right]] += 1;
            }

            // 정답을 갱신한다.
            ans += right - left + 1;

            // L 을 옮겨주면서 A[L] 의 개수를 감소시킨다.
            cnt[nums[left]] -= 1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        N = 5;
        cnt = new int[100000 + 1];
        nums = new int[] {0, 1, 2, 3, 1, 2};
        pro();
    }
}
