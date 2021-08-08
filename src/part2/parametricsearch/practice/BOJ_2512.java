package part2.parametricsearch.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 예산 */
public class BOJ_2512 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M; // 지방의 수, 총 예산
    static int[] A;

    static void input() {
        N = fastReader.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = fastReader.nextInt();
        M = fastReader.nextInt();
    }

    static boolean determination(int budge) {
        int sum = 0;
        for (int n : A) {
            sum += Math.min(n, budge);
        }
        return sum <= M;
    }

    static void process() {
        int left = 1, right = Arrays.stream(A).max().getAsInt(), ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (determination(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
