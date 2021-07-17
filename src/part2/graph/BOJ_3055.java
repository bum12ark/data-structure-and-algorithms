package part2.graph;

import part2.common.FastReader;

import java.util.*;

/* 탈출 */
public class BOJ_3055 {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static FastReader fastReader = new FastReader();

    static int R, C; // 행과 열
    static char[][] graph;
    static int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean[][] waterVisited, hedgehogVisited;
    static int[][] waterDist, hedgehogDist;

    static void input() {
        R = fastReader.nextInt();
        C = fastReader.nextInt();

        graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = fastReader.nextLine().toCharArray();
        }

        waterDist = new int[R][C];
        waterVisited = new boolean[R][C];
        hedgehogDist = new int[R][C];
        hedgehogVisited = new boolean[R][C];
    }

    static void waterBfs() {
        Queue<Pos> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                waterDist[i][j] = -1;
                if (graph[i][j] == '*') {
                    queue.add(new Pos(i, j));
                    waterDist[i][j] = 0;
                    waterVisited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + direction[k][0];
                int ny = p.y + direction[k][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (waterVisited[nx][ny]) continue;
                if (graph[nx][ny] != '.') continue;

                waterVisited[nx][ny] = true;
                waterDist[nx][ny] = waterDist[p.x][p.y] + 1;
                queue.add(new Pos(nx, ny));
            }
        }

    }

    static void hedgehogBfs() {
        Queue<Pos> queue = new LinkedList<>();

        for (int i = 0; i < R; i ++) {
            for (int j = 0; j < C; j++) {
                hedgehogDist[i][j] = -1;
                if (graph[i][j] == 'S') {
                    queue.add(new Pos(i, j));
                    hedgehogDist[i][j] = 0;
                    hedgehogVisited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + direction[k][0];
                int ny = p.y + direction[k][1];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (graph[nx][ny] != '.' && graph[nx][ny] != 'D') continue;
                if (waterDist[nx][ny] != -1 && hedgehogDist[p.x][p.y] + 1 >= waterDist[nx][ny]) continue;
                if (hedgehogVisited[nx][ny]) continue;

                queue.add(new Pos(nx, ny));
                hedgehogVisited[nx][ny] = true;
                hedgehogDist[nx][ny] = hedgehogDist[p.x][p.y] + 1;
            }
        }
    }

    static void solution() {
        // 물의 이동경로 파악
        waterBfs();
        hedgehogBfs();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'D') {
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
        solution();
    }
}
