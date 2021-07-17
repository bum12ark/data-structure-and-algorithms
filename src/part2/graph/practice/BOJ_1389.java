package part2.graph.practice;

import part2.common.FastReader;

import java.util.*;

/* 케빈 베이컨의 6단계 법칙 */
public class BOJ_1389 {
    static FastReader fastReader = new FastReader();

    static int N, M, ans; // 유저의 수, 친구 관계의 수
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int[][] distance; // 거리를 저장할 배열
    static int[] candidate; // 케빈 베이컨의 수를 저장할 배열

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();
        visited = new boolean[N + 1];
        distance = new int[N + 1][N + 1];
        candidate = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 양방향 그래프 초기화
        for (int i = 1; i <= M; i++) {
            int v1 = fastReader.nextInt();
            int v2 = fastReader.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        distance[vertex][1] = 0;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            for (Integer adj : graph.get(x)) {
                if (!visited[adj]) {
                    visited[adj]= true;
                    queue.add(adj);
                    distance[vertex][adj] = distance[vertex][x] + 1;
                }
            }
        }
        for (int i = 1; i <= N; i++) candidate[vertex] += distance[vertex][i];
    }

    static void solution() {
        for (int i = 1; i <= N; i++) {
            // 방문 배열 초기화
            for (int j = 1; j <= N; j++) visited[j] = false;
            // 탐색 시작
            bfs(i);
        }

        // 값이 더 적을 경우에만 답을 갱신
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (candidate[i] < min) {
                min = candidate[i];
                ans = i;
            }
        }
    }

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(ans);
    }
}
