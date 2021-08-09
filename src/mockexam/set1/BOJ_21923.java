package mockexam.set1;

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
        scores = new int[R][C];
        for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) scores[i][j] = fastReader.nextInt();
        dpLeftToRight = new int[R][C];
        dpRightToLeft = new int[R][C];
    }

    static void setDpLeftToRight() {
        for (int row = R - 1; row >= 0; row--) { // 마지막 줄부터 왼쪽에서 오른쪽으로 탐색
            for (int col = 0; col < C; col ++) {
                if (row == R - 1 && col == 0) { // 출발지점일 때
                    dpLeftToRight[row][col] = scores[row][col];
                }
                else if (row == R - 1) { // 맨 마지막 줄일 경우
                    dpLeftToRight[row][col] = dpLeftToRight[row][col - 1] + scores[row][col];
                }
                else if (col == 0) { // 맨 왼쪽 열일 경우
                    dpLeftToRight[row][col] = dpLeftToRight[row + 1][col] + scores[row][col];
                }
                else { // 나머지
                    dpLeftToRight[row][col] = Math.max(dpLeftToRight[row + 1][col], dpLeftToRight[row][col - 1]) + scores[row][col];
                }
            }
        }
    }

    static void setDpRightToLeft() {
        for (int row = R -1; row >= 0; row--) {
            for (int col = C - 1; col >= 0; col--) {
                if (row == R - 1 && col == C - 1) {

                }
            }
        }
    }

    static void process() {
        setDpLeftToRight();
         for (int i = 0; i < R; i++) System.out.println(Arrays.toString(dpLeftToRight[i]));
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
