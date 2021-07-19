package part2.tree.practice;

import part2.common.FastReader;

import java.util.*;

/* 노드 사이의 거리 */
public class BOJ_1240 {
    static class Edge {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "[" + node + ", " + distance + "]";
        }
    }

    static FastReader fastReader = new FastReader();

    static int N, M; // 노드의 개수, 입력 받을 두 노드 사이의 거리 수
    static Map<Integer, List<Edge>> tree = new HashMap<>(); // {노드, 거리}
    static int[][] question;
    static boolean[] visited;
    static int[] dist;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            int distance = fastReader.nextInt();
            tree.get(v1).add(new Edge(v2, distance));
            tree.get(v2).add(new Edge(v1, distance));
        }

        question = new int[M][2];
        for (int m = 0; m < M; m++) {
            question[m][0] = fastReader.nextInt();
            question[m][1] = fastReader.nextInt();
        }
    }

    static void dfs(int vertex) {
        visited[vertex] = true;

        for (Edge edge : tree.get(vertex)) {
            int distance = edge.distance;
            int adj = edge.node;
            if (!visited[adj]) {
                visited[adj] = true;
                dist[adj] = dist[vertex] + distance;
                dfs(adj);
            }
        }
    }

    static void solution() {
        for (int m = 0; m < M; m++) {
            for (int i = 1; i <= N; i++) dist[i] = 0;
            for (int i = 1; i <= N; i++) visited[i] = false;
            dfs(question[m][0]);
            System.out.println(dist[question[m][1]]);
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
