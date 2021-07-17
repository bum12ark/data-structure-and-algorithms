package part2.graph;

import part2.common.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 숨바꼭질 */
public class BOJ_1697 {
    static FastReader fastReader = new FastReader();

    static int N, K; // 수빈이의 위치, 동생의 위치
    static int[] location;
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        K = fastReader.nextInt();
        location = new int[100001];
        visited = new boolean[100001];
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        location[x] = 0;

        while (!queue.isEmpty()) {
            x = queue.poll();
            int y = x - 1;
            if (0 <= y && y <= 100000 && !visited[y]) {
                visited[y] = true;
                location[y] = location[x] + 1;
                queue.add(y);
            }
            y = x + 1;
            if (0 <= y && y <= 100000 && !visited[y]) {
                visited[y] = true;
                location[y] = location[x] + 1;
                queue.add(y);
            }
            y = x * 2;
            if (0 <= y && y <= 100000 && !visited[y]) {
                visited[y] = true;
                location[y] = location[x] + 1;
                queue.add(y);
            }
        }

    }

    static void solution() {
        bfs(N);
        System.out.println(location[K]);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
