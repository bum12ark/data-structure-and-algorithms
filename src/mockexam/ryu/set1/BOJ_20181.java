package mockexam.ryu.set1;

import part2.common.FastReader;

/* 꿈틀꿈틀 호석 애벌레 */
public class BOJ_20181 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K; // 먹이 개수, 최소만족도
    static long[] foods; // 먹이의 만족도
    static long[] dp;

    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        dp = new long[N + 1];
        foods = new long[N + 1];
        for (int i = 1; i <= N; i++) foods[i] = fastReader.nextInt();
    }

    static void process() {
        int right = 0;
        long sum = 0;
        for (int left = 1; left <= N; left++) {
            // right 값을 최대로 이동
            while (right < N && sum < K) {
                sum += foods[++right];
                // dp를 이전 값으로 초기화 (sum이 K 보다 작을 경우는 이전 dp 값이 최대 값이다)
                dp[right] = dp[right - 1];
            }

            // [left ... right - 1]의 음식을 먹었을 때 얻는 탈피 에너지 := sum - K;
            if (sum >= K) {
                // right 값이 변하지 않는 경우도 있기 때문에, dp[right - 1] 이 아닌 dp[right] 값과 비교
                // 내 구간을 선택하지 않는 경우, 내 구간을 선택하는 경우
                dp[right] = Math.max(dp[right], dp[left - 1] + (sum - K));
            }

            // left 값이 줄어듬에 따른 만족도 값 수정
            sum -= foods[left];
        }
        System.out.println(dp[N]);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
