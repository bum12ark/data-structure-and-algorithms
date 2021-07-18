package part2.tree.practice;

import part2.common.FastReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 나무 탈출 */
public class BOJ_15900 {
    static FastReader fastReader = new FastReader();

    static int N, ans;
    static Map<Integer, List<Integer>> tree = new HashMap<>();

    static void input() {
        N = fastReader.nextInt();

        for (int i = 1; i <= N; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int parent = fastReader.nextInt();
            int child = fastReader.nextInt();
            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }
    }

    static void dfs(int x, int parent, int depth) {
        if (tree.get(x).size() == 1) {
            ans += depth;
        }

        for (int adj : tree.get(x)) {
            if (adj == parent) continue;
            dfs(adj, x, depth + 1);
        }
    }

    static void solution() {
        dfs(1, -1, 0);
        if (ans % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
