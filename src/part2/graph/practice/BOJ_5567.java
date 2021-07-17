package part2.graph.practice;

import part2.common.FastReader;

import java.util.*;

/* 결혼식 */
public class BOJ_5567 {
    static FastReader fastReader = new FastReader();

    static int N, M; // 정점의 수, 간선의 수
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] distance;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        distance[vertex] = 0;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Integer nextVertex = queue.poll();

            for (int adj : graph.get(nextVertex)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    distance[adj] = distance[nextVertex] + 1;
                    queue.add(adj);
                }
            }
        }
    }

    static void solution() {
        bfs(1);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] > 0 && distance[i] <= 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
