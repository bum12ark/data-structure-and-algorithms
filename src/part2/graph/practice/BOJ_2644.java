package part2.graph.practice;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

/* 촌수계산 */
public class BOJ_2644 {
    static FastReader fastReader = new FastReader();

    static int N, M, n1, n2;
    static int[][] graph;
    static int[] depth;
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) for (int j = 1; j <=N; j++) graph[i][j] = 0;
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        n1 = fastReader.nextInt(); n2 = fastReader.nextInt();
        M = fastReader.nextInt();
        for (int m = 1; m <= M; m++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int adj = 1; adj <= N; adj++) {
                if (!visited[adj] && graph[v][adj] == 1) {
                    depth[adj] = depth[v] + 1;
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    static void solution() {
        bfs(n1);
        if (depth[n2] == 0) System.out.println(-1);
        else System.out.println(depth[n2]);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
