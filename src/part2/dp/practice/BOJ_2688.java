package part2.dp.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 줄어들지 않아 */
public class BOJ_2688 {
    static FastReader fastReader = new FastReader();

    static int T, N;
    static long[][] dp = new long[65][10]; // dp[i][j] := [N번째 자리수][마지막에 나오는 숫자]

    static void input() {
        N = fastReader.nextInt();
    }

    static void preProcess() {
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 64; i++) {
            long sum = 0;
            for (int j = 0; j <= 9; j++) {
                sum += dp[i -1][j];
                dp[i][j] = sum;
            }
        }
    }

    static void process() {
        long ans = Arrays.stream(dp[N]).sum();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            preProcess();
            process();
        }
    }
}
