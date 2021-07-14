package part2.graph.practice;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11724 {
    static FastReader fastReader = new FastReader();

    static int N, M;
    static int[][] adj;
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        adj = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int x = fastReader.nextInt();
            int y = fastReader.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();

        visited[x] = true;
        que.add(x);

        while (!que.isEmpty()) {
            Integer px = que.poll();

            for (int y = 1; y <= N; y++) {
                if (visited[y]) continue;
                if (adj[px][y] == 0) continue;

                visited[y] = true;
                que.add(y);
            }
        }
    }

    static int solution() {
        int cnt = 0;
        for (int x = 1; x <= N; x++) {
            if (!visited[x]) {
                bfs(x);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        input();
        int ans = solution();
        System.out.println(ans);
    }
}
