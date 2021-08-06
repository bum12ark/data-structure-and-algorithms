package part2.dp.practice;

import part2.common.FastReader;

/* 1, 2, 3 더하기 3 */
public class BOJ_15988 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, n;
    static long[] dp = new long[1000001];

    static void input() {
        n = fastReader.nextInt();
    }

    static void process() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }
        sb.append(dp[n]).append("\n");
    }

    public static void main(String[] args) {
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            process();
        }
        System.out.println(dp[n]);
    }
}
