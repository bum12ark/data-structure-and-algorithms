package part2.dp;

import part2.common.FastReader;

import java.util.Arrays;


/* 계단 오르기 */
public class BOJ_2579 {
    static FastReader fastReader = new FastReader();

    static int N, ans;
    static int[] stairs;
    static int[][] dp;

    static void input() {
        N = fastReader.nextInt();
        dp = new int[N + 1][2];
        stairs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = fastReader.nextInt();
        }
    }

    static void process() {
        dp[1][0] = 0;
        dp[1][1] = stairs[1];

        if (N >= 2) {
            dp[2][0] = stairs[2];
            dp[2][1] = stairs[1] + stairs[2];
        }

        for (int index = 3; index <= N; index++) {
            dp[index][0] = Math.max(dp[index - 2][0], dp[index - 2][1]) + stairs[index];
            dp[index][1] = dp[index - 1][0] + stairs[index];

        }
        ans = Math.max(dp[N][0], dp[N][1]);
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(ans);
    }
}
