package part2.dp.practice;

import part2.common.FastReader;

/* 피보나치 함수 */
public class BOJ_1003 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    // dp[n][0]: n 수에 대하여 0이 출력되는 경우의 수, dp[n][1]: n 수에 대하여 1이 출력되는 경우의 수
    static int[][] dp;

    static void input() {
        N = fastReader.nextInt();
        dp = new int[41][41];
    }

    static void fibonacci(int n) {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
    }

    static void process() {
        fibonacci(N);
    }

    public static void main(String[] args) {
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            process();
        }
        System.out.println(sb);
    }
}
