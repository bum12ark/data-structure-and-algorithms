package part2.graph.practice;

import part2.common.FastReader;


public class BOJ_4963 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int W, H;
    static int[][] adj;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; // 상 하 좌 우 대각선

    static void input() {
        W = fastReader.nextInt();
        H = fastReader.nextInt();
        adj = new int[H][W];
        visited = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                adj[i][j] = fastReader.nextInt();
            }
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
            if (visited[nx][ny]) continue;
            if (adj[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }

    static void solution() {
        int cnt = 0;
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if (!visited[h][w] && adj[h][w] == 1) {
                    cnt++;
                    dfs(h, w);
                }
            }
        }
        sb.append(cnt).append("\n");
    }

    public static void main(String[] args) {
        while (true) {
            input();
            if (W == 0 && H == 0) {
                break;
            }
            solution();
        }
        System.out.println(sb);
    }
}
