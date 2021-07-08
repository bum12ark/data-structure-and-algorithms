package part2.bruteforce.review;

import part2.common.FastReader;

public class BOJ_9663 {
    static FastReader fastReader = new FastReader();

    static int N, ans;
    static int[] columns; // columns[i]: i번 행의 퀸은 columns[i]번 열에 놓았다는 기록

    static void input() {
        N = fastReader.nextInt();
        columns = new int[N];
    }

    static boolean validityCheck(int row, int col) {
        for (int prev = 0; prev < row; prev++) {
            if (columns[prev] == col) return false;
            if (row - prev == Math.abs(col - columns[prev])) return false;
        }
        return true;
    }

    // row 번 ~ N 번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기기
    static void recFunc(int row) {
        if (row == N) { // 탐색이 다 완료 되었을 경우
            // System.out.println(Arrays.toString(column));
            ans++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (validityCheck(row, col)) {
                columns[row] = col;
                recFunc(row + 1);
                columns[row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(0);
        System.out.println(ans);
    }
}
