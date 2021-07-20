package part2.graph.review;

import part2.common.FastReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 탈출 */
public class BOJ_3055 {
    static FastReader fastReader = new FastReader();

    static int R, C; // 행, 열
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] matrix;
    static boolean[][] visited;
    static int[][] waterDist, hedgehogDist;

    static void input() {
        R = fastReader.nextInt(); C = fastReader.nextInt();
        visited = new boolean[R][C];
        waterDist = new int[R][C];
        hedgehogDist = new int[R][C];

        matrix = new char[R][C];
        for (int r = 0; r < R; r++) {
            matrix[r] = fastReader.nextLine().toCharArray();
        }
    }

    static void waterBfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                waterDist[x][y] = -1;
                visited[x][y] = false;
                if (matrix[x][y] == '*') {
                    visited[x][y] = true;
                    waterDist[x][y] = 0;
                    queue.add(x);
                    queue.add(y);
                }
            }
        }

        while (!queue.isEmpty()) {
            int px = queue.poll();
            int py = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = px + direction[k][0];
                int ny = py + direction[k][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 갈 수 있는 곳인가
                if (matrix[nx][ny] != '.') continue;
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                waterDist[nx][ny] = waterDist[px][py] + 1;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    static void hedgehogBfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                visited[x][y] = false;
                hedgehogDist[x][y] = -1;
                if (matrix[x][y] == 'S') {
                    visited[x][y] = true;
                    hedgehogDist[x][y] = 0;
                    queue.add(x);
                    queue.add(y);
                }
            }
        }

        while (!queue.isEmpty()) {
            int px = queue.poll();
            int py = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = px + direction[k][0];
                int ny = py + direction[k][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 갈 수 있는 곳인가
                if (matrix[nx][ny] != '.' && matrix[nx][ny] != 'D') continue; // 비어 있는 곳과 비버의 굴만 탐색
                if (visited[nx][ny]) continue; // 방문한적이 있냐?
                // 물이 차있는 공간이면서 고슴도치가 이동 불가능하냐?
                if (waterDist[nx][ny] != -1 && hedgehogDist[px][py] + 1 >= waterDist[nx][ny]) continue;

                visited[nx][ny] = true;
                hedgehogDist[nx][ny] = hedgehogDist[px][py] + 1;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    static void process() {
        // 물의 이동 경로 계산하기
        waterBfs();
        // 고슴 도치 이동 경로 계산하기
        hedgehogBfs();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 'D') {
                    if (hedgehogDist[i][j] > 0) {
                        System.out.println(hedgehogDist[i][j]);
                    } else {
                        System.out.println("KAKTUS");
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        input();
        process();
    }
}
