package part2.bruteforce.review;

import part2.common.FastReader;

public class BOJ_15649 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        selected = new int[M + 1];
        used = new boolean[N + 1];
    }

    static int N, M;
    static int[] selected;
    static boolean[] used;

    /**
     * N 개 중 중복 없이 M 개를 순서있게 나열
     * @param numberDigit: 자리수
     */
    static void recFunc(int numberDigit) {
        if (numberDigit == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int cand = 1; cand < N + 1; cand++) {
            if (used[cand]) {
                continue;
            }

            used[cand] = true;
            selected[numberDigit] = cand;

            recFunc(numberDigit + 1);

            used[cand] = false;
            selected[numberDigit] = 0;

        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }
}
