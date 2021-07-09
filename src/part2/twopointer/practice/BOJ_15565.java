package part2.twopointer.practice;

import part2.common.FastReader;

public class BOJ_15565 {
    static FastReader fastReader = new FastReader();

    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        nums = new int[N];
        for (int n = 0; n < N; n++) nums[n] = fastReader.nextInt();
    }

    static int N, K;
    static int[] nums;

    static int pro() {
        int right = -1, sum = 0, ans = N + 1;
        for (int left = 0; left < N; left++) {
            // right 값 이동 가능 한 곳 까지 이동
            // 라이언 | 어피치 확인 연산 필요
            while (right < N - 1 && sum < K) {
                right += 1;
                if (nums[right] == 1) {
                    sum++;
                }
            }

            // K 까지 찾았을 경우 최소 길이 비교
            if (sum == K) {
                ans = Math.min(ans, right - left + 1);
            }

            // left 값 이동 전 라이언 | 어피치 확인 연산 필요
            if (nums[left] == 1) {
                sum--;
            }
        }

        return ans == N + 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        input();
        int answer = pro();
        System.out.println(answer);
    }
}
