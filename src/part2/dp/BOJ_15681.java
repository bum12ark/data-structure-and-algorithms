package part2.dp;

import part2.common.FastReader;

import java.util.*;

/* 트리와 쿼리 */
public class BOJ_15681 {
    static FastReader fastReader = new FastReader();

    static int N, R, Q; // 트리의 정점의 수, 루트의 번호, 쿼리의 수
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static int[] dp, query; // 다이나믹 테이블
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        R = fastReader.nextInt();
        Q = fastReader.nextInt();

        dp = new int[N + 1];
        visited = new boolean[N + 1];
        for (int node = 1; node <= N; node++) {
            tree.put(node, new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            int n1 = fastReader.nextInt();
            int n2 = fastReader.nextInt();
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        query = new int[Q];
        for (int q = 0; q < Q; q++) {
            query[q] = fastReader.nextInt();
        }

    }

    static void dfs(int node) {
        dp[node] = 1;
        visited[node] = true;

        for (int adj : tree.get(node)) {
            if (visited[adj]) continue;
            dfs(adj);
            dp[node] += dp[adj];
        }
    }

    static void process() {
        dfs(R);
        for (int q = 0; q < Q; q++) {
            System.out.println(dp[query[q]]);
        }
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
