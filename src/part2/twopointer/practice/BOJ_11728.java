package part2.twopointer.practice;

import java.util.Arrays;

public class BOJ_11728 {

    static int N, M;
    static int[] A, B;

    static void pro() {
        int p1 = 0, p2 = 0, index = p1 + p2;
        int[] res = new int[N + M];
        while (p1 < N - 1 || p2 < N - 1) {
            if(A[p1] < B[p2]) {
                res[index] = A[p1];
                p1++;
            } else {
                res[index] = B[p2];
                p2++;
            }
        }

        while (p1 < N) { // A 배열에 값이 남아 있음
            res[index] = A[p1];
            p1++;
        }

        while (p2 < M) { // B 배열에 값이 남아 있음
            res[index] = B[p2];
            p2++;
        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        N = 4;
        M = 3;
        A = new int[] {2, 3, 5, 9};
        B = new int[] {1, 4, 7};
        pro();
    }
}
