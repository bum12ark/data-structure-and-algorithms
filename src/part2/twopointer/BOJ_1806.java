package part2.twopointer;

public class BOJ_1806 {

    static int N, S;
    static int[] nums;

    static int pro() {
        int right = -1, sum = 0, ans = N + 1;
        for (int left = 0; left < N; left++) {
            // right 를 옮길 수 있을 때 까지 옮기기
            while (right + 1 < N && sum < S) {
                right++;
                sum += nums[right];
            }

            // [left ... right] 의 합, 즉 sum 이 조건을 만족하면 정답 갱신하기
            if (sum >= S) {
                ans = Math.min(ans, right - left + 1);
            }

            // left - 1 을 구간에서 제외하기
            sum -= nums[left];
        }
        // ans 값을 보고 불가능 판단하기기
        return ans == N + 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        N = 10;
        S = 15;
        nums = new int[] {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        System.out.println(pro());
    }
}
