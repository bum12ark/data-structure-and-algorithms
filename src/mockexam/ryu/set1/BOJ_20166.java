package mockexam.ryu.set1;

import part2.common.FastReader;

import java.util.HashMap;
import java.util.Map;

/* 문자열 지옥에 빠진 호석 */
public class BOJ_20166 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, K; // 격자의 세로, 가로 값, 문자열의 개수
    static char[][] A; // 격자
    static Map<String, Integer> wordCounts = new HashMap<>();

    static int[][] direction = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, // 상 하 좌 우
            {-1, -1}, {1, -1}, {-1, 1}, {1, 1} // 죄상단, 좌하단, 우상단, 우하단
    };


    static void input() {
        R = fastReader.nextInt();
        C = fastReader.nextInt();
        K = fastReader.nextInt();

        A = new char[R][C];
        for (int r = 0; r < R; r++) {
            String s = fastReader.next();
            for (int c = 0; c < C; c++) {
                A[r][c] = s.charAt(c);
            }
        }
    }

    // len 이 5일 때까지 가능한 모든 문자열의 개수를 기록한다.
    static void dfs(int x, int y, String path, int len) {
        wordCounts.put(path, wordCounts.getOrDefault(path, 0) + 1);

        if (len == 5) {
            return;
        }

        // 8 방향 탐색
        for (int i = 0; i < 8; i++) {
            int nextX = (x + direction[i][0]) % R;
            int nextY = (y + direction[i][1]) % C;
            if (nextX < 0) nextX += R;
            if (nextY < 0) nextY += C;

            dfs(nextX, nextY, path + A[nextX][nextY], len + 1);
        }
    }

    static void process() {
        // 모든 문자열이 나올 수 있는 경우의 수 탐색
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                dfs(x, y, Character.toString(A[x][y]), 1);
            }
        }

        while (K-- > 0) {
            String input = fastReader.next();
            int ans = wordCounts.getOrDefault(input, 0);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
