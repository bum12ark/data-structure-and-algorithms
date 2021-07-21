package part2.tree.review;

import part2.common.FastReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 트리 */
public class BOJ_1068 {
    static FastReader fastReader = new FastReader();

    static int N, root, erased;
    static Map<Integer, List<Integer>> child = new HashMap<>();
    static int[] leaf;

    static void input() {
        N = fastReader.nextInt();
        leaf = new int[N];
        for (int i = 0; i < N; i++) child.put(i, new ArrayList<>());
        for (int nodeIdx = 0; nodeIdx < N; nodeIdx++) {
            int parent = fastReader.nextInt();
            if (parent == -1) {
                root = nodeIdx;
            } else {
                child.get(parent).add(nodeIdx);
            }
        }
        erased = fastReader.nextInt();
    }

    // dfs(x) := 정점 x 에 대하여, Subtree(x) 의 leaf 개수를 세주는 함수
    static void dfs(int x) {
        if (child.get(x).isEmpty()) { // 리프 노드라면
            leaf[x] = 1;
        }

        for (int adj : child.get(x)) {
            dfs(adj);
            leaf[x] += leaf[adj];
        }
    }

    static void process() {
        // erased 와 그의 부모 사이의 연결을 끊어주기
        for (int nodeIdx = 0; nodeIdx < N; nodeIdx++) {
            if (child.get(nodeIdx).contains(erased)) {
                child.get(nodeIdx).remove((Integer) erased);
            }
        }

        // erased 가 root 인 예외 처리하기
        if (erased != root) {
            dfs(root);
        }

        // 정답 출력하기
        System.out.println(leaf[root]);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
