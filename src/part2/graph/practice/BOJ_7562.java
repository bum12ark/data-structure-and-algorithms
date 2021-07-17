package part2.graph.practice;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

/* 나이트의 이동 */
public class BOJ_7562 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int I; // 변의 길이
    static int[][] board;
    static int[] start = new int[2], end = new int[2];
    static boolean[][] visited;
    static int[][] direction = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    static void input() {
        I = fastReader.nextInt();
        board = new int[I][I];
        visited = new boolean[I][I];
        start[0] = fastReader.nextInt(); start[1] = fastReader.nextInt();
        end[0] = fastReader.nextInt(); end[1] = fastReader.nextInt();
    }

    static void bfs(int x, int y) {
        for (int i = 0; i < I; i++) for (int j = 0; j < I; j++) board[i][j] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;
        board[x][y] = 0;

        while (!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            for (int index = 0; index < 8; index++) {
                int nx = x + direction[index][0];
                int ny = y + direction[index][1];

                if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
                board[nx][ny] = board[x][y] + 1;
            }
        }
    }

    static void solution() {
        bfs(start[0], start[1]);
        sb.append(board[end[0]][end[1]]).append("\n");
    }

    public static void main(String[] args) {
        int T = fastReader.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            solution();
        }
        System.out.println(sb);
    }
}
