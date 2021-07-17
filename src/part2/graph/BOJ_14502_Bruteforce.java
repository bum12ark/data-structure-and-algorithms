package part2.graph;

import java.util.Arrays;

public class BOJ_14502_Bruteforce {
    static int[] A;

    static void dfs(int x, int cnt) {
        if (cnt == 2) {
            System.out.println(Arrays.toString(A));
            return;
        }

        if (x >= 4) return;
        A[x] = 1;
        dfs(x + 1, cnt + 1);
        A[x] = 0;
        dfs(x + 1, cnt);
    }

    public static void main(String[] args) {
        A = new int[] {0, 0, 0, 0};
        dfs(0, 0);
    }
}
