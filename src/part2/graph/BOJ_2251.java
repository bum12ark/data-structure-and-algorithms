package part2.graph;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2251 {
    // 물통의 형재 상태와 물을 붓는 행위를 관리하는 구조체
    static class State {
        int[] X;
        public State (int[] _X) {
            X = new int[3];
            for (int i = 0; i < 3; i++) X[i] = _X[i];
        }

        State move(int from, int to, int[] limit) {
            // from 물통에서 to 물통으로 물을 옮긴다.
            int[] nX = new int[] {X[0], X[1], X[2]};
            if (X[from] + X[to] >= limit[to]) { // to 의 물용량보다 많은 물을 넣을 경우
                nX[from] -= limit[to] - X[to]; // 채울 수 있을 만큼 to 에 물을 채워준다.
                nX[to] = limit[to]; // to 는 limit 만큼 꽉 채움
            } else {
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int[] limit;
    static boolean[] possible; // 정답으로 가능한 정보를 가지고 있는 배열
    static boolean[][][] visited;

    static void input() {
        limit = new int[3];
        for (int i = 0; i < 3; i++) limit[i] = fastReader.nextInt();
        visited = new boolean[205][205][205];
        possible = new boolean[205];
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();

        visited[x1][x2][x3] = true;
        Q.add(new State(new int[] {x1, x2, x3}));

        while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    State nxt = st.move(from, to, limit);
                    if (!visited[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visited[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }

    }

    static void solution() {
        bfs(0, 0, limit[2]);
        // 정답 계산하기
        for (int i = 0; i <= limit[2]; i++) {
            if (possible[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        solution();
    }
}
