package part2.graph;

import part2.common.FastReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ_2667 {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int N, groupCnt;
    static char[][] complex;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 상하좌우
    static List<Integer> group;

    static void input() {
        N = fastReader.nextInt();
        complex = new char[N][N];
        for (int n = 0; n < N; n++) {
            complex[n] = fastReader.nextLine().toCharArray();
        }
        visited = new boolean[N][N];
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        complex[x][y] = '*';
        groupCnt += 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 지도를 벗어나는 곳으로 가는가?
            if (complex[nx][ny] < '1') continue; // 갈 수 있는 칸인지 확인해야 한다.
            if (visited[nx][ny]) continue; // 이미 방문한 적이 있는 곳인가

            dfs(nx, ny);
        }
    }

    static void pro() {
        group = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // 이전에 방문 하였거나 주거가 아닐 경우에는 건너 뛰어라!
                if (visited[x][y] || complex[x][y] < '1') continue;
                // 갈 수 있는 칸인데, 방문처리 하지 않은, 즉 새롭게 만난 단지인 경우!
                groupCnt = 0;
                dfs(x, y);
                group.add(groupCnt);
            }
        }

        sb.append(group.size()).append("\n");
        Collections.sort(group);
        for (int cnt : group) {
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
