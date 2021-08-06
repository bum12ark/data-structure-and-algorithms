package part2.dp.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 스티커 */
public class BOJ_9465 {
    static FastReader fastReader = new FastReader();

    static final int FIRST_ROW = 0;
    static final int SECOND_ROW = 1;
    static int T, N, ans; // 테스크 케이스의 개수, 열의 수
    static int[][] sticker, dp;

    static void input() {
        N = fastReader.nextInt();
        dp = new int[N][2];
        sticker = new int[N][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                sticker[j][i] = fastReader.nextInt();
            }
        }
    }

    static void process() {
        dp[0][FIRST_ROW] = sticker[0][0];
        dp[0][SECOND_ROW] = sticker[0][1];

        if (N >= 2) {
            dp[1][FIRST_ROW] = sticker[0][SECOND_ROW] + sticker[1][FIRST_ROW];
            dp[1][SECOND_ROW] = sticker[0][FIRST_ROW] + sticker[1][SECOND_ROW];
        }

        for (int index = 2; index < N; index++) {
            dp[index][FIRST_ROW] = Math.max(dp[index - 1][SECOND_ROW], dp[index - 2][SECOND_ROW]) + sticker[index][FIRST_ROW];
            dp[index][SECOND_ROW] = Math.max(dp[index - 1][FIRST_ROW], dp[index - 2][FIRST_ROW]) + sticker[index][SECOND_ROW];
        }

        ans = Math.max(dp[N - 1][FIRST_ROW], dp[N - 1][SECOND_ROW]);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            process();
        }
    }
}
