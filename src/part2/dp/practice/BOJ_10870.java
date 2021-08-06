package part2.dp.practice;

import part2.common.FastReader;

/* 피보나치 수 5 */
public class BOJ_10870 {
    static FastReader fastReader = new FastReader();

    static int n;
    static int[] dp = new int[25];

    static void input() {
        n = fastReader.nextInt();
    }

    static void fibonacci(int n) {
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    static void process() {
        fibonacci(n);
        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
