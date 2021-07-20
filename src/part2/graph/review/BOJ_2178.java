package part2.graph.review;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

/* 미로 탐색 */
public class BOJ_2178 {
    static FastReader fastReader = new FastReader();

    static int N, M; // 행 열
    static char[][] maze; // 미로
    static boolean[][] visited; // 방문 여부
    static int[][] distance; // 이동 거리
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 방향

    static void input() {
        N = fastReader.nextInt(); M = fastReader.nextInt();
        visited = new boolean[N][M];
        distance = new int[N][M];
        // 그래프 초기화
        maze = new char[N][M];
        for (int x = 0; x < N; x++) {
            maze[x] = fastReader.nextLine().toCharArray();
        }
    }

    static void bfs(int x, int y) {
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) distance[i][j] = -1;

        Queue<Integer> queue = new LinkedList<>();
        visited[x][y] = true;
        distance[x][y] = 1;
        queue.add(x);
        queue.add(y);

        while (!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = x + direction[k][0];
                int nextY = y + direction[k][1];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue; // 미로 내부인지?
                if (visited[nextX][nextY]) continue; // 방문한적이 있는지?
                if (maze[nextX][nextY] == '0') continue; // 벽인가?

                visited[nextX][nextY] = true;
                distance[nextX][nextY] = distance[x][y] + 1;
                queue.add(nextX);
                queue.add(nextY);
            }
        }
    }

    static void process() {
        bfs(0, 0);
        System.out.println(distance[N - 1][M - 1]);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
