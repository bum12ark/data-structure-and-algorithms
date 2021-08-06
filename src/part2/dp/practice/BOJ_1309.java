package part2.dp.practice;

import part2.common.FastReader;

import java.util.Arrays;

public class BOJ_1309 {
    static FastReader fastReader = new FastReader();

    static final int EMPTY = 0; // i 번째 행에 사자가 없는 경우
    static final int LEFT = 1; // i 번째 행의 왼쪽에 사자가 있는 경우
    static final int RIGHT = 2; // i 번째 행의 오른쪽에 사자가 있는 경우
    static final int MODULAR = 9901;

    static int N;
    static int[][] dp;

    static void input() {
        N = fastReader.nextInt();
        dp = new int[N][3];
    }

    static void process() {
        // 초기값 설정
        dp[0][EMPTY] = 1;
        dp[0][LEFT] = 1;
        dp[0][RIGHT] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][EMPTY] = (dp[i - 1][EMPTY] + dp[i - 1][LEFT] + dp[i - 1][RIGHT]) % MODULAR;
            dp[i][LEFT] = (dp[i - 1][EMPTY] + dp[i - 1][RIGHT]) % MODULAR;
            dp[i][RIGHT] = (dp[i - 1][EMPTY] + dp[i - 1][LEFT]) % MODULAR;
        }

        int ans = Arrays.stream(dp[N - 1]).sum() % MODULAR;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
