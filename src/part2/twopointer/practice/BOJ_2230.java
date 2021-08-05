package part2.twopointer.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 수 고르기 */
public class BOJ_2230 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = fastReader.nextInt();
    }

    static int process() {
        Arrays.sort(A);

        int right = 0, ans = Integer.MAX_VALUE, min = 0;
        for (int left = 0; left < N; left++) {
            // right 포인터를 옮길 수 있을 때 까지 옮기기
            while(right < N - 1 && A[right] - A[left] < M) {
                right += 1;
            }

            // 정답 갱신하기
            if (A[right] - A[left] >= M) {
                ans = Math.min(ans, A[right] - A[left]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        input();
        int ans = process();
        System.out.println(ans);
    }
}
