package mockexam.fastcampus.set2;

import part2.common.FastReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 작업 */
public class BOJ_21937 {
    static FastReader fastReader = new FastReader();

    static int N, M, X, ans; // 작업의 개수, 작업 순서 정보의 개수, 끝내야하는 작업
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) graph.put(i, new ArrayList<>());
        for (int i = 0; i < M; i++) {
            int nodeA = fastReader.nextInt();
            int nodeB = fastReader.nextInt();
            graph.get(nodeB).add(nodeA);
        }
        X = fastReader.nextInt();
    }

    static void dfs(int node) {
        ans++;
        visited[node] = true;

        for (int adj : graph.get(node)) {
            if (visited[adj]) continue;
            dfs(adj);
        }
    }

    static void process() {
        dfs(X);
        System.out.println(ans - 1);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
