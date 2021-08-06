package part2.dp.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* RGB 거리 */
public class BOJ_1149 {
    static FastReader fastReader = new FastReader();

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    static int N, ans; // 집의 수
    static int[][] rgb, dp;

    static void input() {
        N = fastReader.nextInt();
        dp = new int[N + 1][3];
        rgb = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = fastReader.nextInt();
            }
        }
    }

    static void process() {
        for (int index = 1; index <= N; index++) {
            dp[index][RED] = Math.min(dp[index - 1][GREEN], dp[index - 1][BLUE]) + rgb[index][RED];
            dp[index][GREEN] = Math.min(dp[index - 1][RED], dp[index - 1][BLUE]) + rgb[index][GREEN];
            dp[index][BLUE] = Math.min(dp[index - 1][RED], dp[index - 1][GREEN]) + rgb[index][BLUE];
        }

        // 최소 값 출력
        ans = Arrays.stream(dp[N]).min().getAsInt();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
