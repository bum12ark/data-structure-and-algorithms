package part2.graph;

import java.util.*;

// 인접 행렬, 인접 리스트로 구현해보기
// 인접 리스트 사용
public class BOJ_1260 {
    static int N, M, start;
    static boolean[] visited;
    static Map<Integer, List<Integer>> graph;
    static StringBuffer sb = new StringBuffer();

    static void bfs(int vertex) {
        Queue<Integer> que = new LinkedList<>();

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

    }

    public static void main(String[] args) {
        N = 4;
        M = 5;
        start = 1;
        visited = new boolean[N + 1];
        graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(4));
        dfs(start);
        System.out.println(sb.toString());
    }
}
