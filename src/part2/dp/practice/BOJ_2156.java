package part2.dp.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 포도주 시식 */
public class BOJ_2156 {
    static FastReader fastReader = new FastReader();

    static final int ONE_SPACE_AGO = 0; // 이전 잔을 마시는 경우
    static final int TWO_SPACE_AGO = 1; // 두칸전 잔을 마시는 경우
    static final int THREE_SPACE_AGO = 2; // 세칸전 잔을 마시는 경우
    static int N, ans;
    static int[] wine;
    static int[][] dp;

    static void input() {
        N = fastReader.nextInt();
        wine = new int[N + 1];
        dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            wine[i] = fastReader.nextInt();
        }
    }

    static void process() {
        // 초기값 설정
        dp[1][ONE_SPACE_AGO] = wine[1];
        dp[1][TWO_SPACE_AGO] = wine[1];
        dp[1][THREE_SPACE_AGO] = wine[1];
        ans = wine[1];

        if (N >= 2) {
            dp[2][ONE_SPACE_AGO] = wine[1] + wine[2];
            dp[2][TWO_SPACE_AGO] = wine[2];
            dp[2][THREE_SPACE_AGO] = wine[2];
            ans = dp[2][ONE_SPACE_AGO];
        }

        for (int index = 3; index <= N; index++) {
            dp[index][ONE_SPACE_AGO] = Math.max(dp[index - 1][TWO_SPACE_AGO], dp[index - 1][THREE_SPACE_AGO]) + wine[index];
            dp[index][TWO_SPACE_AGO] = Arrays.stream(dp[index - 2]).max().getAsInt() + wine[index];
            dp[index][THREE_SPACE_AGO] = Arrays.stream(dp[index - 3]).max().getAsInt() + wine[index];
            int max = Arrays.stream(dp[index]).max().getAsInt();
            ans = Math.max(ans, max);
        }

        // 정답 출력
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
