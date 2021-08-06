package part2.graph.practice;

import part2.common.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7569 {
    static FastReader fastReader = new FastReader();

    static int N, M, H; // 가로, 세로, 높이
    static int[][][] tomatoes, distance;
    static int[][] direction = {
            {-1, 0, 0}, {1, 0, 0}, // 앞, 뒤
            {0, -1, 0}, {0, 1, 0}, // 상, 하
            {0, 0, -1}, {0, 0, 1} // 좌, 우
    };
    static boolean[][][] visited;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        H = fastReader.nextInt();

        visited = new boolean[H][M][N];
        distance = new int[H][M][N];
        tomatoes = new int[H][M][N];
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    tomatoes[h][m][n] = fastReader.nextInt();
                    if (tomatoes[h][m][n] == -1) distance[h][m][n] = -1;
                }
            }
        }
    }

    // h: 높이, x: 상하, y: 좌우
    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        // 익은 토마토를 큐에 넣기
        for (int h = 0; h < H; h++) {
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (tomatoes[h][x][y] == 1) {
                        queue.add(h);
                        queue.add(x);
                        queue.add(y);
                        visited[h][x][y] = true;
                        distance[h][x][y] = 1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int h = queue.poll();
            int x = queue.poll();
            int y = queue.poll();

            for (int k = 0; k < 6; k++) {
                int nh = h + direction[k][0];
                int nx = x + direction[k][1];
                int ny = y + direction[k][2];

                if (nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= M || ny >= N) continue; // 올바른 좌표 탐색 영역
                if (visited[nh][nx][ny]) continue;
                if (tomatoes[nh][nx][ny] != 0) continue; // 익지 않은 토마토일 경우에에
                distance[nh][nx][ny] = distance[h][x][y] + 1;
                visited[nh][nx][ny] = true;
                queue.add(nh); queue.add(nx); queue.add(ny);
            }
        }

        int result = 0;
        for (int h = 0; h < H; h++) {
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (distance[h][x][y] == 0) {
                        return - 1;
                    }
                    result = Math.max(result, distance[h][x][y]);
                }
            }
        }
        if (result == 1) return 0;
        return result - 1;
    }

    static void process() {
        int ans = bfs();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
