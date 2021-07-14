package part2.graph.review;

import part2.common.FastReader;

import java.util.*;

public class BOJ_2667_BFS {
    static FastReader fastReader = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static int N, groupCnt;
    static List<Integer> group;
    static char[][] complexes;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우


    static void input() {
        N = fastReader.nextInt();
        complexes = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) complexes[i] = fastReader.nextLine().toCharArray();
    }

    static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();

        visited[x][y] = true;
        que.add(x);
        que.add(y);

        while (!que.isEmpty()) {
            Integer qx = que.poll();
            Integer qy = que.poll();
            groupCnt += 1;
            for (int k = 0; k < 4; k++) {
                int nx = qx + dir[k][0];
                int ny = qy + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (complexes[nx][ny] == '0') continue;

                visited[nx][ny] = true;
                que.add(nx);
                que.add(ny);
            }
        }
    }

    static void solution() {
        group = new ArrayList<>();
        for (int x = 0; x < complexes.length; x++) {
            for (int y = 0; y < complexes[x].length; y++) {
                if (visited[x][y]) continue;
                if (complexes[x][y] == '0') continue;
                groupCnt = 0;
                bfs(x, y);
                group.add(groupCnt);
            }
        }
    }

    public static void main(String[] args) {
        input();
        solution();

        sb.append(group.size()).append("\n");
        Collections.sort(group);
        for (int cnt : group) sb.append(cnt).append("\n");
        System.out.println(sb);
    }
}
