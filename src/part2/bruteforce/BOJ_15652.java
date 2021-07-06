package part2.bruteforce;

import part2.common.FastReader;

public class BOJ_15652 {
    static StringBuffer sb = new StringBuffer();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    static void recFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int start = selected[k - 1];
        if (start == 0) start = 1;
        for (int cand = start; cand <= N; cand++) {
            selected[k] = cand;
            recFunc(k + 1);
            selected[k] = 0;
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }
}
