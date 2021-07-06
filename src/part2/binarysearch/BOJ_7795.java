package part2.binarysearch;

import part2.common.FastReader;

public class BOJ_7795 {
    static FastReader fastReader = new FastReader();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        A = new int[N];
        B = new int[M];
        for (int i = 0; i < M; i++) A[i] = fastReader.nextInt();
        for (int i = 0; i < N; i++) B[i] = fastReader.nextInt();
    }

    static int N, M;
    static int[] A, B;

    public static void main(String[] args) {
        int T;
        T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
        }
    }
}
