package part2.graph.review;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

/* DFS 와 BFS - 인접 행렬 */
public class BOJ_1260_Matrix {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int N, M, V; // 정점, 간선, 시작할 정점 번호
    static int[][] adj; // 인접 행렬
    static boolean[] visited; // 방문 여부

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        V = fastReader.nextInt();
        adj = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= M; i++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            adj[v1][v2] = 1;
            adj[v2][v1] = 1;
        }
    }

    // vertex 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int vertex) {
        visited[vertex] = true;
        sb.append(vertex).append(" ");

        for (int y = 1; y <= N; y++) {
            if (visited[y]) continue;
            if (adj[vertex][y] == 0) continue;
            dfs(y);
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        que.add(start);

        while (!que.isEmpty()) {
            Integer adjacent = que.poll();
            sb.append(adjacent).append(" ");
            for (int y = 0; y <= N; y++) {
                if (visited[y]) continue;
                if (adj[adjacent][y] == 0) continue;
                visited[y] = true;
                que.add(y);
            }
        }
    }

    static void pro() {
        // DFS, BFS 결과 구하기
        dfs(V);
        sb.append("\n");
        for (int i = 0; i <= N; i++) visited[i] = false;
        bfs(V);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
