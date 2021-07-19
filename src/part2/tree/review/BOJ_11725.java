package part2.tree.review;

import part2.common.FastReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 트리 */
public class BOJ_11725 {
    static FastReader fastReader = new FastReader();

    static int N;
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static int[] parents;

    static void input() {
        N = fastReader.nextInt();
        parents = new int[N + 1];
        for (int v = 1; v <= N; v++) {
            tree.put(v, new ArrayList<>());
        }
        // 연결 리스트 구성하기
        for (int m = 0; m < N - 1; m++) { // 트리의 간선은 정점의 개수 - 1
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }
    }

    // dfs(current, parent) := 정점 current 의 부모가 parent 엿고, current 의 children 들을 찾아주는 함수
    static void dfs(int current, int parent) {
        for (int adj : tree.get(current)) {
            if (adj == parent) continue;
            parents[adj] = current;
            dfs(adj, current);
        }
    }

    static void solution() {
        // 1번 정점이 ROOT 이므로, 여기서 시작해서 Tree 의 구조를 파악하자.
        dfs(1, -1);

        // 정답 출력하기
        for (int i = 2; i <= N; i++) System.out.println(parents[i]);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
