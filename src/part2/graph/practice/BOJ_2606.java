package part2.graph.practice;

import part2.common.FastReader;

import java.util.*;

public class BOJ_2606 {
    static FastReader fastReader = new FastReader();

    static int N, M, cnt; // 컴퓨터의 수, 간선의 수, 감염된 컴퓨터 수
    static Map<Integer, List<Integer>> network = new HashMap<>();
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            network.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int c1 = fastReader.nextInt();
            int c2 = fastReader.nextInt();
            network.get(c1).add(c2);
            network.get(c2).add(c1);
        }
    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        cnt += 1;

        for (int adj : network.get(vertex)) { // 갈 수 있는 간선
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            Integer pollVertex = queue.poll();
            cnt += 1;
            for (Integer adj : network.get(pollVertex)) { // 인접 그래프 탐색
                if (!visited[adj]) {
                    visited[adj] = true; // 방문 처리
                    queue.add(adj);
                }
            }
        }
    }

    static void solution() {
        // dfs(1);
        bfs(1);
    }

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(cnt - 1); // 1번 컴퓨터를 빼준다.
    }
}
