package part2.bruteforce;

import part2.common.FastReader;


public class BOJ_9663 {
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        column = new int[N + 1];
    }

    static int N, ans;
    static int[] column;

    static boolean validityCheck(int row, int col) {
        // 이전 로우들에 대해 validation check
        for (int prevRow = 1; prevRow < row; prevRow++) {
            int prevColumn = column[prevRow];
            if (prevColumn == col) { // 세로 체크
                return false;
            }
            if (Math.abs(prevRow - row) == Math.abs(prevColumn - col)) { // 대각선 체크
                return false;
            }
        }
        return true;
    }

    static void recFunc(int row) {
        if (row == N + 1) {
            ans++;
            return;
        }
        for (int col = 1; col <= N; col++) {
            column[row] = col;
            if (validityCheck(row, col)) {
                recFunc(row + 1);
            }
            column[row] = 0;
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(ans);
    }
}
