package part2.graph.review;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

/* 숨바꼭질 */
public class BOJ_1697 {
    static FastReader fastReader = new FastReader();

    static int N, K; // 수빈이의 위치, 동생의 위치
    static boolean[] visited; // 방문 여부
    static int[] distance;

    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        visited = new boolean[100001];
        distance = new int[1000001];
    }

    static void move(int nx, int prev, Queue<Integer> queue) {
        if (nx >= 0 && nx <= 100000 && !visited[nx]) {
            visited[nx] = true;
            distance[nx] = distance[prev] + 1;
            queue.add(nx);
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        distance[vertex] = 0;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            if (vertex == K) break; // 도착점이 뽑혔다면 완료
            // -1 로 이동
            move(vertex - 1, vertex, queue);
            // +1 로 이동
            move(vertex + 1, vertex, queue);
            // *2 로 이동동
            move(vertex * 2, vertex, queue);
       }
    }

    static void process() {
        bfs(N);
        System.out.println(distance[K]);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
