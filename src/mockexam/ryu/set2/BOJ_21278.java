package mockexam.ryu.set2;

import part2.common.FastReader;

import java.util.*;

/* 호석이 두마리 치킨 */
public class BOJ_21278 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int[][] distance; // distance[i][j] := i 에서 j 로 가는데 걸리는 거리

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();

        visited = new boolean[N + 1];
        distance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) graph.put(i, new ArrayList<>());
        for (int i = 0; i < M; i++) {
            int nodeA = fastReader.nextInt();
            int nodeB = fastReader.nextInt();
            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }
    }

    static void bfs(int start) {
        for (int i = 1; i <= N; i++) visited[i] = false;
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        distance[start][start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer pollVertex = queue.poll();
            for (int adj : graph.get(pollVertex)) {
                if (visited[adj]) continue;
                // 거리 정보 갱신 (왕복)
                distance[start][adj] = distance[start][pollVertex] + 2;
                visited[adj] = true;
                queue.add(adj);
            }
        }
    }

    static void process() {
        // start 노드에서 모든 노드로 가는 왕복 거리값 갱신
        for (int start = 1; start <= N; start++) {
            bfs(start);
        }

        // 1 ~ N 까지 두가지 조합으로 갈 수 있는 최단 거리 갱신하기
        int ans = Integer.MAX_VALUE, ax = Integer.MAX_VALUE, ay = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int cnt = 0;
                for (int k = 1; k <= N; k++) {
                    if (k == i || k == j) continue;
                    // 2개의 치킨집 중에 더 가까운 집을 선택하여 거리를 더해준다.
                    cnt += Math.min(distance[i][k], distance[j][k]);
                }

                if (ans > cnt) { // 최소 값이 다양하게 가능하다면 번호가 더 작은것을 출력
                    ans = cnt;
                    ax = i; ay = j;
                }
            }
        }

        // 정답 출력
        sb.append(ax).append(" ").append(ay).append(" ").append(ans);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
