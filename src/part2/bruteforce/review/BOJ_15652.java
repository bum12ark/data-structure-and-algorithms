package part2.bruteforce.review;

import part2.common.FastReader;

public class BOJ_15652 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    /**
     * N 개 중 중복을 허용해서 M 개를 고르기
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
        int start = selected[numberDigit - 1] == 0 ? 1 : selected[numberDigit - 1];
        for (int cand = start; cand <= N; cand++) {
            selected[numberDigit] = cand;
            recFunc(numberDigit + 1);
            selected[numberDigit] = 0;
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(sb.toString());
    }
}
