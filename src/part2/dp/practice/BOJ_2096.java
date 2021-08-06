package part2.dp.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 내려가기 */
public class BOJ_2096 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static final int LEFT = 0;
    static final int MIDDLE = 1;
    static final int RIGHT = 2;

    static int N;
    static int[][] table;
    static int[][] maxDp, minDp;

    static void input() {
        N = fastReader.nextInt();
        maxDp = new int[N][3];
        minDp = new int[N][3];
        table = new int[N][3];
        for (int i = 0; i < N; i++) {
            table[i][LEFT] = fastReader.nextInt();
            table[i][MIDDLE] = fastReader.nextInt();
            table[i][RIGHT] = fastReader.nextInt();
        }
    }

    static void calculateMaxDp() {
        // 초기값 설정
        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = table[0][i];
        }

        for (int i = 1; i < N; i++) {
            maxDp[i][LEFT] = Math.max(maxDp[i - 1][LEFT], maxDp[i - 1][MIDDLE]) + table[i][LEFT];
            maxDp[i][MIDDLE] = Math.max(maxDp[i - 1][LEFT], Math.max(maxDp[i - 1][MIDDLE], maxDp[i - 1][RIGHT])) + table[i][MIDDLE];
            maxDp[i][RIGHT] = Math.max(maxDp[i - 1][MIDDLE], maxDp[i - 1][RIGHT]) + table[i][RIGHT];
        }
    }

    static void calculateMinDp() {
        // 초기값 설정
        for (int i = 0; i < 3; i++) {
            minDp[0][i] = table[0][i];
        }

        for (int i = 1; i < N; i++) {
            minDp[i][LEFT] = Math.min(minDp[i - 1][LEFT], minDp[i - 1][MIDDLE]) + table[i][LEFT];
            minDp[i][MIDDLE] = Math.min(minDp[i - 1][LEFT], Math.min(minDp[i - 1][MIDDLE], minDp[i - 1][RIGHT])) + table[i][MIDDLE];
            minDp[i][RIGHT] = Math.min(minDp[i - 1][MIDDLE], minDp[i - 1][RIGHT]) + table[i][RIGHT];
        }
    }

    static void process() {
        calculateMaxDp();
        calculateMinDp();

        // 정답 출력
        int min = Arrays.stream(minDp[N - 1]).min().getAsInt();
        int max = Arrays.stream(maxDp[N - 1]).max().getAsInt();
        sb.append(max).append(" ").append(min);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
