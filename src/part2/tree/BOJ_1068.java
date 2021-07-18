package part2.tree;

import part2.common.FastReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 트리 */
public class BOJ_1068 {
    static FastReader fastReader = new FastReader();

    static int n, erased, root;
    static Map<Integer, List<Integer>> child = new HashMap<>();
    static int[] leaf; // x 를 root 로 하는 subtree 에 있는 단말 노드의 개수

    static void input() {
        n = fastReader.nextInt();
        leaf = new int[n];
        for (int i = 0; i < n; i++) child.put(i, new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int parent = fastReader.nextInt();
            if (parent == -1) {
                root = i;
            } else {
                child.get(parent).add(i);
            }
        }
        erased = fastReader.nextInt();
    }

    static void dfs(int x) {
        if (child.get(x).isEmpty()) { // 리프 노드라면
            leaf[x] = 1;
        }

        for (int adj : child.get(x)) {
            dfs(adj);
            leaf[x] += leaf[adj];
        }
    }

    static void solution() {
        for (int i = 0; i < n; i++) {
            if (child.get(i).contains(erased)) {
                // erased 가 포함된 그래프 삭제
                child.get(i).remove((Integer) erased);
            }
        }

        if (root != erased) {
            dfs(root);
        }
        System.out.println(leaf[root]);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
