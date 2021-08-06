package part2.dp.practice;

import part2.common.FastReader;

/* 이친수 */
public class BOJ_2193 {
    static FastReader fastReader = new FastReader();

    static final int ZERO = 0; // 마지막에 0이 오는 횟수
    static final int ONE = 1; // 마지막에 1이 오는 횟수
    static int N; // 이친수의 자리 수
    static long[][] dp;
    static long ans;

    static void input() {
        N = fastReader.nextInt();
        dp = new long[N + 1][2];
    }

    static void process() {
        dp[1][ZERO] = 0;
        dp[1][ONE] = 1;

        for (int index = 2; index <= N; index++) {
            dp[index][ZERO] = dp[index - 1][ZERO] + dp[index - 1][ONE];
            dp[index][ONE] = dp[index - 1][ZERO];
        }

        // 정답 출력
        ans = dp[N][ZERO] + dp[N][ONE];
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
