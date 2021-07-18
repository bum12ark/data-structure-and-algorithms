package part2.tree;

import part2.common.FastReader;

import java.util.*;

/* 트리의 부모 찾기 */
public class BOJ_11725 {
    static FastReader fastReader = new FastReader();

    static int N;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static int[] parent;

    static void input() {
        N = fastReader.nextInt();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    // dfs (x, par) := 정점 x 의 부모 par 였고, x의 children 들을 찾아주는 함수
    static void dfs(int x, int par) {

        for (int adj : graph.get(x)) {
            if (adj == par) continue;
            parent[adj] = x;
            dfs(adj, x);
        }
    }

    static void solution() {
        dfs(1, -1);
        for (int i = 2; i <= N; i++) System.out.println(parent[i]);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
