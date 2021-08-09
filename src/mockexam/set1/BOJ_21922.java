package mockexam.set1;

import part2.common.FastReader;

import java.util.LinkedList;
import java.util.Queue;

/* 학부 연구생 민상 */
public class BOJ_21922 {
    static FastReader fastReader = new FastReader();

    static int N, M; // 세로, 가로
    static int[][] matrix;
    static boolean[][][] visited; // 세로, 가로, 방향
    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하 , 좌, 우

    static class Vertex {
        int x;
        int y;
        int dir;

        public Vertex(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static void input() {
        N = fastReader.nextInt();
        M = fastReader.nextInt();

        matrix = new int[N][M];
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) matrix[i][j] = fastReader.nextInt();
        visited = new boolean[N][M][4];
    }

    static int changeWind(int mode, int dir) {
        if (mode == 1) { // 좌우 변경 변경
            if (dir == RIGHT) return LEFT;
            if (dir == LEFT) return RIGHT;
        }
        if (mode == 2) { // 상하 변경
            if (dir == UP) return DOWN;
            if (dir == DOWN) return UP;
        }
        if (mode== 3) {
            if (dir == UP) return RIGHT;
            if (dir == DOWN) return LEFT;
            if (dir == LEFT) return DOWN;
            if (dir == RIGHT) return UP;
        }
        if (mode == 4) {
            if (dir == UP) return LEFT;
            if (dir == DOWN) return RIGHT;
            if (dir == LEFT) return UP;
            if (dir == RIGHT) return DOWN;
        }
        return dir;
    }

    static void bfs() {
        Queue<Vertex> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 9) {
                    for (int x = 0; x < 4; x++) {
                        visited[i][j][x] = true;
                        queue.add(new Vertex(i, j, x));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Vertex pollVertex = queue.poll();

            int dir = pollVertex.dir;
            int nextX = pollVertex.x + direction[dir][0];
            int nextY = pollVertex.y + direction[dir][1];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue; // 탐색 가능한 범위인가?
            if (visited[nextX][nextY][dir]) continue; // 이미 방문한 적이 있는가?

            visited[nextX][nextY][dir] = true;
            switch (matrix[nextX][nextY]) {
                case 0:
                    queue.add(new Vertex(nextX, nextY, dir));
                    break;
                case 1: // 좌우를 변경
                    queue.add(new Vertex(nextX, nextY, changeWind(1, dir)));
                    break;
                case 2: // 상하를 변경
                    queue.add(new Vertex(nextX, nextY, changeWind(2, dir)));
                    break;
                case 3:
                    queue.add(new Vertex(nextX, nextY, changeWind(3, dir)));
                    break;
                case 4:
                    queue.add(new Vertex(nextX, nextY, changeWind(4, dir)));
                    break;
            }
        }

        int ans = findAvailableSeats();
        System.out.println(ans);
    }

    static int findAvailableSeats() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    if (visited[i][j][k]) {
                        count += 1;
                        break;
                    }
                }
            }
        }
        return count;
    }

    static void process() {
        bfs();
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
