package part2.graph.practice;

import part2.common.FastReader;

import java.util.*;

/* 최소환승경로 */
public class BOJ_2021 {
    static class Node {
        int idx, cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    static FastReader fastReader = new FastReader();

    static int N, L, S, E; // 역의 개수, 노선의 개수, 출발지, 도착지
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        L = fastReader.nextInt();

        visited = new boolean[N + L + 1];
        for (int i = 1; i <= N + L; i++) adjList.put(i, new ArrayList<>());
        for (int i = N + 1; i <= N + L; i++) {
            int next;
            while ((next = fastReader.nextInt()) != -1) {
                adjList.get(i).add(next);
                adjList.get(next).add(i);
            }
        }

        S = fastReader.nextInt();
        E = fastReader.nextInt();
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(S, 0));
        visited[S] = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int cur = temp.idx;
            int cnt = temp.cnt;

            if (cur == E) {
                return cnt;
            }

            for (int next : adjList.get(cur)) {
                if (visited[next]) continue;

                visited[next] = true;
                queue.add(new Node(next, cnt + 1));
            }
        }
        return -1;
    }

    static void process() {
        int cnt = bfs();
        int ans = cnt / 2 - 1;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        process();
    }

}
/*
6 2
1 2 3 4 5 -1
2 6 5 -1
1 5
 */
