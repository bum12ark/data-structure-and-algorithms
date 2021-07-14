package part2.graph.practice;

import part2.common.FastReader;

/* 양 */
public class BOJ_3184 {
    static FastReader fastReader = new FastReader();

    static int R, C, wolfCnt, sheepCnt, totalWolf, totalSheep; // 행, 열
    static char[][] yard;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0 , -1}, {0, 1}}; // direction: 상하좌우

    static void input() {
        R = fastReader.nextInt();
        C = fastReader.nextInt();
        yard = new char[R][C];
        for (int r = 0; r < R; r++) {
            yard[r] = fastReader.nextLine().toCharArray();
        }
        visited = new boolean[R][C];
    }
    
    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
        visited[x][y] = true; // 방문 처리
        if (yard[x][y] == 'o') sheepCnt += 1;
        if (yard[x][y] == 'v') wolfCnt += 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 지도를 벗어나는 곳으로 가는가?
            if (yard[nx][ny] == '#') continue; // 갈 수 있는 칸인지 확인해야 한다.
            if (visited[nx][ny]) continue; // 이미 방문한 적이 있는 곳인가?
            dfs(nx, ny);
        }
    }

    static void solution() {
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (visited[x][y]) continue; // 이미 방문한 곳인가?
                if (yard[x][y] == '#') continue; // 벽인가?
                if (yard[x][y] == '.') continue; // 길인가?

                wolfCnt = 0; sheepCnt = 0;
                dfs(x, y); // 탐색 시작

                if (wolfCnt < sheepCnt) { // 양과 늑대 수 판별
                    totalSheep += sheepCnt;
                } else {
                    totalWolf += wolfCnt;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(totalSheep + " " + totalWolf);
    }
}
