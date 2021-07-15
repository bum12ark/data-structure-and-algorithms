package part2.graph;

import part2.common.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 미로 탐색 */
public class BOJ_2178 {
    static FastReader fastReader = new FastReader();

    static int N, M; // 행, 열
    static char[][] A;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] dist;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        visited = new boolean[N][M];
        A = new char[N][M];
        for (int n = 0; n < N; n++) {
            A[n] = fastReader.nextLine().toCharArray();
        }
        dist = new int[N][M];
    }

    static void bfs(int x, int y) {
        // dist 배열 초기화
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) dist[i][j] = -1;

        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;
        dist[x][y] = 1;

        while (!queue.isEmpty()) {
            Integer px = queue.poll();
            Integer py = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = px + dir[k][0];
                int ny = py + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (A[nx][ny] == '0') continue; // 벽일 경우
                if (visited[nx][ny]) continue; // 이미 방문한 지점일 경우

                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
                dist[nx][ny] = dist[px][py] + 1;
            }
        }
    }

    static void solution() {
        // 시작점이 (0, 0)인 탐색 시작
        bfs(0, 0);
        // (N-1, M-1)까지 필요한 최소 이동 횟수 출력
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
