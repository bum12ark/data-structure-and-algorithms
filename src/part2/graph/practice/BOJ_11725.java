package part2.graph.practice;

import part2.common.FastReader;

import java.util.*;

/* 트리의 부모 찾기 */
public class BOJ_11725 {
    static FastReader fastReader = new FastReader();

    static int N;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int[] parents;

    static void input() {
        N = fastReader.nextInt();
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i < N; i ++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            Integer pollVertex = queue.poll();
            for (Integer adj : graph.get(pollVertex)) {
                if (!visited[adj]) {
                    parents[adj] = pollVertex;
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    static void solution() {
        bfs(1);
    }

    public static void main(String[] args) {
        input();
        solution();
        for (int i = 2; i < N + 1; i++) System.out.println(parents[i]);
    }
}
