package part2.graph;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

// 인접 행렬, 인접 리스트로 구현해보기
// 인접 행렬 사용
public class BOJ_1260_Matrix {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        start = fastReader.nextInt();
        matrix = new int[N + 1][N + 1];
        for (int m = 1; m <= M; m++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }
    }

    static int N, M, start;
    static boolean[] visited;
    static int[][] matrix;

    static void bfs(int vertex) {
        Queue<Integer> que = new LinkedList<>();

        que.add(vertex);
        visited[vertex] = true;

        while (!que.isEmpty()) {
            Integer pollVertex = que.poll();
            sb.append(pollVertex).append(" ");

            for (int y = 1; y <= N; y++) {
                if (matrix[pollVertex][y] == 0) continue;
                if (visited[y]) continue;

                que.add(y);
                visited[y] = true;
            }

        }
    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        sb.append(vertex).append(" ");

        for (int y = 1; y <= N; y++) {
            if (matrix[vertex][y] == 0) continue;
            if (visited[y]) continue;
            dfs(y);
        }

    }

    static void pro() {
        visited = new boolean[N + 1];
        dfs(start);
        sb.append("\n");
        for (int n = 1; n <= N; n++) visited[n] = false;
        bfs(start);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb.toString());
    }
}
