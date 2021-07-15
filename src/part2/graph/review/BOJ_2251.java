package part2.graph.review;

import part2.common.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 물통 */
public class BOJ_2251 {
    static class State {
        int[] X;

        public State(int[] _X) {
            X = new int[3];
            for (int i = 0; i < 3; i++) X[i] = _X[i];
        }

        public State move(int from, int to, int[] limit) {
            // from 물통에서 to 물통으로 물을 옮긴다.
            int[] nX = new int[] {X[0], X[1], X[2]};

            if (X[from] + X[to] >= limit[to]) { // from 에서 to 로 물을 담을 수 있다면
                nX[from] -= limit[to] - nX[to]; // to 를 채울 수 있을 만큼 빼준 뒤
                nX[to] = limit[to]; // to 를 꽉 채운다.
            } else { // 다 담을 수 없다면
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }

    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int[] limit; // 순서대로 A, B, C 물통의 부피
    static boolean[][][] visited;
    static boolean[] possible;

    static void input() {
        limit = new int[3];
        for (int i = 0; i < 3; i++) limit[i] = fastReader.nextInt();
        visited = new boolean[201][201][201];
        possible = new boolean[201];
    }

    // 몰통 탐색 시작 (각각 a, b, c 물의 양)
    static void bfs(int a, int b, int c) {
        Queue<State> queue = new LinkedList<>();
        // BFS 과정 시작
        queue.add(new State(new int[] {a, b, c}));
        visited[a][b][c] = true;

        while (!queue.isEmpty()) {
            State st = queue.poll();
            // 첫번 째 물통인 A 가 비어있다면 정답 처리
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 보내야 할 물통이 같은 물통이라면
                    if (i == j) continue;
                    State nxt = st.move(i, j, limit);
                    if (!visited[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visited[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        queue.add(nxt);
                    }
                }
            }
        }
    }

    static void solution() {
        bfs(0, 0, limit[2]);
        for (int index = 0; index < possible.length; index++) {
            if (possible[index]) sb.append(index).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
