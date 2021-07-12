package part2.graph;

import part2.common.FastReader;

import java.util.*;

// 인접 행렬, 인접 리스트로 구현해보기
// 인접 리스트 사용
public class BOJ_1260_List {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        start = fastReader.nextInt();

        for (int m = 1; m <= M; m++) {
            graph.put(m, new ArrayList<>());
        }

        for (int m = 0; m < M; m++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    static int N, M, start;
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    static void bfs(int vertex) {
        Queue<Integer> que = new LinkedList<>();
        que.add(vertex);
        visited[vertex] = true;

        while (!que.isEmpty()) {
            Integer pollVertex = que.poll();
            sb.append(pollVertex).append(" ");
            List<Integer> adjacentVertex = graph.getOrDefault(pollVertex, new ArrayList<>());
            for (Integer v : adjacentVertex) {
                if (visited[v]) continue;
                que.add(v);
                visited[v] = true;
            }
        }
    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        sb.append(vertex).append(" ");

        List<Integer> adjacentVertex = graph.getOrDefault(vertex, new ArrayList<>());
        Collections.sort(adjacentVertex);
        for (Integer v : adjacentVertex) {
            if (visited[v]) continue;
            dfs(v);
        }
    }

    static void pro() {
        visited = new boolean[N + 1];
        dfs(start);
        sb.append("\n");
        for (int i = 0; i < N + 1; i++) visited[i] = false;
        bfs(start);
    }

    public static void main(String[] args) {
        input();
        System.out.println(graph);
        pro();
        System.out.println(sb.toString());
    }
}
