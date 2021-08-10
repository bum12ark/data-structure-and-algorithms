package mockexam.fastcampus.set1;

import part2.common.FastReader;

import java.util.Arrays;

/* 곡예 비행 */
public class BOJ_21923 {
    static FastReader fastReader = new FastReader();

    static int R, C; // 세로 길이, 가로길이
    static int[][] scores;
    static int[][] dpLeftToRight, dpRightToLeft;

    static void input() {
        R = fastReader.nextInt();
        C = fastReader.nextInt();
        scores = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) for (int j = 1; j <= C; j++) scores[i][j] = fastReader.nextInt();
        dpLeftToRight = new int[R + 1][C + 1];
        dpRightToLeft = new int[R + 1][C + 1];
    }

    static void setDpLeftToRight() {
        for (int row = R; row >= 1; row--) { // 마지막 줄부터 왼쪽에서 오른쪽으로 탐색
            for (int col = 1; col <= C; col ++) {
                if (row < R && col > 1) dpLeftToRight[row][col] = Math.max(dpLeftToRight[row + 1][col], dpLeftToRight[row][col - 1]) + scores[row][col];
                else if (row < R) dpLeftToRight[row][col] = dpLeftToRight[row + 1][col] + scores[row][col];
                else if (col > 1) dpLeftToRight[row][col] = dpLeftToRight[row][col - 1] + scores[row][col];
                else dpLeftToRight[row][col] = scores[row][col];
            }
        }
    }

    static void setDpRightToLeft() {
        for (int row = R; row >= 1; row--) {
            for (int col = C; col >= 1; col--) {
                if (row < R && col < C) dpRightToLeft[row][col] = Math.max(dpRightToLeft[row + 1][col], dpRightToLeft[row][col + 1]) + scores[row][col];
                else if (row < R) dpRightToLeft[row][col] = dpRightToLeft[row + 1][col] + scores[row][col];
                else if (col < C) dpRightToLeft[row][col] = dpRightToLeft[row][col + 1] + scores[row][col];
                else dpRightToLeft[row][col] = scores[row][col];
            }
        }
    }

    static void process() {
        setDpLeftToRight();
         for (int i = 0; i <= R; i++) System.out.println(Arrays.toString(dpLeftToRight[i]));
        System.out.println("======================");
        setDpRightToLeft();
         for (int i = 0; i <= R; i++) System.out.println(Arrays.toString(dpRightToLeft[i]));
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
