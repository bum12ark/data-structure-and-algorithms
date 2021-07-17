package part2.graph.review;

import part2.common.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14502 {
    static FastReader scan = new FastReader();

    static int N, M, B, ans; // 행, 렬
    static int[][] A, blank;
    static boolean[][] visited;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                A[i][j] = scan.nextInt();
    }

    // 바이러스 퍼뜨리기!!
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능하니까, 전부 큐에 넣어준다.
        /* TODO */

        // BFS 과정
        /* TODO */

        // 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        /* TODO */
    }

    // idx 번째 빈 칸에 벽을 세울 지 말 지 결정해야 하고, 이 전까지 selectedCnt 개의 벽을 세웠다.
    static void dfs(int idx, int selectedCnt) {
        if (selectedCnt == 3) { // 3 개의 벽을 모두 세운 상태
            /* TODO */
            for (int i = 1; i <= N; i++) {
                System.out.println(Arrays.toString(A[i]));
            }
            System.out.println("===========================");
            return;
        }
        if (idx > B) return; // 더 이상 세울 수 있는 벽이 없는 상태

        /* TODO */
        A[blank[idx][0]][blank[idx][1]] = 9;
        dfs(idx + 1, selectedCnt + 1);
        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selectedCnt);
    }

    static void solution() {
        // 모든 벽의 위치를 먼저 모아놓자.
        /* TODO */
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 0) {
                    B++; // 모든 빈칸의 위치
                    blank[B][0] = i; // 빈칸의 x 값
                    blank[B][1] = j; // 빈칸의 y 값
                }
            }
        }

        // 벽을 3개 세우는 모든 방법을 확인해보자!
        /* TODO */
        dfs(1, 0);
    }


    public static void main(String[] args) {
        input();
        solution();
    }
}
