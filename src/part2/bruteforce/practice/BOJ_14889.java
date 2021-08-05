package part2.bruteforce.practice;

import part2.common.FastReader;

import java.util.Arrays;

/* 스타트와 링크 */
public class BOJ_14889 {
    static FastReader fastReader = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, min;
    static int[][] table;
    static boolean[] visited;

    static void input() {
        N = fastReader.nextInt();
        visited = new boolean[N];
        table = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                table[i][j] = fastReader.nextInt();
            }
        }
    }

    static int minAbility() {
        int teamA = 0, teamB = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamA += table[i][j];
                    teamA += table[j][i];
                }
                else if (!visited[i] && !visited[j]) {
                    teamB += table[i][j];
                    teamB += table[j][i];
                }
            }
        }

        return Math.abs(teamA - teamB);
    }

    static void recFunc(int depth, int start) {
        if (depth == N / 2) {
            min = Math.min(minAbility(), min);
            return;
        }
        for (int cand = start; cand < N; cand++) {
            visited[cand] = true;
            recFunc(depth + 1, cand + 1);
            visited[cand] = false;
        }
    }

    static void process() {
        min = Integer.MAX_VALUE;
        recFunc(0, 0);
        System.out.println(min);
    }

    public static void main(String[] args) {
        input();
        process();
    }

}
