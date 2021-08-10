package mockexam.fastcampus.set2;

import part2.common.FastReader;


/* 영상 처리 */
public class BOJ_21938 {
    static FastReader fastReader = new FastReader();

    static int N, M, T; // 세로, 가로, 경계값
    static int[][] screen;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();

        visited = new boolean[N][M];
        screen = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int R = fastReader.nextInt();
                int G = fastReader.nextInt();
                int B = fastReader.nextInt();
                screen[i][j] = (R + G + B) / 3;
            }
        }

        T = fastReader.nextInt();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int index = 0; index < 4; index++) {
            int nextX = x + direction[index][0];
            int nextY = y + direction[index][1];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
            if (visited[nextX][nextY]) continue;
            if (screen[nextX][nextY] < T) continue;

            dfs(nextX, nextY);
        }
    }

    static void process() {
        int ans = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (!visited[x][y] && screen[x][y] >= T) {
                    dfs(x, y);
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
