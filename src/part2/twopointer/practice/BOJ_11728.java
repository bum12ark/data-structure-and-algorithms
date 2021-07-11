package part2.twopointer.practice;

import part2.common.FastReader;


public class BOJ_11728 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        A = new int[N];
        B = new int[M];
        for (int n = 0; n < N; n++) A[n] = fastReader.nextInt();
        for (int m = 0; m < M; m++) B[m] = fastReader.nextInt();
    }

    static int N, M;
    static int[] A, B;

    static int[] pro() {
        int p1 = 0, p2 = 0, index = 0;
        int[] res = new int[N + M];
        while (p1 < N && p2 < M) {
            if(A[p1] < B[p2]) {
                res[index++] = A[p1++];
            } else {
                res[index++] = B[p2++];
            }
        }

        while (p1 < N) { // A 배열에 값이 남아 있음
            res[index++] = A[p1++];
        }

        while (p2 < M) { // B 배열에 값이 남아 있음
            res[index++] = B[p2++];
        }

        return res;
    }

    public static void main(String[] args) {
        input();
        int[] answer = pro();
        for (int n : answer) sb.append(n).append(" ");
        System.out.println(sb.toString());
    }
}
